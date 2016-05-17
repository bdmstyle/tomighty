package org.tomighty.ui.state.pomodoro;

import org.tomighty.time.Time;

/**
 * Created by rpiaggio on 16-May-16.
 */
public class ResumedPomodoro extends Pomodoro {
    @Override
    protected Time initialTime() {
        return timer.getInterruptedTime();
    }
}
