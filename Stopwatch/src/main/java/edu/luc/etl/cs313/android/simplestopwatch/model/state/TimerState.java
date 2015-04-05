package edu.luc.etl.cs313.android.simplestopwatch.model.state;

import edu.luc.etl.cs313.android.simplestopwatch.common.TimerUIListener;
import edu.luc.etl.cs313.android.simplestopwatch.model.clock.OnTickListener;


interface TimerState extends TimerUIListener, OnTickListener {
    void updateView();
    int getId();
}