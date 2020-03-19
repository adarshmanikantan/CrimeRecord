package com.adarsh.crimerecord.Citizen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.adarsh.crimerecord.Adapter.IPCAdapter;
import com.adarsh.crimerecord.R;
import com.adarsh.crimerecord.Retro.Api;
import com.adarsh.crimerecord.Retro.Api_client;
import com.adarsh.crimerecord.Retro.IpcModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class IPCSections extends AppCompatActivity {

    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ipcsections);

        recyclerView=findViewById(R.id.ipc_recycler);

     Api api= Api_client.CitizenRegister().create(Api.class);
     api.IPC_MODEL_CALL().enqueue(new Callback<IpcModel>() {
         @Override
         public void onResponse(Call<IpcModel> call, Response<IpcModel> response) {
             IpcModel ipcModel=response.body();
             LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getApplicationContext(),RecyclerView.VERTICAL,false);
             recyclerView.setLayoutManager(linearLayoutManager);
             IPCAdapter ipcAdapter=new IPCAdapter(getApplicationContext(),ipcModel);
             recyclerView.setAdapter(ipcAdapter);
         }

         @Override
         public void onFailure(Call<IpcModel> call, Throwable t) {

         }
     });
    }
}
