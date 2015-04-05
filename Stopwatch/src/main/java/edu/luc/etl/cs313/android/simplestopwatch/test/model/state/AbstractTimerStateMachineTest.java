package edu.luc.etl.cs313.android.simplestopwatch.test.model.state;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import edu.luc.etl.cs313.android.simplestopwatch.R;
import edu.luc.etl.cs313.android.simplestopwatch.common.TimerUIUpdateListener;
import edu.luc.etl.cs313.android.simplestopwatch.model.clock.ClockModel;
import edu.luc.etl.cs313.android.simplestopwatch.model.clock.OnTickListener;
import edu.luc.etl.cs313.android.simplestopwatch.model.state.TimerStateMachine;
import edu.luc.etl.cs313.android.simplestopwatch.model.time.TimeModel;

import static org.junit.Assert.assertEquals;


public abstract class AbstractTimerStateMachineTest {

    private TimerStateMachine model;

    private UnifiedMockDependency dependency;

    @Before
    public void setUp() throws Exception {
        dependency = new UnifiedMockDependency();
    }

    @After
    public void tearDown() {
        dependency = null;
    }

    /**
     * Setter for dependency injection. Usually invoked by concrete testcase
     * subclass.
     *
     * @param model
     */
    protected void setModel(final TimerStateMachine model) {
        this.model = model;
        if (model == null)
            return;
        this.model.setUIUpdateListener(dependency);
        this.model.actionInit();
    }

    protected UnifiedMockDependency getDependency() {
        return dependency;
    }

    /**
     * Verifies that we're initially in the stopped state (and told the listener
     * about it).
     */
    @Test
    public void testPreconditions() {
        assertEquals(R.string.STOPPED, dependency.getState());
    }

    /**
     * Verifies the following scenario: time is 0, press start, wait 3+ seconds,
     * expect time 3.
     */
    @Test
    public void testScenarioRun() {
        assertStopTimeEquals(0);
        // directly invoke the button press event handler methods
        model.onStartStop();
        onTickRepeat(2);
        assertStopTimeEquals(2);
    }

    /**
     * Sends the given number of tick events to the model.
     *
     * @param n the number of tick events
     */
    protected void onTickRepeat(final int n) {
        for (int i = 0; i < n; i++)
            model.onTick();
    }



    /**
     * Checks whether the model has invoked the expected stop time-keeping
     * methods on the mock object.
     */
    protected void assertStopTimeEquals(final int t) {
        assertEquals(t, dependency.getStopTime());
    }

}


class UnifiedMockDependency implements TimeModel, ClockModel, TimerUIUpdateListener {

    private int timeValue = -1, stateId = -1;

    private int runningTime = 0, stopTime = 0;

    private boolean started = false;

    public int getTime() {
        return timeValue;
    }

    public int getState() {
        return stateId;
    }

    public boolean isStarted() {
        return started;
    }

    @Override
    public void updateTime(final int timeValue) {
        this.timeValue = timeValue;
    }

    @Override
    public void updateState(final int stateId) {
        this.stateId = stateId;
    }

    @Override
    public void AlarmSound() {
    }


    @Override
    public void setOnTickListener(OnTickListener listener) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void start() {
        started = true;
    }

    @Override
    public void stop() {
        started = false;
    }

    @Override
    public void setRunnableScheduler(edu.luc.etl.cs313.android.simplestopwatch.model.clock.DirectExecutor directExecutor) {

    }



    @Override
    public void resetRuntime() {
        runningTime = 0;
    }

    @Override
    public void incRuntime() {

    }

    @Override
    public int getRuntime() {
        return 0;
    }


    @Override
    public void resetStopTime() {
        stopTime = 0;
    }


    @Override
    public void RunTimeDec() {
        runningTime--;
    }


    public void incRunTime() {
        if (runningTime < 99)
            runningTime++;
    }

    @Override
    public void StopTimeInc() {
        stopTime++;
    }


    public int getRunTime() {
        return runningTime;
    }


    @Override
    public int getStopTime() {
        return stopTime;
    }
}
