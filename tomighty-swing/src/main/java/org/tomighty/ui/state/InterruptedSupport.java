package org.tomighty.ui.state;

import org.tomighty.Phase;
import org.tomighty.bus.messages.timer.TimerTick;
import org.tomighty.time.Timer;
import org.tomighty.ui.theme.Colors;
import org.tomighty.ui.theme.colors.Gray;

import javax.inject.Inject;

import static javax.swing.SwingUtilities.invokeLater;

/**
 * Created by rpiaggio on 17-May-16.
 */
public abstract class InterruptedSupport extends UiStateSupport {

    @Inject
    protected Timer timer;

    @Override
    public Colors colors() {
        return Gray.instance();
    }

    protected abstract Phase phase();

    @Override
    public void afterRendering() {
        super.afterRendering();
        invokeLater(new Runnable() {
            @Override
            public void run() {
                // Forces showing time in tray.
                bus.publish(new TimerTick(timer.getInterruptedTime(), phase()));
            }
        });
    }

}
