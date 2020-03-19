package com.adarsh.crimerecord.Police;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.adarsh.crimerecord.R;
import com.adarsh.crimerecord.Retro.ViewComplaintsByPoliceStationModel;

public class PoliceHome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_police_home);
    }

    public void viewComplaintsClick(View view) {
      Intent i=new Intent(PoliceHome.this,ViewComplaints.class);
      startActivity(i);
    }

    public void generateFir(View view) {
        Intent i=new Intent(PoliceHome.this,GenerateFir.class);
        startActivity(i);
    }
}
