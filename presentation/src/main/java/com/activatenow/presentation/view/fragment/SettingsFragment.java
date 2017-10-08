package com.activatenow.presentation.view.fragment;

import com.activatenow.presentation.R;
import com.activatenow.presentation.presenter.BasePresenter;
import com.activatenow.presentation.presenter.SettingsPresenter;
import com.activatenow.presentation.view.SettingsView;

import javax.inject.Inject;

import butterknife.OnClick;

public class SettingsFragment extends BaseFragment implements SettingsView {

    @Inject SettingsPresenter settingsPresenter;

    @Override
    protected void callInjection() {
        this.getViewInjector().inject(this);
    }

    @Override
    protected int layoutId() {
        return R.layout.fragment_settings;
    }

    @Override
    protected BasePresenter presenter() {
        return this.settingsPresenter;
    }

    public SettingsPresenter getSettingsPresenter() {
        return settingsPresenter;
    }

    @OnClick(R.id.tv_logout)
    public void logoutButtonPressed() {
        this.settingsPresenter.logoutUserButtonPressed();
    }

    @OnClick(R.id.tv_delete_account)
    public void deleteAccountButtonPressed() {
        this.settingsPresenter.deleteAccountButtonPressed();
    }

    @OnClick(R.id.tv_terms)
    public void termsButtonPressed() {
        ((Listener)getActivity()).showTerms();
    }

    @OnClick(R.id.tv_privacy)
    public void privacyButtonPressed() {
        ((Listener)getActivity()).showPrivacy();
    }

    public interface Listener {
        void showTerms();
        void showPrivacy();
    }
}
