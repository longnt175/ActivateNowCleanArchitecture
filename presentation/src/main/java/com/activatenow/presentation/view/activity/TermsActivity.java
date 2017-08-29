package com.activatenow.presentation.view.activity;

import com.activatenow.data.net.RestApi;
import com.activatenow.presentation.view.activity.base.WebViewActivity;

public class TermsActivity extends WebViewActivity {

    private static final String TERMS_URL = RestApi.URL_BASE + "/terms";

    @Override
    public String getUrl() {
        return TERMS_URL;
    }

}
