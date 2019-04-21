package com.devwithbruno.www.movart.ui.base;

import android.app.ProgressDialog;
import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleRegistry;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import android.widget.Toast;

import com.devwithbruno.www.movart.App;
import com.devwithbruno.www.movart.R;
import com.devwithbruno.www.movart.di.component.ActivityComponent;
import com.devwithbruno.www.movart.di.component.DaggerActivityComponent;
import com.devwithbruno.www.movart.di.module.ActivityModule;
import com.devwithbruno.www.movart.utils.NetworkUtils;
import com.devwithbruno.www.movart.utils.Utils;

import butterknife.Unbinder;

/**
 * Created by Bruno on 15/01/2018.
 */

public abstract class BaseActivity extends AppCompatActivity
        implements MvpView, BaseFragment.Callback{


    private ProgressDialog mProgressDialog;

    private ActivityComponent mActivityComponent;

    private Unbinder mUnbinder;

    private final LifecycleRegistry lifecycleRegistry = new LifecycleRegistry(this);

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivityComponent = DaggerActivityComponent.builder()
                .activityModule(new ActivityModule(this))
                .applicationComponent(((App) getApplication()).getComponent())
                .build();
    }


    public ActivityComponent getActivityComponent(){
        return mActivityComponent;
    }

    @Override
    public Lifecycle getLifecycle() {
        return lifecycleRegistry;
    }

    @Override
    public void showLoading() {
        hideLoading();
        mProgressDialog = Utils.showLoadingDialog(this);

    }

    @Override
    public void hideLoading() {
        if (mProgressDialog != null && mProgressDialog.isShowing()){
            mProgressDialog.hide();
        }

    }

    private void showSnackBar(String message){
        Snackbar snackbar = Snackbar.make(findViewById(android.R.id.content),
                message, Snackbar.LENGTH_SHORT);
        View sbView = snackbar.getView();
        TextView textView = (TextView) sbView
                .findViewById(android.support.design.R.id.snackbar_text);
        textView.setTextColor(ContextCompat.getColor(this, R.color.white));
        snackbar.show();
    }




    @Override
    public void onError(@StringRes  int resId) {
        onError(getString(resId));

    }

    @Override
    public void onError(String message) {
        if (message != null){
            showSnackBar(message);
        }else {
            showSnackBar(getString(R.string.some_error));
        }

    }

    @Override
    public void showMessage(String message) {
        if (message != null){
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this, R.string.some_error, Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void showMessage(int resId) {
        showMessage(getString(resId));

    }

    @Override
    public boolean isNetworkConnected() {
        return NetworkUtils.isNetworkConnected(getApplicationContext());
    }

    @Override
    public void hideKeyboard() {
        View view = this.getCurrentFocus();
        if (view != null){
            InputMethodManager imm = (InputMethodManager)
                    getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    @Override
    public void onFragmentAttached() {

    }

    @Override
    public void onFragmentDetached(String tag) {

    }


    public void setUnBinder(Unbinder mUnbinder) {
        this.mUnbinder = mUnbinder;
    }

    @Override
    protected void onDestroy() {
        if (mUnbinder != null){
            mUnbinder.unbind();
        }

        super.onDestroy();
    }


    protected  abstract  void setUp();
}
