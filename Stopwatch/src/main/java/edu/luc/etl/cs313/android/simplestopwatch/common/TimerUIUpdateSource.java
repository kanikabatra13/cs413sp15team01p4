package edu.luc.etl.cs313.android.simplestopwatch.common;

/**
 * A source of UI update events for the Timer.
 * This interface is typically implemented by the model.
 * @author laufer
 *@modified by Team10
 */
public interface TimerUIUpdateSource {
    void setUIUpdateListener(TimerUIUpdateListener listener);
}