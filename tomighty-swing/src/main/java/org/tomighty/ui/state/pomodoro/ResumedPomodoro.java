package org.tomighty.ui.state.pomodoro;

import org.tomighty.time.Time;

/**
 * Created by rpiaggio on 16-May-16.
 */
public class ResumedPomodoro extends Pomodoro {
    @Override
    public void afterRendering() {
        Time time = timer.getInterruptedTime();
        remainingTime.setText(time.toString());
        timer.start(time, phase());
    }
}
