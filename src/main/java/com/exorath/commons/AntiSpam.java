/*
 * Copyright 2017 Exorath
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package com.exorath.commons;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;

import java.util.HashSet;
import java.util.UUID;

/**
 * Created by toonsev on 6/3/2017.
 */
public class AntiSpam {
    private static HashSet<UUID> playerIds = new HashSet<>();

    public static synchronized boolean isSpamming(UUID uuid) {
        return playerIds.contains(uuid);
    }

    /**
     * 40 ticks default timeout
     *
     * @param plugin
     * @param uuid
     */
    public static synchronized void setSpamming(Plugin plugin, final UUID uuid) {
        if (playerIds.contains(uuid))
            return;
        playerIds.add(uuid);
        Bukkit.getScheduler().runTaskLater(plugin, () -> remove(uuid), 40);
    }

    public static synchronized void setSpamming(Plugin plugin, final UUID uuid, long ticksTimeout) {
        if (playerIds.contains(uuid))
            return;
        playerIds.add(uuid);
        Bukkit.getScheduler().runTaskLater(plugin, () -> remove(uuid), ticksTimeout);
    }

    private static synchronized void remove(UUID uuid) {
        playerIds.remove(uuid);
    }
}
