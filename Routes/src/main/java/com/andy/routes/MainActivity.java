package com.andy.routes;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Button;

import com.andy.routes.activities.LocationsActivity;
import com.andy.routes.dialog.SignInDialogFragment;

public class MainActivity extends FragmentActivity
{
    //region Variables
    private Button locationsButton;
    //endregion

    //region Listeners
    private View.OnClickListener locationsButtonOnClickListener = new View.OnClickListener()
    {
        @Override
        public void onClick(View view)
        {
            Intent intent = new Intent(MainActivity.this, LocationsActivity.class);
            startActivity(intent);
        }
    };
    //endregion

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bindUIElements();
        setupListeners();
        showSignInDialog();
    }

    private void bindUIElements()
    {
        locationsButton = (Button) findViewById(R.id.main_locations_button);
    }

    private void setupListeners()
    {
        locationsButton.setOnClickListener(locationsButtonOnClickListener);
    }

    private void showSignInDialog()
    {
        SignInDialogFragment signInDialogFragment = new SignInDialogFragment();
        signInDialogFragment.show(getSupportFragmentManager(), SignInDialogFragment.TAG);
    }
}
