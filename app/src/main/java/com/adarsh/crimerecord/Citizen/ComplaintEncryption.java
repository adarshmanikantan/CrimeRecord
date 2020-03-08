package com.adarsh.crimerecord.Citizen;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.adarsh.crimerecord.R;
import com.adarsh.crimerecord.Retro.Api;
import com.adarsh.crimerecord.Retro.Api_client;
import com.adarsh.crimerecord.Retro.CitizenLoginModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ComplaintEncryption extends AppCompatActivity {
    EditText district,policestation,complainttype,place,date,time,details;
    String encrypted_district, encrypted_policestation, encrypted_type, encrypted_place,
    encrypted_date, encrypted_time, encrypted_details;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complaint_encryption);

        district=findViewById(R.id.encrypt_district_spinner);
        policestation=findViewById(R.id.encrypt_selectps);
        complainttype=findViewById(R.id.encrypt_complainttypeedit);
        place=findViewById(R.id.encrypt_place_edit);
        date=findViewById(R.id.encrypt_date_edit);
        time=findViewById(R.id.encrypt_time_edit);
        details=findViewById(R.id.encrypt_detailsedit);


        SharedPreferences sharedPreferences=getApplicationContext().getSharedPreferences("complaint_status", Context.MODE_PRIVATE);
       int complaint_id=sharedPreferences.getInt("complaint_id",0);
       String s_district= sharedPreferences.getString("district",null);
       String s_police_station=sharedPreferences.getString("police_station",null);
       String s_type=sharedPreferences.getString("complaint_type",null);
       String s_place=sharedPreferences.getString("place",null);
       String s_date=sharedPreferences.getString("date",null);
       String s_time=sharedPreferences.getString("time",null);
       String s_details=sharedPreferences.getString("details",null);
       String flagset=sharedPreferences.getString("flagset",null);

        try {
            encrypted_district = AESUtils.encrypt(s_district);
             encrypted_policestation = AESUtils.encrypt(s_police_station);
             encrypted_type = AESUtils.encrypt(s_type);
             encrypted_place = AESUtils.encrypt(s_place);
             encrypted_date = AESUtils.encrypt(s_date);
             encrypted_time = AESUtils.encrypt(s_time);
             encrypted_details = AESUtils.encrypt(s_details);

            district.setText(encrypted_district);
            policestation.setText(encrypted_policestation);
            complainttype.setText(encrypted_type);
            place.setText(encrypted_place);
            date.setText(encrypted_date);
            time.setText(encrypted_time);
            details.setText(encrypted_details);



        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void DecryptionClick(View view) {
        LayoutInflater inflat=LayoutInflater.from(ComplaintEncryption.this);
        final View cuslay=inflat.inflate(R.layout.askpin,null);

         final EditText pin=cuslay.findViewById(R.id.epin);
        Button ok=cuslay.findViewById(R.id.eok);
        AlertDialog.Builder AB=new AlertDialog.Builder(ComplaintEncryption.this);
        AB.setView(cuslay);
        final AlertDialog A=AB.create();
        A.show();

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Api api= Api_client.CitizenRegister().create(Api.class);
                String s_pin=pin.getText().toString();
                SharedPreferences sharedPreferences=getApplicationContext().getSharedPreferences("userpref",MODE_PRIVATE);
                String s_email=sharedPreferences.getString("key2",null);
                api.CITIZEN_LOGIN_MODEL_CALL(s_email,s_pin).enqueue(new Callback<CitizenLoginModel>() {
                    @Override
                    public void onResponse(Call<CitizenLoginModel> call, Response<CitizenLoginModel> response) {
                        CitizenLoginModel citizenLoginModel=response.body();
                        if(citizenLoginModel.getStatus().equalsIgnoreCase("Success"))
                        {
                            Toast.makeText(ComplaintEncryption.this,encrypted_district, Toast.LENGTH_SHORT).show();
                                A.dismiss();
                            try {
                                district.setText(AESUtils.decrypt(encrypted_district));
                                policestation.setText(AESUtils.decrypt(encrypted_policestation));
                                complainttype.setText(AESUtils.decrypt(encrypted_type));
                                place.setText(AESUtils.decrypt(encrypted_place));
                                date.setText(AESUtils.decrypt(encrypted_date));
                                time.setText(AESUtils.decrypt(encrypted_time));
                                details.setText(AESUtils.decrypt(encrypted_details));
                            } catch (Exception e) {
                                e.printStackTrace();
                            }




                        }
                    }

                    @Override
                    public void onFailure(Call<CitizenLoginModel> call, Throwable t) {

                    }
                });
            }
        });
    }
}
