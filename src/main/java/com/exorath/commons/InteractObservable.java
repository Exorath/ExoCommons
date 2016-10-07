/*
 * Copyright 2016 Exorath
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

import io.reactivex.Observable;
import org.bukkit.event.player.PlayerInteractEvent;

/**
 * An interface that can be applied to a clickable subject, this interface will emit an event whenever the subject is clicked.
 * Created by toonsev on 10/7/2016.
 */
public interface InteractObservable {

    /**
     * Returns a hot observable that emits an event whenever the subject is interacted with by a player.
     * This observable may complete when the subject dies/despawns.
     *
     * @return a hot observable that emits an event whenever the subject is interacted with by a player
     */
    Observable<PlayerInteractEvent> getObservableInteraction();
}
