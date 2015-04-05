package edu.luc.etl.cs313.android.simplestopwatch.model.clock;


public interface ClockModel extends OnTickSource {
    void start();
    void stop();

    void setRunnableScheduler(DirectExecutor directExecutor);


}