package com.adarsh.crimerecord.Authority;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Toast;

import com.adarsh.crimerecord.Adapter.PoliceStationAdapter;
import com.adarsh.crimerecord.R;
import com.adarsh.crimerecord.Retro.Api;
import com.adarsh.crimerecord.Retro.Api_client;
import com.adarsh.crimerecord.Retro.PoliceStationByDistrictModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ViewPoliceStations extends AppCompatActivity {
     String district;
     RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_police_stations);
        recyclerView=findViewById(R.id.psrecycler);
        SharedPreferences sharedPreferences=getApplicationContext().getSharedPreferences("district", Context.MODE_PRIVATE);
        district=sharedPreferences.getString("districts",null);

        Api api= Api_client.CitizenRegister().create(Api.class);
        api.POLICE_STATION_BY_DISTRICT_MODEL_CALL(district).enqueue(new Callback<PoliceStationByDistrictModel>() {
            @Override
            public void onResponse(Call<PoliceStationByDistrictModel> call, Response<PoliceStationByDistrictModel> response) {

                PoliceStationByDistrictModel policeStationByDistrictModel=response.body();
                if(policeStationByDistrictModel.getStatus().equalsIgnoreCase("success")) {
                    GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(), 2);
                    recyclerView.setLayoutManager(gridLayoutManager);

                    PoliceStationAdapter policeStationAdapter = new PoliceStationAdapter(getApplicationContext(), policeStationByDistrictModel);
                    recyclerView.setAdapter(policeStationAdapter);
                }
                else {
                    Toast.makeText(ViewPoliceStations.this, "Add PoliceStations", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<PoliceStationByDistrictModel> call, Throwable t) {

            }
        });
    }
}
