package edu.luc.etl.cs313.android.simplestopwatch.model.state;

import edu.luc.etl.cs313.android.simplestopwatch.common.TimerUIUpdateSource;
import edu.luc.etl.cs313.android.simplestopwatch.common.TimerUIListener;
import edu.luc.etl.cs313.android.simplestopwatch.model.clock.OnTickListener;


public interface TimerStateMachine extends TimerUIListener, OnTickListener, TimerUIUpdateSource, TimerSMStateView { }
