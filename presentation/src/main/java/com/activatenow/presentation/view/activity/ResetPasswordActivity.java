package com.activatenow.presentation.view.activity;

import android.os.Bundle;

import com.activatenow.presentation.R;
import com.activatenow.presentation.view.activity.base.CleanActivity;
import com.activatenow.presentation.view.fragment.ResetPasswordFragment;

public class ResetPasswordActivity extends CleanActivity {

    @Override
    protected void initializeActivity(Bundle savedInstanceState) {
        if (savedInstanceState == null) {
            addFragment(R.id.fragment_container, new ResetPasswordFragment());
        }
    }

    @Override
    protected boolean useToolbar() {
        return false;
    }

}
