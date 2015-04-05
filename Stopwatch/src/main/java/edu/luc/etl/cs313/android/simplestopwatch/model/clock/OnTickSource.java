package edu.luc.etl.cs313.android.simplestopwatch.model.clock;


public interface OnTickSource {
    void setOnTickListener(OnTickListener listener);

    void setRunnableScheduler(DirectExecutor directExecutor);
}