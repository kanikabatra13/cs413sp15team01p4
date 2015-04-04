package edu.luc.etl.cs313.android.simplestopwatch.model;

import edu.luc.etl.cs313.android.simplestopwatch.common.TimerUIUpdateListener;
import edu.luc.etl.cs313.android.simplestopwatch.model.clock.ClockModel;
import edu.luc.etl.cs313.android.simplestopwatch.model.clock.DefaultClockModel;
import edu.luc.etl.cs313.android.simplestopwatch.model.state.DefaultTimerStateMachine;
import edu.luc.etl.cs313.android.simplestopwatch.model.state.TimerStateMachine;
import edu.luc.etl.cs313.android.simplestopwatch.model.time.DefaultTimeModel;
import edu.luc.etl.cs313.android.simplestopwatch.model.time.TimeModel;

/**
 * An implementation of the model facade.

 * @author laufer
 */
public class ConcreteTimerModelFacade implements TimerModelFacade {

    private TimerStateMachine stateMachine;

    private ClockModel clockModel;

    private TimeModel timeModel;

    public ConcreteTimerModelFacade() {
        timeModel = new DefaultTimeModel();
        clockModel = new DefaultClockModel();
        stateMachine = new DefaultTimerStateMachine(timeModel, clockModel);
        clockModel.setOnTickListener(stateMachine);
    }

    @Override
    public void onStart() {
        stateMachine.actionInit();
    }

    @Override
    public void setUIUpdateListener(final TimerUIUpdateListener listener) {
        stateMachine.setUIUpdateListener(listener);
    }

    @Override
    public void onStartStop() {
        stateMachine.onStartStop();
    }



}