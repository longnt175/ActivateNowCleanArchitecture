package com.activatenow.presentation.dependency.component;

import android.content.Context;
import android.content.SharedPreferences;

import com.activatenow.data.net.RestApi;
import com.activatenow.domain.executor.PostExecutionThread;
import com.activatenow.domain.executor.ThreadExecutor;
import com.activatenow.domain.repository.SessionRepository;
import com.activatenow.domain.repository.UserRepository;
import com.activatenow.presentation.dependency.module.ApplicationModule;
import com.activatenow.presentation.dependency.module.DataModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = { ApplicationModule.class, DataModule.class })
public interface ApplicationComponent {

    Context context();
    SharedPreferences sharedPreferences();
    ThreadExecutor threadExecutor();
    PostExecutionThread postExecutionThread();

    SessionRepository sessionRepository();
    RestApi restApi();
    UserRepository userRepository();
}
