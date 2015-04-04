package edu.luc.etl.cs313.android.simplestopwatch.android;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;
import android.app.Activity;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;
import android.media.Ringtone;
import java.io.IOException;
import java.io.Serializable;

import java.io.Serializable;

import edu.luc.etl.cs313.android.simplestopwatch.R;
import edu.luc.etl.cs313.android.simplestopwatch.common.Constants;
import edu.luc.etl.cs313.android.simplestopwatch.common.StopwatchUIUpdateListener;
import edu.luc.etl.cs313.android.simplestopwatch.model.ConcreteStopwatchModelFacade;
import edu.luc.etl.cs313.android.simplestopwatch.model.StopwatchModelFacade;

/**
 * A thin adapter component for the stopwatch.
 *
 * @author laufer
 */
public class StopwatchAdapter extends Activity implements StopwatchUIUpdateListener {

    private static String TAG = "stopwatch-android-activity";
    private static Ringtone ringtone;
    private static boolean ringing;

	/**
	 * The state-based dynamic model.
	 */
	private StopwatchModelFacade model;

	protected void setModel(final StopwatchModelFacade model) {
		this.model = model;
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// inject dependency on view so this adapter receives UI events
		setContentView(R.layout.activity_main);
		// inject dependency on model into this so model receives UI events
		this.setModel(new ConcreteStopwatchModelFacade());
		// inject dependency on this into model to register for UI updates
		model.setUIUpdateListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

	@Override
	protected void onStart() {
		super.onStart();
		model.onStart();
	}

	// TODO remaining lifecycle methods

	/**
	 * Updates the seconds and minutes in the UI.
	 * @param time
	 */
	public void updateTime(final int time) {
        // UI adapter responsibility to schedule incoming events on UI thread
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                final TextView tvS = (TextView) findViewById(R.id.seconds);
             //   final TextView tvM = (TextView) findViewById(R.id.minutes);
                final int seconds = time % Constants.SEC_PER_MIN;
                final int minutes = time / Constants.SEC_PER_MIN;
                tvS.setText(Integer.toString(seconds / 10) + Integer.toString(seconds % 10));
             //   tvM.setText(Integer.toString(minutes / 10) + Integer.toString(minutes % 10));
            }
        });
	}

	/**
	 * Updates the state name in the UI.
	 * @param stateId
	 */
	public void updateState(final int stateId) {
        // UI adapter responsibility to schedule incoming events on UI thread
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                final TextView stateName = (TextView) findViewById(R.id.stateName);
                stateName.setText(getString(stateId));
            }
        });
	}

	// forward event listener methods to the model
	public void onStartStop(final View view) {
        model.onStartStop();
    }

	//public void onLapReset(final View view)  {model.onLapReset();



    @Override
    public void onSaveInstanceState(final Bundle savedInstanceState) {
        Log.i(TAG, "onSaveInstanceState");

        // save model information
        savedInstanceState.putSerializable(getString(R.string.model_key), (Serializable) model);

        final TextView seconds = (TextView) findViewById(R.id.seconds);
        final TextView stateName = (TextView) findViewById(R.id.stateName);
        // save whether the app is ringing
        savedInstanceState.putBoolean(getString(R.string.ringing_key), ringing);
        // save display state
        savedInstanceState.putString(getString(R.string.state_key), stateName.getText().toString());
        // save display time
        savedInstanceState.putString(getString(R.string.seconds_key), seconds.getText().toString());
        super.onSaveInstanceState(savedInstanceState);
        ringtone.stop();
    }

    /**
     * Restores the model state after situations such device rotation.
     */
    @Override
    public void onRestoreInstanceState(final Bundle savedInstanceState) {
        Log.i(TAG, "onRestoreInstanceState");
        super.onRestoreInstanceState(savedInstanceState);

        final TextView seconds = (TextView) findViewById(R.id.seconds);
        final TextView stateName = (TextView) findViewById(R.id.stateName);

        // restore model information
        model = (StopwatchModelFacade) savedInstanceState.getSerializable(getString(R.string.model_key));
        // restore display time
        seconds.setText(savedInstanceState.getString(getString(R.string.seconds_key)));
        // restore display state
        stateName.setText(savedInstanceState.getString(getString(R.string.state_key)));
        // restore whether the app is ringing
        ringing = savedInstanceState.getBoolean(getString(R.string.ringing_key));

        if (ringing) {
            ringtone.play();
        }

        model.setUIUpdateListener(this);
    }

}
