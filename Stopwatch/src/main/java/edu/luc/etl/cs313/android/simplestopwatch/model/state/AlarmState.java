package edu.luc.etl.cs313.android.simplestopwatch.model.state;

import edu.luc.etl.cs313.android.simplestopwatch.R;

public class AlarmState implements StopwatchState {

public AlarmState(final StopwatchSMStateView sm) {
    this.sm = sm;
}

    @Override
    public void onStartStop() {
        sm.actionStart();
        sm.toRunningState();
    }

    @Override
    public void onLapReset() {
        sm.actionReset();
        sm.toStoppedState();
    }

    @Override
    public void onTick() {
        throw new UnsupportedOperationException("onTick");
    }

    @Override
    public void updateView() {
        sm.updateUIRuntime();
    }

    @Override
    public int getId() {
        return R.string.ALARM;
    }
}
