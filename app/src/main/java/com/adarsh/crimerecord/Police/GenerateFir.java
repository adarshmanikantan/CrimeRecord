package com.adarsh.crimerecord.Police;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.adarsh.crimerecord.R;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class GenerateFir extends AppCompatActivity {

    private TextInputLayout firNumber;
    private TextInputEditText firNumberField;
    private TextInputLayout firDate;
    private TextInputEditText firDateField;
    private TextInputEditText firTimeField;
    private TextInputLayout ipcAct;
    private TextInputEditText firIpcactField;
    private TextInputLayout ipcSession;
    private TextInputEditText ipcSessionField;
    private TextInputLayout day;
    private TextInputEditText dayField;
    private TextInputLayout timefrom;
    private TextInputEditText timeFromField;
    private TextInputLayout timeto;
    private TextInputEditText timeToField;
    private TextInputLayout datefrom;
    private TextInputEditText dateFromField;
    private TextInputLayout dateto;
    private TextInputEditText dateToField;
    private TextInputLayout diaryentry;
    private TextInputEditText diaryentryField;
    private TextInputLayout entrytime;
    private TextInputEditText entrytimeField;
    private TextInputLayout type;
    private TextInputEditText typeField;
    private TextInputLayout distance;
    private TextInputEditText distanceField;
    private TextInputLayout beat;
    private TextInputEditText beatNoField;
    private TextInputLayout address;
    private TextInputEditText addressEdt;
    private TextInputLayout complaintdetails;
    private TextInputEditText complaintdetailsField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generate_fir);
        initView();
    }

    public void nextClick(View view) {
        String diaryentry=diaryentryField.getText().toString();
        String diaryentrytime=entrytimeField.getText().toString();
        String type=typeField.getText().toString();
        String distance=distanceField.getText().toString();
        String beatno=beatNoField.getText().toString();
        String address=addressEdt.getText().toString();
        String complaintdetails=complaintdetailsField.getText().toString();

        SharedPreferences sharedPreferences=getApplicationContext().getSharedPreferences("firpref",MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putString("firno",firNumberField.getText().toString());
        editor.putString("firdate",firDateField.getText().toString());
        editor.putString("firtime",firTimeField.getText().toString());
        editor.putString("ipcAct",firIpcactField.getText().toString());
        editor.putString("ipcsession",ipcSessionField.getText().toString());
        editor.putString("day",dayField.getText().toString());
        editor.putString("timefrom",timeFromField.getText().toString());
        editor.putString("timeto",timeToField.getText().toString());
        editor.putString("datefrom",dateFromField.getText().toString());
        editor.putString("dateto",dateToField.getText().toString());
        editor.putString("diaryentry",diaryentryField.getText().toString());
        editor.putString("diaryentrytime",entrytimeField.getText().toString());
        editor.putString("type",typeField.getText().toString());
        editor.putString("distance",distanceField.getText().toString());
        editor.putString("beatno",beatNoField.getText().toString());
        editor.putString("address",addressEdt.getText().toString());
        editor.putString("complaintdetails",complaintdetailsField.getText().toString());
        editor.apply();
        Intent i = new Intent(GenerateFir.this, FirActivity.class);
        startActivity(i);
    }

    private void initView() {
        firNumber = findViewById(R.id.fir_number);
        firNumberField = findViewById(R.id.fir_number_field);
        firDate = findViewById(R.id.fir_date);
        firDateField = findViewById(R.id.fir_date_field);
        firTimeField = findViewById(R.id.fir_time_field);
        ipcAct = findViewById(R.id.ipc_act);
        firIpcactField = findViewById(R.id.fir_ipcact_field);
        ipcSession = findViewById(R.id.ipc_session);
        ipcSessionField = findViewById(R.id.ipc_session_field);
        day = findViewById(R.id.day);
        dayField = findViewById(R.id.day_field);
        timefrom = findViewById(R.id.timefrom);
        timeFromField = findViewById(R.id.time_from_field);
        timeto = findViewById(R.id.timeto);
        timeToField = findViewById(R.id.time_to_field);
        datefrom = findViewById(R.id.datefrom);
        dateFromField = findViewById(R.id.date_from_field);
        dateto = findViewById(R.id.dateto);
        dateToField = findViewById(R.id.date_to_field);
        diaryentry = findViewById(R.id.diaryentry);
        diaryentryField = findViewById(R.id.diaryentry_field);
        entrytime = findViewById(R.id.entrytime);
        entrytimeField = findViewById(R.id.entrytime_field);
        type = findViewById(R.id.type);
        typeField = findViewById(R.id.type_field);
        distance = findViewById(R.id.distance);
        distanceField = findViewById(R.id.distance_field);
        beat = findViewById(R.id.beat);
        beatNoField = findViewById(R.id.beat_no_field);
        address = findViewById(R.id.address);
        addressEdt = findViewById(R.id.address_edt);
        complaintdetails = findViewById(R.id.complaintdetails);
        complaintdetailsField = findViewById(R.id.complaintdetails_field);
    }
}
