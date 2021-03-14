package com.mukuljoshi.cityguide.Comman.LoginSignup;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

import com.mukuljoshi.cityguide.R;

public class MackSelectionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mack_selection);
    }
    public void back_pressed_to_password_forgot(View view) {
        MackSelectionActivity.super.onBackPressed();

    }

    public void verifiyViaMessage(View view) {

        startActivity(new Intent(getApplicationContext(),SetNewPasswordAvticity.class));

    }

    public void verifiyViaEmail(View view) {
        startActivity(new Intent(getApplicationContext(),SetNewPasswordAvticity.class));

    }
}