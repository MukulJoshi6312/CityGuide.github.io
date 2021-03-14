package com.mukuljoshi.cityguide.Comman.LoginSignup;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;
import com.mukuljoshi.cityguide.R;

import java.util.Objects;

public class SignUpActivity extends AppCompatActivity {

    //variable
    ImageView backBtn;
    Button next, login;
    TextView titleText, slideText;

//    singup form varibale

    TextInputLayout signup_fullName, signup_username, signup_email, sign_uppassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_retailer_sign_up);


        //Hooks

        backBtn = findViewById(R.id.sign_ub_back_button);
        next = findViewById(R.id.signup_next_button);
        login = findViewById(R.id.signup_login_button);
        titleText = findViewById(R.id.signup_title_text);
        slideText = findViewById(R.id.signup_slide_text);

        //sign up form hooks

        signup_fullName = findViewById(R.id.signup_fullname);
        signup_username = findViewById(R.id.signup_username);
        signup_email = findViewById(R.id.signup_email);
        sign_uppassword = findViewById(R.id.signup_password);


    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public void callNextSignUpScreen(View view) {

        if (!validateFullName() |  !validateUsreName() | !validateEmail() | !validatePassword()){
            return;
        }


        Intent intent = new Intent(getApplicationContext(), SignUpSecondActivity.class);

        //gat all the values

//        final String name = Objects.requireNonNull(signup_fullName.getEditText()).getText().toString();
//
//        final String email = Objects.requireNonNull(email.getEditText()).getText().toString();
//
//        final String password = Objects.requireNonNull(password.getEditText()).getText().toString();
//
//        final String phone = Objects.requireNonNull(text_number.getEditText()).getText().toString();

            String fullname = Objects.requireNonNull(signup_fullName.getEditText()).getText().toString().trim();
            String username = Objects.requireNonNull(signup_username.getEditText()).getText().toString().trim();
            String email = Objects.requireNonNull(signup_email.getEditText()).getText().toString().trim();
            String password = Objects.requireNonNull(sign_uppassword.getEditText()).getText().toString().trim();


            intent.putExtra("fullName",fullname);
            intent.putExtra("username",username);
            intent.putExtra("email",email);
            intent.putExtra("password",password);
















        // add transition

        Pair[] pairs = new Pair[5];

        pairs[0] = new Pair<View, String>(backBtn, "transition_back_arrow_btn");
        pairs[1] = new Pair<View, String>(next, "transition_next_btn");
        pairs[2] = new Pair<View, String>(login, "transition_login_btn");
        pairs[3] = new Pair<View, String>(titleText, "transition_title_text");
        pairs[4] = new Pair<View, String>(slideText, "transition_slide_text");

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(SignUpActivity.this, pairs);
            startActivity(intent, options.toBundle());
        } else {
            startActivity(intent);
        }


    }


//    validation function

    private boolean validateFullName() {

        String val = signup_fullName.getEditText().getText().toString().trim();
        if (val.isEmpty()) {
            signup_fullName.setError("Field can't be empty");
            signup_fullName.requestFocus();
            return false;
        } else {
            signup_fullName.setError(null);
            signup_fullName.setErrorEnabled(false);
            return true;
        }
    }


    private boolean validateUsreName() {

        String val = signup_username.getEditText().getText().toString().trim();
        String checkspaces = "\\A\\w{1,20}\\z";
        if (val.isEmpty()) {
            signup_username.setError("Field can't be empty");
            signup_username.requestFocus();
            return false;
        } else if (val.length()>20){
            signup_username.setError("Username is too large!");
            signup_username.requestFocus();
            return false;
        }
        else if (!val.matches(checkspaces)){
            signup_username.setError("No white spaces are allowed");
            signup_username.requestFocus();
            return false;
        }

        else {
            signup_username.setError(null);
            signup_username.setErrorEnabled(false);
            signup_username.requestFocus();
            return true;
        }
    }



    private boolean validateEmail() {

        String val = signup_email.getEditText().getText().toString().trim();
        String checkEmail = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        if (val.isEmpty()) {
            signup_email.setError("Field can't be empty");
            signup_email.requestFocus();
            return false;
        }
        else if (!val.matches(checkEmail)){
            signup_email.setError("invalid email");
            signup_email.requestFocus();
            return false;
        }

        else {
            signup_email.setError(null);
            signup_email.setErrorEnabled(false);
            signup_email.requestFocus();
            return true;
        }
    }





    private boolean validatePassword() {

        String val = sign_uppassword.getEditText().getText().toString().trim();
        if (val.isEmpty()) {
            sign_uppassword.setError("password is required");
            sign_uppassword.requestFocus();
            return false;
        }
        else if (val.length() < 6) {
            sign_uppassword.setError("Min password should be 6 character!");
            sign_uppassword.requestFocus();
            return false;
        }
        else {
            sign_uppassword.setError(null);
            sign_uppassword.setErrorEnabled(false);
            sign_uppassword.requestFocus();
            return true;
        }
    }




    public void back_pressed(View view) {
        SignUpActivity.super.onBackPressed();
    }
}