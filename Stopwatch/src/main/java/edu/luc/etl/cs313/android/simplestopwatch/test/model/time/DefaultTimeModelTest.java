package edu.luc.etl.cs313.android.simplestopwatch.test.model.time;

import org.junit.After;
import org.junit.Before;

import edu.luc.etl.cs313.android.simplestopwatch.model.time.DefaultTimeModel;


public class DefaultTimeModelTest extends AbstractTimeModelTest {

    @Before
    public void setUp() throws Exception {
        setModel(new DefaultTimeModel());
    }

    @After
    public void tearDown() throws Exception {
        setModel(null);
    }
}