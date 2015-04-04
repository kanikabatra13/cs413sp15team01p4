package edu.luc.etl.cs313.android.simplestopwatch.model.state;

import edu.luc.etl.cs313.android.simplestopwatch.common.TimerUIUpdateSource;
import edu.luc.etl.cs313.android.simplestopwatch.common.TimerUIListener;
import edu.luc.etl.cs313.android.simplestopwatch.model.clock.OnTickListener;

/**
 * The state machine for the state-based dynamic model of the Timer.
 * This interface is part of the State pattern.
 *
 * @author laufer
 */
public interface TimerStateMachine extends TimerUIListener, OnTickListener, TimerUIUpdateSource, TimerSMStateView { }
