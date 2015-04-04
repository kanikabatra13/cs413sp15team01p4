package edu.luc.etl.cs313.android.simplestopwatch.model.state;

/**
 * The restricted view states have of their surrounding state machine.
 * This is a client-specific interface in Peter Coad's terminology.
 * @author laufer
 *@modified by Team10
 */
interface TimerSMStateView {

    // transitions
    void toRunningState();
    void toStoppedState();
    void toSoundState();
    void ThreeSecondsElapseState();

    // actions
    void actionInit();
    void actionReset();
    void actionStart();
    void actionStop();
    void actionInc();
    void actionUpdateView();
    void actionStopInc();
    void actionResetStopTime();
    void actionDecrement();
    void actionSound();

    // state-dependent UI updates
    void updateUIRuntime();
    void updateUISoundTime();
    void updateUIStopTime();
}