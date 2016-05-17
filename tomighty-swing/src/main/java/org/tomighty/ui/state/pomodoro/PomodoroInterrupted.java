/*
 * Copyright (c) 2010-2012 Célio Cidral Junior.
 *
 *     Licensed under the Apache License, Version 2.0 (the "License");
 *     you may not use this file except in compliance with the License.
 *     You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 *     Unless required by applicable law or agreed to in writing, software
 *     distributed under the License is distributed on an "AS IS" BASIS,
 *     WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *     See the License for the specific language governing permissions and
 *     limitations under the License.
 */

package org.tomighty.ui.state.pomodoro;

import java.awt.*;

import javax.inject.Inject;
import javax.swing.Action;

import org.tomighty.Phase;
import org.tomighty.bus.messages.timer.TimerInterrupted;
import org.tomighty.bus.messages.timer.TimerTick;
import org.tomighty.bus.messages.ui.UiStateChanged;
import org.tomighty.time.Timer;
import org.tomighty.ui.state.InterruptedSupport;
import org.tomighty.ui.state.ToState;
import org.tomighty.ui.state.UiStateSupport;
import org.tomighty.ui.state.breaks.LongBreak;
import org.tomighty.ui.state.breaks.ShortBreak;
import org.tomighty.ui.theme.Colors;
import org.tomighty.ui.theme.colors.Gray;
import org.tomighty.ui.theme.colors.Red;

import static javax.swing.SwingUtilities.invokeLater;

public class PomodoroInterrupted extends InterruptedSupport {

    @Override
    protected Phase phase() {
        return Phase.POMODORO;
    }

    @Override
    protected String title() {
        return "Paused";
    }

    @Override
    protected boolean displaysGauge() {
        return true;
    }

    @Override
    protected Component createContent() {
        return labelFactory.big(timer.getInterruptedTime().toString());
    }

    @Override
    protected Action[] primaryActions() {
        return new Action[]{
                new ToState(messages.get("Resume"), ResumedPomodoro.class)
        };
    }

    @Override
    protected Action[] secondaryActions() {
        return new Action[]{
                new ToState(messages.get("Restart"), Pomodoro.class),
                new ToState(messages.get("Short break"), ShortBreak.class),
                new ToState(messages.get("Long break"), LongBreak.class)
        };
    }

}
