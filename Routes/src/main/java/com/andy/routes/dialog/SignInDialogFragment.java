package com.andy.routes.dialog;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;

import com.andy.routes.R;

public class SignInDialogFragment extends DialogFragment
{
    //region Constant Variables
    public static final String TAG = "sign_in_dialog_fragment";
    //endregion

    //region Variables
    private EditText emailEditText;
    private EditText passwordEditText;
    private Button signInButton;
    private Button signUpButton;
    //endregion

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState)
    {
        Dialog dialog = new Dialog(getActivity(), android.R.style.Theme_Translucent);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.fragment_signin_dialog);
        bindUIElements(dialog);
        return dialog;
    }

    private void bindUIElements(Dialog dialog)
    {
        emailEditText    = (EditText) dialog.findViewById(R.id.signin_email_editText);
        passwordEditText = (EditText) dialog.findViewById(R.id.signin_password_editText);
        signInButton     = (Button) dialog.findViewById(R.id.signin_submit_button);
        signUpButton     = (Button) dialog.findViewById(R.id.signin_goto_signup_button);
    }
}
