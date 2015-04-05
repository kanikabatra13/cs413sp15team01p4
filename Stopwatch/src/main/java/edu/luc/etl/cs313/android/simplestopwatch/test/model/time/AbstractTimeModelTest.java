package edu.luc.etl.cs313.android.simplestopwatch.test.model.time;

import org.junit.Test;

import edu.luc.etl.cs313.android.simplestopwatch.model.time.TimeModel;

import static edu.luc.etl.cs313.android.simplestopwatch.common.Constants.MIN;
import static edu.luc.etl.cs313.android.simplestopwatch.common.Constants.SEC_PER_TICK;
import static org.junit.Assert.assertEquals;



public abstract class AbstractTimeModelTest {

    private TimeModel model;

    /**
     * Setter for dependency injection. Usually invoked by concrete testcase
     * subclass.
     *
     * @param model
     */
    protected void setModel(final TimeModel model) {
        this.model = model;
    }

    /**
     * Verifies that runtime and Stoptime are initially 0
     */
    @Test
    public void testPreconditions() {
        assertEquals(0, model.getRuntime());
        assertEquals(0, model.getStopTime());
    }

    /**
     * Verifies that runtime and stoptime is incremented correctly.
     */
    @Test
    public void testIncrementRuntimeOne() {
        final int rt = model.getRuntime();
        final int st = model.getStopTime();
        model.incRuntime();
        model.StopTimeInc();
        assertEquals((rt + SEC_PER_TICK) % MIN, model.getRuntime());
        assertEquals((st + SEC_PER_TICK) % MIN, model.getStopTime());
        //  model.RunTimeDec();
        model.resetStopTime();
        assertEquals(0, st);
        //  assertEquals((rt - SEC_PER_TICK) % MIN, model.getRunTime()-1);
    }


    /**
     * Verifies that runtime works correctly.
     */
    @Test
    public void testRuntime() {
        final int rt = model.getRuntime();
        for (int i = 0; i < 5; i++) {
            model.incRuntime();
        }
        assertEquals(rt + 5, model.getRuntime());
        for (int i = 0; i < 5; i++) {
            model.RunTimeDec();
        }
        assertEquals(rt, model.getRuntime());

    }
}