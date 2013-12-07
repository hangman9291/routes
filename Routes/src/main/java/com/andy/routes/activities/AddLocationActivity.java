package com.andy.routes.activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.andy.routes.R;

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

            if (message != null)
            {
                Toast toast = Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT);
                toast.show();
            }
            else
            {
                // save that shit
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
            return "Name cannot be blank";
        else if (locationAddressTextField.getText().length() == 0)
            return "Address cannot be blank";
        else if (locationCityTextField.getText().length() == 0)
            return "City cannot be blank";
        else if (locationStateTextField.getText().length() == 0)
            return "State cannot be blank";
        else if (locationZipTextField.getText().length() == 0)
            return "Zip cannot be blank";
        else
            return null;
    }
}
