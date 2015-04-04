package edu.luc.etl.cs313.android.simplestopwatch.model.time;

/**
 * The passive data model of the Timer.
 * It does not emit any events.
 *@modified by Team10
 * @author laufer
 */
public interface TimeModel {
    void resetRuntime();
    void incRuntime();

    int getRuntime();

    public int getStopTime();
    void resetStopTime();
    void  StopTimeInc();
    void  RunTimeDec();
}