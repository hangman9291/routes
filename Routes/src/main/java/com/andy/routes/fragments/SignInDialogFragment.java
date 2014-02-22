package com.andy.routes.fragments;

import android.app.Dialog;
import android.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.andy.routes.R;

public class SignInDialogFragment extends DialogFragment {

    //region Constant Variables
    public static final String TAG = "signin_dialog_fragment";
    //endregion

    //region Variables
    private EditText emailEditText;
    private EditText passwordEditText;
    private Button signInButton;
    private TextView signUpButton;
    //endregion

    //region Listeners
    private View.OnClickListener signInButtonOnClickListener = new View.OnClickListener() {

        @Override
        public void onClick(View view) {
        }
    };

    private View.OnClickListener signUpButtonOnClickListener = new View.OnClickListener() {

        @Override
        public void onClick(View view) {
            SignUpDialogFragment signUpDialogFragment = new SignUpDialogFragment();
            signUpDialogFragment.show(getActivity().getSupportFragmentManager(), SignUpDialogFragment.TAG);
        }
    };
    //endregion

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog dialog = new Dialog(getActivity(), android.R.style.Theme_Translucent);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.fragment_signin_dialog);
//        setCancelable(false);

        bindUIElements(dialog);
        setUpListeners();

        return dialog;
    }

    private void bindUIElements(Dialog dialog) {
        emailEditText    = (EditText) dialog.findViewById(R.id.signin_email_editText);
        passwordEditText = (EditText) dialog.findViewById(R.id.signin_password_editText);
        signInButton     = (Button) dialog.findViewById(R.id.signin_submit_button);
        signUpButton     = (TextView) dialog.findViewById(R.id.signin_goto_signup_button);
    }

    private void setUpListeners() {
        signInButton.setOnClickListener(signInButtonOnClickListener);
        signUpButton.setOnClickListener(signUpButtonOnClickListener);
    }
}
