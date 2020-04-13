package com.adarsh.crimerecord.Police;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Toast;

import com.adarsh.crimerecord.Adapter.ComplaintListPoliceStationAdapter;
import com.adarsh.crimerecord.Adapter.FirListPoliceStationAdapter;
import com.adarsh.crimerecord.R;
import com.adarsh.crimerecord.Retro.Api;
import com.adarsh.crimerecord.Retro.Api_client;
import com.adarsh.crimerecord.Retro.ViewComplaintsByPoliceStationModel;
import com.adarsh.crimerecord.Retro.ViewFirModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ViewFir extends AppCompatActivity {

    RecyclerView recyclerView;
    FirListPoliceStationAdapter firListPoliceStationAdapter;
    LinearLayoutManager linearLayoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_fir);

        recyclerView=findViewById(R.id.fir_recyclerview);

        SharedPreferences sharedPreferences=getApplicationContext().getSharedPreferences("police",MODE_PRIVATE);
        int id=sharedPreferences.getInt("policestation_id",0);
        Toast.makeText(this,String.valueOf(id), Toast.LENGTH_SHORT).show();
        Api api= Api_client.CitizenRegister().create(Api.class);
        api.VIEW_FIR_MODEL_CALL(id).enqueue(new Callback<ViewFirModel>() {
            @Override
            public void onResponse(Call<ViewFirModel> call, Response<ViewFirModel> response) {
                ViewFirModel viewFirModel=response.body();
                if(viewFirModel.getStatus().equalsIgnoreCase("Success"))

                     linearLayoutManager=new LinearLayoutManager(getApplicationContext(),RecyclerView.VERTICAL,false);
                     recyclerView.setLayoutManager(linearLayoutManager);
                firListPoliceStationAdapter =new FirListPoliceStationAdapter(getApplicationContext(),viewFirModel);
                recyclerView.setAdapter(firListPoliceStationAdapter);
            }

            @Override
            public void onFailure(Call<ViewFirModel> call, Throwable t) {
                Toast.makeText(ViewFir.this, "Nothing to show", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
