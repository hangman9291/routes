package com.andy.routes.fragments;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;

import com.andy.routes.R;

public class AddLocationFragment extends DialogFragment
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
            //Do something
            dismiss();
        }
    };
    //endregion

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        return inflater.inflate(R.layout.fragment_add_location, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);
        bindUIElements(view);
        setupListeners();
    }

    private void bindUIElements(View view)
    {
        locationNameTextField    = (EditText) view.findViewById(R.id.add_location_name_editText);
        locationAddressTextField = (EditText) view.findViewById(R.id.add_location_street_editText);
        locationCityTextField    = (EditText) view.findViewById(R.id.add_location_city_editText);
        locationStateTextField   = (EditText) view.findViewById(R.id.add_location_state_editText);
        locationZipTextField     = (EditText) view.findViewById(R.id.add_location_zip_editText);
        saveButton = (Button) view.findViewById(R.id.add_location_save_button);
    }

    private void setupListeners()
    {
        saveButton.setOnClickListener(saveButtonOnClickListener);
    }
}
