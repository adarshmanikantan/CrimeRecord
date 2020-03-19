package com.adarsh.crimerecord.Police;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.SharedPreferences;
import android.os.Bundle;

import com.adarsh.crimerecord.Adapter.ComplaintListPoliceStationAdapter;
import com.adarsh.crimerecord.R;
import com.adarsh.crimerecord.Retro.Api;
import com.adarsh.crimerecord.Retro.Api_client;
import com.adarsh.crimerecord.Retro.ComplaintListAdapter;
import com.adarsh.crimerecord.Retro.ComplaintStatusModel;
import com.adarsh.crimerecord.Retro.ViewComplaintsByPoliceStationModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ViewComplaints extends AppCompatActivity {

    RecyclerView recyclerView;
    ComplaintListPoliceStationAdapter complaintListAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_complaints);

        recyclerView=findViewById(R.id.view_complaints_recyclerview);

        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getApplicationContext(),RecyclerView.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);
        SharedPreferences sharedPreferences=getApplicationContext().getSharedPreferences("police",MODE_PRIVATE);
         String psname=sharedPreferences.getString("name",null);

        Api api= Api_client.CitizenRegister().create(Api.class);
        api.VIEW_COMPLAINTS_BY_POLICE_STATION_MODEL_CALL(psname).enqueue(new Callback<ViewComplaintsByPoliceStationModel>() {
            @Override
            public void onResponse(Call<ViewComplaintsByPoliceStationModel> call, Response<ViewComplaintsByPoliceStationModel> response) {
                ViewComplaintsByPoliceStationModel  complaintStatusModel=response.body();
                if(complaintStatusModel.getStatus().equalsIgnoreCase("Success"))
                    complaintListAdapter=new ComplaintListPoliceStationAdapter(getApplicationContext(),complaintStatusModel);
                recyclerView.setAdapter(complaintListAdapter);
            }

            @Override
            public void onFailure(Call<ViewComplaintsByPoliceStationModel> call, Throwable t) {

            }
        });
    }
}
