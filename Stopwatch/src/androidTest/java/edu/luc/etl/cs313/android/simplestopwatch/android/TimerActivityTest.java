package edu.luc.etl.cs313.android.simplestopwatch.android;
import android.annotation.TargetApi;
import android.os.Build;
import android.test.ActivityInstrumentationTestCase2;

import edu.luc.etl.cs313.android.simplestopwatch.test.android.AbstractTimerActivityTest;



public class TimerActivityTest extends ActivityInstrumentationTestCase2<TimerAdapter> {

    /**
     * Creates an {@link ActivityInstrumentationTestCase2} for the
     * {@linkSkeletonActivity} activity.
     */
    @TargetApi(Build.VERSION_CODES.FROYO)
    public  TimerActivityTest() {
        super(TimerAdapter.class);
        actualTest = new AbstractTimerActivityTest() {
            @Override
            protected TimerAdapter getActivity() {
                // return activity instance provided by instrumentation test
                return  TimerActivityTest.this.getActivity();
            }
        };
    }

    private AbstractTimerActivityTest actualTest;

    public void testActivityCheckTestCaseSetUpProperly() {
        actualTest.testActivityCheckTestCaseSetUpProperly();
    }

    public void testActivityScenarioRun() throws Throwable {
        actualTest.testActivityScenarioRun();
    }
    public void testActivityScenarioReset()throws Throwable{  actualTest.testActivityScenarioReset();}


    public void testActivityStopState() throws Throwable {
        actualTest.testActivityStopState();
    }


    public void test99() throws Throwable {
        actualTest.testActivity99();
    }

    public void testActivitySound() throws Throwable {
        actualTest.testActivitySoundState();
    }

    public void testActivityScenarioRotation() throws Throwable {
        actualTest.testActivityScenarioRotation();
    }
    public void testInitiallyAtMin() throws Throwable {
        actualTest.testInitiallyAtMin();
    }
    public void testIncrementRuntimeOne()throws Throwable {
        actualTest.testIncrementRuntimeOne();
    }


}