package com.activatenow.presentation.presenter;

import com.activatenow.domain.interactor.user.DeleteUserUseCase;
import com.activatenow.domain.interactor.user.DoLogoutUseCase;
import com.activatenow.presentation.dependency.ActivityScope;
import com.activatenow.presentation.view.BaseView;
import com.activatenow.presentation.view.SettingsView;

import javax.inject.Inject;

@ActivityScope
public class SettingsPresenter extends BasePresenter implements Presenter {

    private DoLogoutUseCase doLogoutUseCase;
    private DeleteUserUseCase deleteUserUseCase;
    SettingsView settingsView;

    @Inject
    public SettingsPresenter(DoLogoutUseCase doLogoutUseCase, DeleteUserUseCase deleteUserUseCase) {
        super(doLogoutUseCase, deleteUserUseCase);
        this.doLogoutUseCase = doLogoutUseCase;
        this.deleteUserUseCase = deleteUserUseCase;
    }

    @Override
    public void initWithView(BaseView view) {
        super.initWithView(view);
        this.settingsView = (SettingsView) view;
    }

    @Override
    public void destroy() {
        super.destroy();
        this.settingsView = null;
    }

    public void logoutUserButtonPressed() {
        this.doLogoutUseCase.execute(new BaseSubscriber<>());
        this.settingsView.closeAndDisplayLogin();
    }

    public void deleteAccountButtonPressed() {
        this.deleteUserUseCase.execute(new BaseSubscriber<>());
        this.settingsView.closeAndDisplayLogin();
    }

}
