package edu.luc.etl.cs313.android.simplestopwatch.model.state;

import edu.luc.etl.cs313.android.simplestopwatch.R;

/**
 *
 * An implementation of the Sound state for the timer.
 *@author Team10
 * Created by alshaymaaalhazzaa on 3/30/14.
 */


class SoundState implements TimerState {

    public SoundState(final TimerSMStateView sm) {
        this.sm = sm;
    }

    private final TimerSMStateView sm;

    @Override
    public void onStartStop() {
        sm.actionStop();
        sm.toStoppedState();
    }
/*
 on each tick, Alarm ringing
 */

    @Override
    public void onTick() {
        sm.actionSound();
        sm.toSoundState();
    }

    @Override
    public void updateView() {
        sm.updateUISoundTime();
    }

    @Override
    public int getId() {
        return R.string.SOUND;
    }
}