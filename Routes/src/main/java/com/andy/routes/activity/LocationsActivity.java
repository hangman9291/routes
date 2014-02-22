package com.andy.routes.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.andy.routes.R;

public class LocationsActivity extends FragmentActivity {

    //region Variables
    private Button addLocationButton;
    private ListView locationListView;
    //endregion

    //region Listeners
    private View.OnClickListener addLocationOnClickListener = new View.OnClickListener() {

        @Override
        public void onClick(View view) {
            Intent addLocationActivity = new Intent(getApplicationContext(), AddLocationActivity.class);
            startActivity(addLocationActivity);
        }
    };
    //endregion

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_locations);
        bindUIElements();
        setupListeners();
    }

    private void bindUIElements() {
        addLocationButton = (Button) findViewById(R.id.locations_add_button);
        locationListView  = (ListView) findViewById(R.id.locations_listView);
    }

    private void setupListeners() {
        addLocationButton.setOnClickListener(addLocationOnClickListener);
    }

    private void populateListView() {
    }
}
