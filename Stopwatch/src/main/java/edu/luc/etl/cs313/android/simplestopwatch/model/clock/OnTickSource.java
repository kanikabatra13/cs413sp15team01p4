package edu.luc.etl.cs313.android.simplestopwatch.model.clock;

/**
 * A source of onTick events for the Timer.
 * This interface is typically implemented by the model.
 *
 * @author laufer
 */
public interface OnTickSource {
    void setOnTickListener(OnTickListener listener);

    void setRunnableScheduler(DirectExecutor directExecutor);
}