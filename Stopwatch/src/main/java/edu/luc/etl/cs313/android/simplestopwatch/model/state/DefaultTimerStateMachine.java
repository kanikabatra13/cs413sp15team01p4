package edu.luc.etl.cs313.android.simplestopwatch.model.state;

import edu.luc.etl.cs313.android.simplestopwatch.common.TimerUIUpdateListener;
import edu.luc.etl.cs313.android.simplestopwatch.model.clock.ClockModel;
import edu.luc.etl.cs313.android.simplestopwatch.model.time.TimeModel;


public class DefaultTimerStateMachine implements TimerStateMachine {

    public DefaultTimerStateMachine(final TimeModel timeModel, final ClockModel clockModel) {
        this.timeModel = timeModel;
        this.clockModel = clockModel;
    }

    private final TimeModel timeModel;

    private final ClockModel clockModel;

    /**
     * The internal state of this adapter component. Required for the State pattern.
     */
    private TimerState state;

    protected void setState(final TimerState state) { //update state
        this.state = state;
        uiUpdateListener.updateState(state.getId());
    }

    private TimerUIUpdateListener uiUpdateListener;

    @Override
    public void setUIUpdateListener(final TimerUIUpdateListener uiUpdateListener) {
        this.uiUpdateListener = uiUpdateListener;
    }

    // forward event uiUpdateListener methods to the current state
    @Override public void onStartStop() { state.onStartStop(); }
    @Override public void onTick()      { state.onTick(); }

    @Override public void updateUIRuntime() { uiUpdateListener.updateTime(timeModel.getRuntime()); }
    @Override public void updateUISoundTime() {uiUpdateListener.updateTime(0); }
    @Override public void updateUIStopTime() {uiUpdateListener.updateTime(timeModel.getRuntime()); }



    // known states
    private final TimerState STOPPED     = new StoppedState(this);
    private final TimerState RUNNING     = new RunningState(this);
    private final TimerState SOUND       = new SoundState(this);

    // transitions
    @Override public void toRunningState(){
        if (timeModel.getRuntime()==0) {
            setState(SOUND);
            uiUpdateListener.AlarmSound();
        } else setState(RUNNING);}

    @Override public void ThreeSecondsElapseState() {
        if (timeModel.getRuntime()> 0  && timeModel.getStopTime() == 3 ){
            setState(RUNNING);
            uiUpdateListener.AlarmSound();
        }
        else
            setState(STOPPED);
    }
    @Override public void toStoppedState()    { setState(STOPPED); }
    @Override public void toSoundState()       { setState(SOUND); }


    // actions
    @Override public void actionInit()       { toStoppedState(); actionReset(); }
    @Override public void actionResetStopTime()   { timeModel.resetStopTime();}
    @Override public void actionStopInc()    { timeModel.StopTimeInc();}
    @Override public void actionReset()      { timeModel.resetRuntime(); actionUpdateView(); }
    @Override public void actionStart()      {
        if (timeModel.getRuntime()== 0)
            clockModel.start();
    }
    @Override public void actionStop()       {
        clockModel.stop();
        timeModel.resetRuntime();
        timeModel.resetStopTime();
        actionUpdateView(); }
    @Override public void actionSound()       { uiUpdateListener.AlarmSound();}
    @Override public void actionInc()        { timeModel.incRuntime(); actionUpdateView(); }
    @Override public void actionDecrement()        { timeModel.RunTimeDec(); actionUpdateView();}
    @Override public void actionUpdateView() { state.updateView(); }
}