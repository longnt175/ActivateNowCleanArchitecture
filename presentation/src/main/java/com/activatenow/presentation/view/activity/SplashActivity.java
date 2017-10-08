package com.activatenow.presentation.view.activity;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.activatenow.presentation.BaseApplication;
import com.activatenow.presentation.dependency.component.ViewInjector;
import com.activatenow.presentation.presenter.SplashPresenter;
import com.activatenow.presentation.view.SplashView;

import javax.inject.Inject;


public class SplashActivity extends AppCompatActivity implements SplashView {
    private static final int SPLASH_TIME_OUT = 2000;
    @Inject
    SplashPresenter splashPresenter;
    private ViewInjector viewInjector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.initializeActivityComponent();
//        		setContentView(R.layout.activity_layout);
        this.viewInjector.inject(this);
        splashPresenter.initWithView(this);
        new Handler().postDelayed(() -> splashPresenter.checkSession(), SPLASH_TIME_OUT);
    }

    private void initializeActivityComponent() {
        if (this.viewInjector == null) {
            this.viewInjector = ((BaseApplication)getApplication()).getViewInjector();
        }
    }
    @Override
    public Context context() {
        return getApplicationContext();
    }

    @Override
    public void showLoader() {

    }

    @Override
    public void hideLoader() {

    }

    @Override
    public void handleError(Throwable error) {

    }

    @Override
    public void showMessage(String message) {

    }

    @Override
    public void close() {
        this.finish();
    }

    @Override
    public void closeAndDisplayLogin() {
        Intent notesIntent = new Intent(this, LoginActivity.class);
        notesIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(notesIntent);
        close();
    }

    @Override
    public void openLoginByPin() {
        Intent i = new Intent(context(), LoginActivity.class);
        startActivity(i);
        close();
    }

    @Override
    public void openHome() {
        Intent i = new Intent(context(), MainActivity.class);
        startActivity(i);
        close();
    }
}
