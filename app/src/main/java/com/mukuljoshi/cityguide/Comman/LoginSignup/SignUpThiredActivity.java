package com.mukuljoshi.cityguide.Comman.LoginSignup;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;
import com.hbb20.CountryCodePicker;
import com.mukuljoshi.cityguide.R;

public class SignUpThiredActivity extends AppCompatActivity {

    // variables
    ImageView backBtn;
    Button next, login;
    TextView titleText, slideText;
    TextInputLayout phoneNumber;
    CountryCodePicker countryCodePicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_sign_up_thired);

        //hooks


        backBtn = findViewById(R.id.sign_ub_back_button);
        next = findViewById(R.id.signup_next_button);
        login = findViewById(R.id.signup_login_button);
        titleText = findViewById(R.id.signup_title_text);
        slideText = findViewById(R.id.signup_slide_text);

        phoneNumber = findViewById(R.id.phone_number);
        countryCodePicker = findViewById(R.id.country_code_picker);


    }

    public void callNextSignUpScreen(View view) {

        if (!validatePhoneNumber()) {

            return;
        }

        // get the all values passed from previous screen using intent

        String _fullName = getIntent().getStringExtra("fullName");
        String _email = getIntent().getStringExtra("email");
        String _userName = getIntent().getStringExtra("username");
        String _password = getIntent().getStringExtra("password");
        String _date = getIntent().getStringExtra("age");
        String _gender = getIntent().getStringExtra("gender");

        String _getUserEnterPhoneNumber = phoneNumber.getEditText().getText().toString().trim(); // get phone number
        String _phoneNo = "+" + countryCodePicker.getFullNumber() + _getUserEnterPhoneNumber;


        Intent intent = new Intent(getApplicationContext(), VerifyOTPActivity.class);


        //Pass all the data to the next activity

        intent.putExtra("fullName", _fullName);
        intent.putExtra("email", _email);
        intent.putExtra("username", _userName);
        intent.putExtra("password", _password);
        intent.putExtra("date", _date);
        intent.putExtra("gender", _gender);
        intent.putExtra("phoneNo", _phoneNo);


        // add transition

        Pair[] pairs = new Pair[5];

        pairs[0] = new Pair<View, String>(backBtn, "transition_back_arrow_btn");
        pairs[1] = new Pair<View, String>(next, "transition_next_btn");
        pairs[2] = new Pair<View, String>(login, "transition_login_btn");
        pairs[3] = new Pair<View, String>(titleText, "transition_title_text");
        pairs[4] = new Pair<View, String>(slideText, "transition_slide_text");


        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(SignUpThiredActivity.this, pairs);
            startActivity(intent, options.toBundle());
        } else {
            startActivity(intent);
        }


    }


    private boolean validatePhoneNumber() {
        String val = phoneNumber.getEditText().getText().toString().trim();
        if (val.isEmpty()) {
            phoneNumber.setError("number is required");
            phoneNumber.requestFocus();
            return false;
        } else if (val.length() < 10) {
            phoneNumber.setError("please provide valid number");
            phoneNumber.requestFocus();
            return false;
        } else {
            phoneNumber.setError(null);
            phoneNumber.setErrorEnabled(false);
            return true;
        }
    }


    public void back_pressed(View view) {
        SignUpThiredActivity.super.onBackPressed();
    }


}