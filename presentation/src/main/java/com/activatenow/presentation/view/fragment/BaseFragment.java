package com.activatenow.presentation.view.fragment;

import android.app.Fragment;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.activatenow.presentation.dependency.component.FragmentInjector;
import com.activatenow.presentation.presenter.BasePresenter;
import com.activatenow.presentation.view.BaseView;
import com.activatenow.presentation.view.activity.base.BaseActivity;
import com.activatenow.presentation.view.activity.base.CleanActivity;

import butterknife.ButterKnife;

public abstract class BaseFragment extends Fragment implements BaseView {

    private ProgressDialog progressDialog;

    protected abstract void callInjection();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        callInjection();
    }

    protected abstract int layoutId();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View fragmentView = inflater.inflate(layoutId(), container, false);
        ButterKnife.bind(this, fragmentView);
        return fragmentView;
    }

    protected abstract BasePresenter presenter();

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        presenter().initWithView(this);
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter().resume();
    }

    @Override
    public void onPause() {
        super.onPause();
        presenter().pause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter().destroy();
    }

    @Override
    public Context context() {
        return getActivity().getApplicationContext();
    }

    @Override
    public void showLoader() {
        if (this.progressDialog == null) this.progressDialog = new ProgressDialog(getActivity());
        this.progressDialog.show();
    }

    @Override
    public void hideLoader() {
        if (this.progressDialog != null) this.progressDialog.dismiss();
    }

    @Override
    public void handleError(Throwable error) {
        ((CleanActivity)getActivity()).handleError(error);
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(context(), message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void close() {
        ((CleanActivity)getActivity()).close();
    }

    public void closeAndDisplayLogin() {
        ((CleanActivity)getActivity()).closeAndDisplayLogin();
    }

    protected FragmentInjector getFragmentInjector() {
        return ((CleanActivity)getActivity()).getFragmentInjector();
    }
}
