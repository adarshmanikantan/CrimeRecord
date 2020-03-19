package com.adarsh.crimerecord.Citizen;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.adarsh.crimerecord.Adapter.IPCAdapter;
import com.adarsh.crimerecord.R;
import com.adarsh.crimerecord.Retro.Api;
import com.adarsh.crimerecord.Retro.Api_client;
import com.adarsh.crimerecord.Retro.IpcModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class IpcFragment extends Fragment {
    RecyclerView recyclerView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root=inflater.inflate(R.layout.fragment_blank, container, false);
        recyclerView=root.findViewById(R.id.ipc_recyclerview);

        Api api= Api_client.CitizenRegister().create(Api.class);
        api.IPC_MODEL_CALL().enqueue(new Callback<IpcModel>() {
            @Override
            public void onResponse(Call<IpcModel> call, Response<IpcModel> response) {
                IpcModel ipcModel=response.body();
                LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getActivity(), RecyclerView.VERTICAL,false);
                recyclerView.setLayoutManager(linearLayoutManager);
                IPCAdapter ipcAdapter=new IPCAdapter(getActivity(),ipcModel);
                recyclerView.setAdapter(ipcAdapter);
            }

            @Override
            public void onFailure(Call<IpcModel> call, Throwable t) {

            }
        });

        return root;
    }

}
