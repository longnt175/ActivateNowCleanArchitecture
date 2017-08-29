package com.activatenow.presentation.view.activity.base;

import android.os.Bundle;

import com.activatenow.presentation.R;
import com.activatenow.presentation.view.activity.base.BaseActivity;
import com.activatenow.presentation.view.fragment.WebViewFragment;

public abstract class WebViewActivity extends BaseActivity implements WebViewFragment.Listener {

    @Override
    protected void initializeActivity(Bundle savedInstanceState) {
        if (savedInstanceState == null) {
            addFragment(R.id.fragment_container, new WebViewFragment());
        }
    }

}
