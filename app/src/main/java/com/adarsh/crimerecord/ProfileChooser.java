package com.adarsh.crimerecord;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.view.ViewCompat;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class ProfileChooser extends AppCompatActivity {

    LinearLayout linearLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_chooser);
        linearLayout=findViewById(R.id.cardView);
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public void userLoginClick(View view) {
        Intent i=new Intent(ProfileChooser.this,CitizenLogin.class);
        startActivity(i);

    }
}
