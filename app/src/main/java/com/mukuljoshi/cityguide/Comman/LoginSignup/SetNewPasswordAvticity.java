package com.mukuljoshi.cityguide.Comman.LoginSignup;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

import com.mukuljoshi.cityguide.R;

public class SetNewPasswordAvticity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_new_password_avticity);
    }

    public void goto_success_message(View view) {
        startActivity(new Intent(getApplicationContext(),ForgotPasswordSuccessMessageActivity.class));
    }

    public void back_pressed(View view) {

        SetNewPasswordAvticity.super.onBackPressed();
    }
}