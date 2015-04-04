package edu.luc.etl.cs313.android.simplestopwatch.model.state;

import edu.luc.etl.cs313.android.simplestopwatch.R;
/**
 *
 * An implementation of the Stopped state for the timer.
 *@author Team10
 * Created by alshaymaaalhazzaa on 3/30/14.
 */
class StoppedState implements TimerState {

    public StoppedState(final TimerSMStateView sm) {
        this.sm = sm;
    }

    private final TimerSMStateView sm;

    @Override
    public void onStartStop() {
        sm.actionStart();
        sm.actionInc();
        sm.actionResetStopTime();
        sm.toStoppedState();

    }

/*
when the user stop pressing the button to increment seconds ,stop increment
& wait for 3 Seconds
 */

    @Override
    public void onTick() {
        sm.actionStopInc();
        sm.ThreeSecondsElapseState();

    }

    @Override
    public void updateView() {
        sm.updateUIStopTime();
    }

    @Override
    public int getId() {
        return R.string.STOPPED;
    }
}