package com.mukuljoshi.cityguide.Comman.LoginSignup;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

import com.mukuljoshi.cityguide.R;

public class ForgotPasswordActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

    }

    public void back_pressed(View view) {
        ForgotPasswordActivity.super.onBackPressed();
    }

    public void mack_selection(View view) {
        Intent intent = new Intent(ForgotPasswordActivity.this,MackSelectionActivity.class);

        startActivity(intent);
    }

}