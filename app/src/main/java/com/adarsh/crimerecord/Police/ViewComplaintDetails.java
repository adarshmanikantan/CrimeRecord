package com.adarsh.crimerecord.Police;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.adarsh.crimerecord.R;
import com.adarsh.crimerecord.Retro.Api;
import com.adarsh.crimerecord.Retro.Api_client;
import com.adarsh.crimerecord.Retro.ComplaintVerificationModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ViewComplaintDetails extends AppCompatActivity {
    int complaint_id;
    private RelativeLayout policeRelativelayout;
    private TextView policeTitle;
    private TextView policeDistrict;
    private EditText policeDistrictSpinner;
    private TextView policePolicestation;
    private EditText policeEncryptSelectps;
    private TextView policeComplainttype;
    private EditText policeEncryptComplainttypeedit;
    private TextView policePlace;
    private EditText policeEncryptPlaceEdit;
    private TextView policeDate;
    private EditText policeEncryptDateEdit;
    private TextView policeTime;
    private EditText encryptTimeEdit;
    private TextView policeDetails;
    private EditText encryptDetailsedit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_complaint_details);
        initView();
        SharedPreferences sharedPreferences=getApplicationContext().getSharedPreferences("complaint", Context.MODE_PRIVATE);

        complaint_id=sharedPreferences.getInt("complaint_id",0);



     //   sharedPreferences.getString("flagset",null);

        policeDistrictSpinner.setText(sharedPreferences.getString("district",null));
        policeEncryptSelectps.setText(sharedPreferences.getString("police_station",null));
        policeEncryptComplainttypeedit.setText(sharedPreferences.getString("complaint_type",null));
        policeEncryptPlaceEdit.setText(sharedPreferences.getString("place",null));
        policeEncryptDateEdit.setText(sharedPreferences.getString("date",null));
        encryptTimeEdit.setText(sharedPreferences.getString("time",null));
        encryptDetailsedit.setText(sharedPreferences.getString("details",null));


    }

    private void initView() {
        policeRelativelayout = findViewById(R.id.police_relativelayout);
        policeTitle = findViewById(R.id.police_title);
        policeDistrict = findViewById(R.id.police_district);
        policeDistrictSpinner = findViewById(R.id.police_district_spinner);
        policePolicestation = findViewById(R.id.police_policestation);
        policeEncryptSelectps = findViewById(R.id.police_encrypt_selectps);
        policeComplainttype = findViewById(R.id.police_complainttype);
        policeEncryptComplainttypeedit = findViewById(R.id.police_encrypt_complainttypeedit);
        policePlace = findViewById(R.id.police_place);
        policeEncryptPlaceEdit = findViewById(R.id.police_encrypt_place_edit);
        policeDate = findViewById(R.id.police_date);
        policeEncryptDateEdit = findViewById(R.id.police_encrypt_date_edit);
        policeTime = findViewById(R.id.police_time);
        encryptTimeEdit = findViewById(R.id.encrypt_time_edit);
        policeDetails = findViewById(R.id.police_details);
        encryptDetailsedit = findViewById(R.id.encrypt_detailsedit);
    }

    public void verifyClick(View view) {
        Api api= Api_client.CitizenRegister().create(Api.class);
        api.COMPLAINT_VERIFICATION_MODEL_CALL(complaint_id).enqueue(new Callback<ComplaintVerificationModel>() {
            @Override
            public void onResponse(Call<ComplaintVerificationModel> call, Response<ComplaintVerificationModel> response) {
              ComplaintVerificationModel complaintVerificationModel=response.body();
              String complaint_id=complaintVerificationModel.getCitizenData().getResults().get(0).getFlagset();
              if(complaint_id.equals("1"))
              {
                  Toast.makeText(ViewComplaintDetails.this, "Verified", Toast.LENGTH_SHORT).show();
              }
              else
              {
                  Toast.makeText(ViewComplaintDetails.this, "Not verified", Toast.LENGTH_SHORT).show();
              }
            }

            @Override
            public void onFailure(Call<ComplaintVerificationModel> call, Throwable t) {

            }
        });
    }

    public void generateFirintent(View view) {
        Intent i=new Intent(ViewComplaintDetails.this,GenerateFir.class);
        startActivity(i);
    }
}
