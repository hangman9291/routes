package com.andy.routes.activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.andy.routes.R;

public class SignUpActivity extends Activity
{
    //region Variables
    private EditText emailEditText;
    private EditText passwordEditText;
    private EditText confirmPasswordEditText;
    private Button submitButton;
    //endregion

    private View.OnClickListener submitButtonOnClickListener = new View.OnClickListener()
    {
        @Override
        public void onClick(View view)
        {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        bindUIElements();
        setupListeners();
    }

    private void bindUIElements()
    {
        emailEditText           = (EditText) findViewById(R.id.sign_up_email_editText);
        passwordEditText        = (EditText) findViewById(R.id.sign_up_password_editText);
        confirmPasswordEditText = (EditText) findViewById(R.id.sign_up_confirm_password_editText);
    }

    private void setupListeners()
    {
        submitButton.setOnClickListener(submitButtonOnClickListener);
    }
}
