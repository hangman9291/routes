package com.andy.routes.activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.andy.routes.R;
import com.andy.routes.classes.Location;
import com.andy.routes.db.LocationsHandler;
import com.andy.routes.utils.Utilities;

public class AddLocationActivity extends Activity
{
    //region Variables
    private EditText locationNameTextField;
    private EditText locationAddressTextField;
    private EditText locationCityTextField;
    private EditText locationStateTextField;
    private EditText locationZipTextField;
    private Button saveButton;
    //endregion

    //region Listeners
    private View.OnClickListener saveButtonOnClickListener = new View.OnClickListener()
    {
        @Override
        public void onClick(View view)
        {
            String message = getErrorMessage();

            if (!message.equals(""))
                Utilities.showShortToast(getApplicationContext(), message);
            else
            {
                LocationsHandler locationHandler = new LocationsHandler(getApplicationContext());
                Location newLocation = new Location
                        (
                                locationNameTextField.getText().toString(),
                                locationAddressTextField.getText().toString(),
                                locationCityTextField.getText().toString(),
                                locationStateTextField.getText().toString(),
                                locationZipTextField.getText().toString()
                        );
                locationHandler.addLocation(newLocation);
                Utilities.showShortToast(getApplicationContext(), getResources().getString(R.string.msg_add_location_success));
                finish();
            }
        }
    };
    //endregion

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_location);
        bindUIElements();
        setupListeners();
    }

    private void bindUIElements()
    {
        locationNameTextField    = (EditText) findViewById(R.id.add_location_name_editText);
        locationAddressTextField = (EditText) findViewById(R.id.add_location_street_editText);
        locationCityTextField    = (EditText) findViewById(R.id.add_location_city_editText);
        locationStateTextField   = (EditText) findViewById(R.id.add_location_state_editText);
        locationZipTextField     = (EditText) findViewById(R.id.add_location_zip_editText);
        saveButton               = (Button)   findViewById(R.id.add_location_save_button);
    }

    private void setupListeners()
    {
        saveButton.setOnClickListener(saveButtonOnClickListener);
    }

    private String getErrorMessage()
    {
        if (locationNameTextField.getText().length() == 0)
            return getString(R.string.msg_error_add_location_name);
        else if (locationAddressTextField.getText().length() == 0)
            return getString(R.string.msg_error_add_location_address);
        else if (locationCityTextField.getText().length() == 0)
            return getString(R.string.msg_error_add_location_city);
        else if (locationStateTextField.getText().length() == 0)
            return getString(R.string.msg_error_add_location_state);
        else if (locationZipTextField.getText().length() == 0)
            return getString(R.string.msg_error_add_location_zip);
        else
            return "";
    }
}
