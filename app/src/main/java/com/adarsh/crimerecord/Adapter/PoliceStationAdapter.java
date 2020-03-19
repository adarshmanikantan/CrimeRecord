package com.adarsh.crimerecord.Adapter;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.adarsh.crimerecord.Authority.ViewPoliceStations;
import com.adarsh.crimerecord.R;
import com.adarsh.crimerecord.Retro.PoliceStationByDistrictModel;

public class PoliceStationAdapter extends RecyclerView.Adapter<PoliceStationAdapter.myViewHolder> {
    Context context;
    PoliceStationByDistrictModel policeStationByDistrictModel;
    public PoliceStationAdapter(Context context, PoliceStationByDistrictModel policeStationByDistrictModel)
    {
        this.context=context;
        this.policeStationByDistrictModel=policeStationByDistrictModel;
    }
    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.district_row,parent,false);
        PoliceStationAdapter.myViewHolder holder=new PoliceStationAdapter.myViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final myViewHolder holder, final int position) {
      holder.district.setText(policeStationByDistrictModel.getPoliceStations().getResults().get(position).getName());
      holder.itemView.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              Intent i=new Intent(context, ViewPoliceStations.class);
              holder.itemView.getContext().startActivity(i);

          }
      });
    }

    @Override
    public int getItemCount() {
        return policeStationByDistrictModel.getPoliceStations().getResults().size();
    }

    public class myViewHolder extends RecyclerView.ViewHolder {
        TextView district;
        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            district=itemView.findViewById(R.id.district_txtview);
        }
    }
}
