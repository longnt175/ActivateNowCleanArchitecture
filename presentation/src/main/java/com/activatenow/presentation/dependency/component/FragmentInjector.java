package com.activatenow.presentation.dependency.component;

import com.activatenow.presentation.view.fragment.LoginFragment;
import com.activatenow.presentation.view.fragment.RegisterFragment;
import com.activatenow.presentation.view.fragment.ResetPasswordFragment;
import com.activatenow.presentation.view.fragment.SettingsFragment;

public interface FragmentInjector {

    void inject(LoginFragment loginFragment);
    void inject(RegisterFragment registerFragment);
    void inject(SettingsFragment settingsFragment);
    void inject(ResetPasswordFragment resetPasswordFragment);

}
