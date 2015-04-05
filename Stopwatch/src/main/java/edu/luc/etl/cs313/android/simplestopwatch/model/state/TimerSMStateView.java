package edu.luc.etl.cs313.android.simplestopwatch.model.state;


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