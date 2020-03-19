package com.adarsh.crimerecord.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.adarsh.crimerecord.Citizen.IPCSections;
import com.adarsh.crimerecord.R;
import com.adarsh.crimerecord.Retro.IpcModel;

public class IPCAdapter extends RecyclerView.Adapter<IPCAdapter.MyViewHolder> {

    Context context;
    IpcModel ipcModel;
    public IPCAdapter(Context context,IpcModel ipcModel)
    {
        this.context=context;
        this.ipcModel=ipcModel;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_vw,parent,false);
        IPCAdapter.MyViewHolder holder=new IPCAdapter.MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
     holder.sectionno.setText(ipcModel.getPoliceStations().getResults().get(position).getSection());
     holder.sectiontitle.setText(ipcModel.getPoliceStations().getResults().get(position).getTitle());
     holder.sectiondesc.setText(ipcModel.getPoliceStations().getResults().get(position).getDescription());
    }

    @Override
    public int getItemCount() {
        return ipcModel.getPoliceStations().getResults().size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
       TextView sectionno,sectiontitle,sectiondesc;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            sectionno=itemView.findViewById(R.id.numberipc);
            sectiontitle=itemView.findViewById(R.id.titleipc);
            sectiondesc=itemView.findViewById(R.id.titledesc);
        }
    }
}
