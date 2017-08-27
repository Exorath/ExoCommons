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

package com.exorath.commons.hud;

import com.exorath.exoHUD.HUDText;
import com.exorath.exoHUD.texts.ChatColorText;
import com.exorath.exoHUD.texts.CompositeText;
import com.exorath.exoHUD.texts.IterateText;
import com.exorath.exoHUD.texts.PlainText;

import io.reactivex.schedulers.Schedulers;
import net.md_5.bungee.api.ChatColor;

import java.util.concurrent.TimeUnit;

/**
 * Created by toonsev on 8/27/2017.
 */
public class ExorathText extends IterateText{
    private static final HUDText[] ITERATES =  new HUDText[]{
        new ChatColorText(new PlainText("EXORATH")).color(ChatColor.GREEN).bold(true),
                new ChatColorText(new PlainText("EXORATH")).color(ChatColor.GREEN).bold(true),
                new ChatColorText(new PlainText("EXORATH")).color(ChatColor.GREEN).bold(true),
                new ChatColorText(new PlainText("EXORATH")).color(ChatColor.GREEN).bold(true),
                new CompositeText(new ChatColorText(new PlainText("E")).color(ChatColor.WHITE).bold(true), new ChatColorText(new PlainText("XORATH")).color(ChatColor.GREEN).bold(true)),
                new CompositeText(new ChatColorText(new PlainText("EX")).color(ChatColor.WHITE).bold(true), new ChatColorText(new PlainText("ORATH")).color(ChatColor.GREEN).bold(true)),
                new CompositeText(new ChatColorText(new PlainText("EXO")).color(ChatColor.WHITE).bold(true), new ChatColorText(new PlainText("RATH")).color(ChatColor.GREEN).bold(true)),
                new CompositeText(new ChatColorText(new PlainText("EXOR")).color(ChatColor.WHITE).bold(true), new ChatColorText(new PlainText("ATH")).color(ChatColor.GREEN).bold(true)),
                new CompositeText(new ChatColorText(new PlainText("EXORA")).color(ChatColor.WHITE).bold(true), new ChatColorText(new PlainText("TH")).color(ChatColor.GREEN).bold(true)),
                new CompositeText(new ChatColorText(new PlainText("EXORAT")).color(ChatColor.WHITE).bold(true), new ChatColorText(new PlainText("H")).color(ChatColor.GREEN).bold(true)),
                new CompositeText(new ChatColorText(new PlainText("EXORATH")).color(ChatColor.WHITE).bold(true)),
                new CompositeText(new ChatColorText(new PlainText("EXORATH")).color(ChatColor.GREEN).bold(true)),
                new CompositeText(new ChatColorText(new PlainText("EXORATH")).color(ChatColor.WHITE).bold(true))
    };

    public ExorathText() {
        super(300, TimeUnit.MILLISECONDS, Schedulers.io(), ITERATES);
    }
}
