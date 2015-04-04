package edu.luc.etl.cs313.android.simplestopwatch.model.time;

import static edu.luc.etl.cs313.android.simplestopwatch.common.Constants.*;
import static edu.luc.etl.cs313.android.simplestopwatch.common.Constants.MaX;
/*
* An implementation of the timer model
* @author Team10
 */

public class DefaultTimeModel implements TimeModel {

    private int runningTime = 0;

    private int StopTime = 0;
    /*
    Reset time to 0
     */
    @Override
    public void resetRuntime() {
        runningTime = 0;
    }
    /*
    Update running time
     */
    @Override
    public void incRuntime() {
        if ( runningTime < 99){
            runningTime = (runningTime + SEC_PER_TICK) % MaX;
        }
    }

    @Override
    public int getRuntime(){
        return runningTime;
    }

    @Override
    public int getStopTime() {
        return StopTime;
    }

    @Override
    public void resetStopTime() {
        StopTime = 0;
    }

    @Override
    public void StopTimeInc() {
        StopTime= (StopTime + SEC_PER_TICK) % MaX;
    }

    @Override
    public void RunTimeDec() {
        runningTime = (runningTime  - SEC_PER_TICK) % MaX ;
    }

}