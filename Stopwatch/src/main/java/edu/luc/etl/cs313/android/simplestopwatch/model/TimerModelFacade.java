package edu.luc.etl.cs313.android.simplestopwatch.model;

import edu.luc.etl.cs313.android.simplestopwatch.common.TimerUIUpdateSource;
import edu.luc.etl.cs313.android.simplestopwatch.common.TimerUIListener;



public interface TimerModelFacade extends TimerUIListener, TimerUIUpdateSource {
    void onStart();
}