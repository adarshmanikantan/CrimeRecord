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

import com.adarsh.crimerecord.Police.ViewComplaintDetails;
import com.adarsh.crimerecord.R;
import com.adarsh.crimerecord.Retro.ViewComplaintsByPoliceStationModel;
import com.adarsh.crimerecord.Retro.ViewFirModel;


public class FirListPoliceStationAdapter extends RecyclerView.Adapter<FirListPoliceStationAdapter.myViewHolder>{
    ViewFirModel viewFirModel;
    Context context;
    int complaint_id;
    String district,police_station,complaint_type,
     place,date, time, details, flagset;
    public FirListPoliceStationAdapter(Context context, ViewFirModel viewFirModel)
    {
     this.viewFirModel=viewFirModel;
     this.context=context;
    }
    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.crime_row_police, parent, false);
        int position=parent.indexOfChild(itemView);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        return new myViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final myViewHolder holder, final int position) {


        date=viewFirModel.getFirDetails().getResults().get(position).getFir_date();
        holder.name.setText(viewFirModel.getFirDetails().getResults().get(position).getInfrm_type());
        holder.textView.setText(date);

      holder.itemView.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {


          }
      });
    }

    @Override
    public int getItemCount() {
        return viewFirModel.getFirDetails().getResults().size();
    }

    public class myViewHolder extends RecyclerView.ViewHolder
    {

        TextView name,textView;
        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.citizen_name);
            textView=itemView.findViewById(R.id.p_event_date);

        }
    }
}
