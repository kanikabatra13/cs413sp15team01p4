package edu.luc.etl.cs313.android.simplestopwatch.common;


public interface TimerUIUpdateListener {
    void updateTime(int timeValue);
    void updateState(int stateId);
    void AlarmSound();
}