package com.activatenow.presentation.view.fragment;

import android.widget.EditText;

import com.activatenow.presentation.R;
import com.activatenow.presentation.presenter.BasePresenter;
import com.activatenow.presentation.presenter.RegisterPresenter;
import com.activatenow.presentation.view.RegisterView;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.OnClick;

public class RegisterFragment extends BaseFragment implements RegisterView {

    @Inject
    RegisterPresenter registerPresenter;

    @Bind(R.id.et_email) EditText emailEditText;
    @Bind(R.id.et_password) EditText passwordEditText;
    @Bind(R.id.et_password_confirmation) EditText passwordConfirmationEditText;

    @Override
    protected void callInjection() {
        this.getViewInjector().inject(this);
    }

    @Override
    protected int layoutId() {
        return R.layout.fragment_register;
    }

    @Override
    protected BasePresenter presenter() {
        return this.registerPresenter;
    }

    public RegisterPresenter getRegisterPresenter() {
        return registerPresenter;
    }

    @OnClick(R.id.btn_register)
    public void registerButtonPressed() {
        this.registerPresenter.registerUser(emailEditText.getText().toString(),
                                            passwordEditText.getText().toString(),
                                            passwordConfirmationEditText.getText().toString());
    }

    @OnClick(R.id.tv_terms)
    public void termsPressed() {
        ((Listener)getActivity()).showTerms();
    }

    @Override
    public void viewNotes() {
        ((Listener)getActivity()).viewNotes();
    }

    public interface Listener {
        void viewNotes();
        void showTerms();
    }

}
