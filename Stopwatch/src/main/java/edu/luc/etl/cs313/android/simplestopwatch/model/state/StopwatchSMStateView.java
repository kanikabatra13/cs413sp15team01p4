package edu.luc.etl.cs313.android.simplestopwatch.model.state;

/**
 * The restricted view states have of their surrounding state machine.
 * This is a client-specific interface in Peter Coad's terminology.
 *
 * @author laufer
 */
interface StopwatchSMStateView {

	// transitions
	void toRunningState();
	void toStoppedState();
    void toAlarmState();
    void toActiveState();
	/*void toLapRunningState();
	void toLapStoppedState(); */

	// actions
	void actionInit();
	void actionReset();
	void actionStart();
	void actionStop();
	//void actionLap();
	void actionInc();
	void actionUpdateView();
    void actionStopInc();
    void actionResetStopTime();
    void actionDecrement();
    void actionAlarm();

	// state-dependent UI updates
	void updateUIRuntime();
	void updateUIAlarmTime();
    void updateUIStopTime();
}
