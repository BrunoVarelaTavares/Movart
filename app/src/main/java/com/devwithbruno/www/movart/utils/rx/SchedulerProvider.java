package com.devwithbruno.www.movart.utils.rx;

import io.reactivex.Scheduler;

/**
 * Created by Bruno on 18/01/2018.
 */

public interface SchedulerProvider {

    Scheduler ui ();

    Scheduler computation ();

    Scheduler io();

}
