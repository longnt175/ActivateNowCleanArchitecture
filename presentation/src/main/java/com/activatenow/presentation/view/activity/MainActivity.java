package com.activatenow.presentation.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.activatenow.presentation.R;
import com.activatenow.presentation.view.activity.base.CleanActivity;

public class MainActivity extends CleanActivity {

    @Override
    protected void initializeActivity(Bundle savedInstanceState) { }

    @Override
    protected boolean useBackToolbar() {
        return false;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        this.getToolbar().setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                if (item.getItemId() == R.id.item_settings) {
                    MainActivity.this.displaySettings();
                    return true;
                }
                return false;
            }
        });
        return true;
    }

    public void displaySettings() {
        startActivity(new Intent(this, SettingsActivity.class));
    }

}
