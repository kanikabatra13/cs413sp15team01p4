package edu.luc.etl.cs313.android.simplestopwatch.model.state;

import edu.luc.etl.cs313.android.simplestopwatch.R;



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