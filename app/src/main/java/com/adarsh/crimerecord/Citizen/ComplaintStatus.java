package com.adarsh.crimerecord.Citizen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.SharedPreferences;
import android.os.Bundle;

import com.adarsh.crimerecord.R;
import com.adarsh.crimerecord.Retro.Api;
import com.adarsh.crimerecord.Retro.Api_client;
import com.adarsh.crimerecord.Retro.ComplaintListAdapter;
import com.adarsh.crimerecord.Retro.ComplaintStatusModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ComplaintStatus extends AppCompatActivity {

    RecyclerView recyclerView;
    ComplaintListAdapter complaintListAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complaint_status);

        recyclerView=findViewById(R.id.complaint_status_recyclerView);

        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getApplicationContext(),RecyclerView.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);
        SharedPreferences sharedPreferences=getApplicationContext().getSharedPreferences("userpref",MODE_PRIVATE);
        int userid=sharedPreferences.getInt("key1",0);
       Api api= Api_client.CitizenRegister().create(Api.class);
       api.COMPLAINT_STATUS_MODEL_CALL(userid).enqueue(new Callback<ComplaintStatusModel>() {
           @Override
           public void onResponse(Call<ComplaintStatusModel> call, Response<ComplaintStatusModel> response) {
               ComplaintStatusModel complaintStatusModel=response.body();
                 if(complaintStatusModel.getStatus().equalsIgnoreCase("Success"))
                      complaintListAdapter=new ComplaintListAdapter(getApplicationContext(),complaintStatusModel);
                      recyclerView.setAdapter(complaintListAdapter);
                 }

           @Override
           public void onFailure(Call<ComplaintStatusModel> call, Throwable t) {

           }
       });
    }
}
