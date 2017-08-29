package com.activatenow.presentation;

import com.activatenow.presentation.dependency.ActivityScope;
import com.activatenow.presentation.presenter.LoginPresenter;
import com.activatenow.presentation.presenter.RegisterPresenter;
import com.activatenow.presentation.presenter.ResetPasswordPresenter;
import com.activatenow.presentation.presenter.SettingsPresenter;

import org.mockito.Mockito;

import dagger.Module;
import dagger.Provides;

@Module
public class TestMockerModule {

    @Provides @ActivityScope
    LoginPresenter provideLoginPresenter() {
        return Mockito.mock(LoginPresenter.class);
    }

    @Provides @ActivityScope
    RegisterPresenter provideRegisterPresenter() {
        return Mockito.mock(RegisterPresenter.class);
    }

    @Provides @ActivityScope
    SettingsPresenter provideSettingsPresenter() {
        return Mockito.mock(SettingsPresenter.class);
    }

    @Provides @ActivityScope
    ResetPasswordPresenter provideResetPasswordPresenter() {
        return Mockito.mock(ResetPasswordPresenter.class);
    }

}
