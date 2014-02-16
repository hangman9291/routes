package com.andy.routes.fragments;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;

import com.andy.routes.R;

public class SignUpDialogFragment extends DialogFragment
{
    //region Constant Variables
    public static final String TAG = "signup_dialog_fragment";
    //endregion

    //region Variables
    private EditText emailEditText;
    private EditText passwordEditText;
    private EditText confirmPasswordEditText;
    private Button submitButton;
    //endregion

    //region Listeners
    private View.OnClickListener submitButtonOnClickListener = new View.OnClickListener()
    {
        @Override
        public void onClick(View view)
        {

        }
    };
    //endregion

    //TODO: Figure out how to replace dialog fragment with another dialog fragment

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState)
    {
        Dialog dialog = new Dialog(getActivity(), android.R.style.Theme_Translucent);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.fragment_signup_dialog);
//        setCancelable(false);

        bindUIElements(dialog);
        setUpListeners();

        return dialog;
    }

    private void bindUIElements(Dialog dialog)
    {
        emailEditText           = (EditText) dialog.findViewById(R.id.signup_email_editText);
        passwordEditText        = (EditText) dialog.findViewById(R.id.signup_password_editText);
        confirmPasswordEditText = (EditText) dialog.findViewById(R.id.signup_confirm_password_editText);
        submitButton            = (Button) dialog.findViewById(R.id.signup_submit_button);
    }

    private void setUpListeners()
    {
        submitButton.setOnClickListener(submitButtonOnClickListener);
    }
}
