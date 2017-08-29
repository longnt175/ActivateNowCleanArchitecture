package com.activatenow.presentation.view.activity;

import com.activatenow.data.net.RestApi;
import com.activatenow.presentation.view.activity.base.WebViewActivity;

public class PrivacyActivity extends WebViewActivity {

    private static final String TERMS_URL = RestApi.URL_BASE + "/privacy";

    @Override
    public String getUrl() {
        return TERMS_URL;
    }

}
