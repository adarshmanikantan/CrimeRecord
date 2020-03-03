package com.adarsh.crimerecord;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ProfileChooser extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_chooser);
    }

    public void userLoginClick(View view) {
        Intent i=new Intent(ProfileChooser.this,CitizenLogin.class);
        startActivity(i);
    }
}
