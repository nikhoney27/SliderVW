package com.example.nick.slidervw;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.RelativeLayout;

public class HomeActivity extends AppCompatActivity {

    RelativeLayout mTransparentOverlay;
    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        init_activity();

        mTransparentOverlay = (RelativeLayout) findViewById(R.id.transparentOverlay);
        mTransparentOverlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTransparentOverlay.setVisibility(View.GONE);
            }
        });

    }

    private void init_activity() {
        mToolbar = (Toolbar) findViewById(R.id.mToolbar);
        setSupportActionBar(mToolbar);
    }
}
