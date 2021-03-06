package edu.luc.etl.cs313.android.simplestopwatch.test.model.clock;

import org.junit.After;
import org.junit.Before;

import edu.luc.etl.cs313.android.simplestopwatch.model.clock.DefaultClockModel;

public class DefaultClockModelTest extends AbstractClockModelTest {

    @Before
    public void setUp() throws Exception {
        setModel(new DefaultClockModel());
        getModel().setRunnableScheduler(new DirectExecutor());
    }

    @After
    public void tearDown() throws Exception {
        setModel(null);
    }
}

