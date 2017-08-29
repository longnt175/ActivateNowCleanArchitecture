package com.activatenow.presentation.view.fragment;

import android.widget.EditText;

import com.activatenow.presentation.R;
import com.activatenow.presentation.presenter.BasePresenter;
import com.activatenow.presentation.presenter.RegisterPresenter;
import com.activatenow.presentation.presenter.ResetPasswordPresenter;
import com.activatenow.presentation.view.RegisterView;
import com.activatenow.presentation.view.ResetPasswordView;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.OnClick;

public class ResetPasswordFragment extends BaseFragment implements ResetPasswordView {

    @Inject
    ResetPasswordPresenter resetPasswordPresenter;

    @Bind(R.id.et_email) EditText emailEditText;
    @Bind(R.id.et_password) EditText passwordEditText;
    @Bind(R.id.et_password_confirmation) EditText passwordConfirmationEditText;

    @Override
    protected void callInjection() {
        this.getFragmentInjector().inject(this);
    }

    @Override
    protected int layoutId() {
        return R.layout.fragment_reset_password;
    }

    @Override
    protected BasePresenter presenter() {
        return this.resetPasswordPresenter;
    }

    public ResetPasswordPresenter getResetPasswordPresenter() {
        return this.resetPasswordPresenter;
    }

    @OnClick(R.id.btn_resetpassword)
    public void resetPasswordButtonPressed() {
        this.resetPasswordPresenter.resetPassword(emailEditText.getText().toString(),
                                            passwordEditText.getText().toString(),
                                            passwordConfirmationEditText.getText().toString());
    }

}
