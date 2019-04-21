package com.devwithbruno.www.movart.di;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created by Bruno on 15/01/2018.
 */

@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface PerActivity {
}
