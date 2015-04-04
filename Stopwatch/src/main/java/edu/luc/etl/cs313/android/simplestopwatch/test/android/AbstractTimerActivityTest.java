package edu.luc.etl.cs313.android.simplestopwatch.test.android;
import android.content.pm.ActivityInfo;
import android.widget.Button;
import android.widget.TextView;

import org.junit.Test;

import edu.luc.etl.cs313.android.simplestopwatch.R;
import edu.luc.etl.cs313.android.simplestopwatch.android.TimerAdapter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * @author laufer
 * @modified by Team10
 * Abstract GUI-level test superclass of several essential stopwatch scenarios.
 */

public abstract class AbstractTimerActivityTest {

    /**
     * Verifies that the activity under test can be launched.
     */
    @Test
    public void testActivityCheckTestCaseSetUpProperly() {
        assertNotNull("activity should be launched successfully", getActivity());
    }


    /**
     * Verifies the following scenario:
     *        when time is 0, the state's name is stopped
     *         when the user click "Start/Stop" button 5 times, the state's name is stopped,
     *         the screen show the number of seconds "5"
     *         when 3 seconds elapsed, the state name changes to Running
     *
     */

    @Test
    public void testActivityScenarioRun() throws Throwable {
        runUiThreadTasks();
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                assertEquals(0, getDisplayedValue());
                assertEquals("Stopped", getStateName());
                clickButton(8);
                assertEquals("Stopped", getStateName());
                assertEquals(8, getDisplayedValue());
            }});
        Thread.sleep(3000);
        runUiThreadTasks();
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {

            }});
        Thread.sleep(3000);
        runUiThreadTasks();
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                assertEquals("Running", getStateName());
                clickButton(1);
                assertEquals("Stopped", getStateName());
            }});
    }

    /**
     * Verifies the following scenario::
     * when maximum value is 99, the state is stopped
     * after 3 seconds,  goes to running state, after 5 seconds, press start
     * state changes to stopped and time is 0
     **/
    @Test
    public void testActivity99() throws Throwable {
        runUiThreadTasks();
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                assertEquals(0, getDisplayedValue());
                assertEquals("Stopped", getStateName());
                clickButton(100);
                assertEquals("Stopped", getStateName());
                assertEquals(99, getDisplayedValue());
            }});
        Thread.sleep(3000);
        runUiThreadTasks();
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {

            }});
        Thread.sleep(3000);
        runUiThreadTasks();
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                assertEquals("Running", getStateName());
                clickButton(1);
                assertEquals("Stopped", getStateName());
            }});

    }

    /*
* Verifies the following scenario:
* When the user click the "Start/Stop" button for the first time
* the state name is stopped
*/
    @Test

    public void testActivityStopState() throws Throwable {
        runUiThreadTasks();
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                assertEquals(0, getDisplayedValue());
                clickButton(5);
                assertEquals("Stopped", getStateName());
                assertEquals(5, getDisplayedValue());
            }});
        Thread.sleep(3000);
    }

    /*
     * Verifies the following scenario:
         *        when time is 0, the state's name is stopped
         *         when the user click "Start/Stop" button 5 times, the state's name is stopped,
         *         the screen show the number of seconds "5"
         *         when 3 seconds elapsed, the state name changes to Running
         *        When the user click the button, the state name changes to stopped and time become 0
         */
    @Test
    public void testActivityScenarioReset() throws Throwable {
        getActivity().runOnUiThread(new Runnable() {
            @Override public void run() {
                assertEquals(0, getDisplayedValue());
                assertEquals("Stopped", getStateName());
                clickButton(5);
                assertEquals("Stopped", getStateName());
                assertEquals(5, getDisplayedValue());
            }});
        Thread.sleep(3000);
        runUiThreadTasks();
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {

            }});
        Thread.sleep(3000);
        runUiThreadTasks();
        getActivity().runOnUiThread(new Runnable() {

            @Override public void run() {
                assertEquals("Running", getStateName());
                clickButton(1);
                // assertTrue(getStartStopButton().performClick());
                assertEquals("Stopped", getStateName());
                assertEquals(0, getDisplayedValue());


            }});
    }


    /**
     * Verifies the following scenario:
     *          time is 0, state is  Stopped
     *          click button 5 times, State is stopped, view is 5
     *          wait 3 secs, state is now running
     *          wait 5 secs, remaining time is decreased to 0, state is in beepped
     *          press stop, state changes to stopped and time is 0
     *
     * @throws Throwable
     */
    @Test
    public void testActivitySoundState() throws Throwable {
        runUiThreadTasks();
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                assertEquals(0, getDisplayedValue());
                assertEquals("Stopped", getStateName());
                clickButton(5);
                assertEquals("Stopped", getStateName());
                assertEquals(5, getDisplayedValue());
            }
        });
        Thread.sleep(3000); // <-- do not run this in the UI thread!
        runUiThreadTasks();
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
            }
        });
        Thread.sleep(6000); // <-- do not run this in the UI thread!
        runUiThreadTasks();
        getActivity().runOnUiThread(new Runnable() { @Override
                                                     public void run() {
            assertEquals(0, getDisplayedValue());
            assertEquals("Alarm", getStateName());
        }});
        Thread.sleep(5000); // <-- do not run this in the UI thread!
        runUiThreadTasks();
        getActivity().runOnUiThread(new Runnable() { @Override
                                                     public void run() {
            clickButton(1);
            assertEquals("Stopped", getStateName());
            assertEquals(0, getDisplayedValue());
        }});
    }

    /* The app will maintain its state while rotation*/
    @Test
    public void testActivityScenarioRotation() throws Throwable {
        runUiThreadTasks();
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                assertEquals(0, getDisplayedValue());
                clickButton(8);
                assertEquals(8, getDisplayedValue());
                //  clickButton(1);
            }});
        Thread.sleep(3000); // <-- do not run this in the UI thread!
        runUiThreadTasks();
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
            }
        });
        getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        Thread.sleep(3000);
        runUiThreadTasks();
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
            }
        });
        getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        Thread.sleep(3000);
        runUiThreadTasks();
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                assertEquals("Running", getStateName());
                clickButton(1);
                assertEquals("Stopped", getStateName());
                assertEquals(0, getDisplayedValue());
            }
        });


    }

    /*
    the timer is initially at its minimum 0
     */
    @Test
    public void testInitiallyAtMin() throws Throwable {
        runUiThreadTasks();
        getActivity().runOnUiThread(new Runnable() { @Override
                                                     public void run() {
            assertEquals(0, getDisplayedValue());
        }});
      /*  Thread.sleep(2000);
    runUiThreadTasks();
    getActivity().runOnUiThread(new Runnable() {
        @Override
        public void run() {

        }
    });*/
    }

    /*
    times are correct after one tick
     */
    @Test
    public void testIncrementRuntimeOne() throws Throwable {


        //  runUiThreadTasks();
        getActivity().runOnUiThread(new Runnable() { @Override
                                                     public void run() {
            assertEquals(0, getDisplayedValue());
            assertEquals("Stopped", getStateName());
            clickButton(1);
            assertEquals(1, getDisplayedValue());

        }});
        Thread.sleep(3000);
    }



    // auxiliary methods for easy access to UI widgets

    protected abstract TimerAdapter getActivity();

    protected int tvToInt(final TextView t) {
        return Integer.parseInt(t.getText().toString().trim());
    }

    protected int getDisplayedValue() {
        final TextView ts = (TextView) getActivity().findViewById(R.id.seconds);
        return tvToInt(ts);
    }

    protected Button getStartStopButton() {
        return (Button) getActivity().findViewById(R.id.startStop);
    }

    protected String getStateName(){
        final TextView txtState = (TextView) getActivity().findViewById(R.id.stateName);
        return txtState.getText().toString();
    }
    public void clickButton(int n){
        for (int i = 0; i<n; i++)
            assertTrue(getStartStopButton().performClick());
    }
    protected void runUiThreadTasks() { }



}