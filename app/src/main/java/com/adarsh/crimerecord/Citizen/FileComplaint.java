package com.adarsh.crimerecord.Citizen;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import com.adarsh.crimerecord.CitizenHome;
import com.adarsh.crimerecord.CitizenSignUp;
import com.adarsh.crimerecord.R;
import com.adarsh.crimerecord.Retro.Api;
import com.adarsh.crimerecord.Retro.Api_client;
import com.adarsh.crimerecord.Retro.PostComplaintRequestModel;
import com.adarsh.crimerecord.Retro.PostComplaintResponseModel;
import com.google.gson.Gson;

import java.util.Calendar;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FileComplaint extends AppCompatActivity {
EditText district,policestation,complainttype,place,date,time,details;
    TimePickerDialog picker;
    String Json;
    RequestBody requestBody = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file_complaint);

        district=findViewById(R.id.district_spinner);
        policestation=findViewById(R.id.selectps);
        complainttype=findViewById(R.id.complainttypeedit);
        place=findViewById(R.id.place_edit);
        date=findViewById(R.id.date_edit);
        time=findViewById(R.id.time_edit);
        details=findViewById(R.id.detailsedit);

        date.setInputType(InputType.TYPE_NULL);
        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar cldr = Calendar.getInstance();
                int day = cldr.get(Calendar.DAY_OF_MONTH);
                int month = cldr.get(Calendar.MONTH);
                int year = cldr.get(Calendar.YEAR);
                // date picker dialog
                DatePickerDialog picker = new DatePickerDialog(FileComplaint.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                date.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                            }
                        }, year, month, day);
                picker.show();
            }
        });
        time.setInputType(InputType.TYPE_NULL);
        time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar cldr = Calendar.getInstance();
                int hour = cldr.get(Calendar.HOUR_OF_DAY);
                int minutes = cldr.get(Calendar.MINUTE);
                // time picker dialog
                picker = new TimePickerDialog(FileComplaint.this,
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker tp, int sHour, int sMinute) {
                                time.setText(sHour + ":" + sMinute);
                            }
                        }, hour, minutes, true);
                picker.show();
            }
        });
    }

    public void complaintSubmitClick(View view) {
        SharedPreferences sharedPreferences=getApplicationContext().getSharedPreferences("userpref",MODE_PRIVATE);
        int userid=sharedPreferences.getInt("key1",0);
        String string_district=district.getText().toString();
        String string_policestation=policestation.getText().toString();
        String string_complainttype=complainttype.getText().toString();
        String string_place=place.getText().toString();
        String string_date=date.getText().toString();
        String string_time=time.getText().toString();
        String string_details=details.getText().toString();

       Api api= Api_client.CitizenRegister().create(Api.class);

        final PostComplaintRequestModel postComplaintRequestModel=new PostComplaintRequestModel();

        postComplaintRequestModel.setOwner_id(userid);
        postComplaintRequestModel.setDistrict(string_district);
        postComplaintRequestModel.setPolice_Station(string_policestation);
        postComplaintRequestModel.setComplaint_type(string_complainttype);
        postComplaintRequestModel.setPlace_of_occurence(string_place);
        postComplaintRequestModel.setDate(string_date);
        postComplaintRequestModel.setTime(string_time);
        postComplaintRequestModel.setDetails(string_details);
        postComplaintRequestModel.setFlagset("0");

        Gson gson = new Gson();
        Json = gson.toJson(postComplaintRequestModel).trim();
        try {
            requestBody = RequestBody.create(MediaType.parse("application/json"), Json.getBytes("UTF-8"));
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(FileComplaint.this, "" + e, Toast.LENGTH_SHORT).show();
        }
     api.POST_COMPLAINT_RESPONSE_MODEL_CALL(requestBody).enqueue(new Callback<PostComplaintResponseModel>() {
         @Override
         public void onResponse(Call<PostComplaintResponseModel> call, Response<PostComplaintResponseModel> response) {
             PostComplaintResponseModel postComplaintResponseModel=response.body();
             if(postComplaintResponseModel.getStatus().equalsIgnoreCase("success"))
             {
                 Toast.makeText(FileComplaint.this, postComplaintResponseModel.getStatus(), Toast.LENGTH_SHORT).show();
                 Intent i=new Intent(FileComplaint.this, CitizenHome.class);
                 startActivity(i);
             }
             else
             {
                 Toast.makeText(FileComplaint.this, "Failed", Toast.LENGTH_SHORT).show();
             }
         }

         @Override
         public void onFailure(Call<PostComplaintResponseModel> call, Throwable t) {
             Toast.makeText(FileComplaint.this, t.getMessage(), Toast.LENGTH_SHORT).show();
         }
     });
    }
}
