package com.activatenow.presentation.view.activity;

import android.content.Intent;
import android.os.Bundle;

import com.activatenow.presentation.R;
import com.activatenow.presentation.view.activity.base.CleanActivity;
import com.activatenow.presentation.view.fragment.RegisterFragment;

public class RegisterActivity extends CleanActivity implements RegisterFragment.Listener {

    @Override
    protected void initializeActivity(Bundle savedInstanceState) {
        if (savedInstanceState == null) {
            addFragment(R.id.fragment_container, new RegisterFragment());
        }
    }

    @Override
    protected boolean useToolbar() {
        return false;
    }

    @Override
    public void viewNotes() {
        Intent notesIntent = new Intent(this, MainActivity.class);
        notesIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(notesIntent);
    }

    @Override
    public void showTerms() {
        startActivity(new Intent(this, TermsActivity.class));
    }
}
