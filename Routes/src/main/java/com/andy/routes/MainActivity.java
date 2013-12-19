package com.andy.routes;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.andy.routes.activities.LocationsActivity;

public class MainActivity extends Activity
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
    }

    private void bindUIElements()
    {
        locationsButton = (Button) findViewById(R.id.main_locations_button);
    }

    private void setupListeners()
    {
        locationsButton.setOnClickListener(locationsButtonOnClickListener);
    }
}
