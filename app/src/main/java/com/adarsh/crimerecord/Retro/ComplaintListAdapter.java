package com.adarsh.crimerecord.Retro;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.adarsh.crimerecord.Citizen.ComplaintEncryption;
import com.adarsh.crimerecord.R;


public class ComplaintListAdapter extends RecyclerView.Adapter<ComplaintListAdapter.myViewHolder>{
    ComplaintStatusModel complaintStatusModel;
    Context context;
    int complaint_id;
    String district,police_station,complaint_type,
     place,date, time, details, flagset;
    public ComplaintListAdapter(Context context,ComplaintStatusModel complaintStatusModel)
    {
     this.complaintStatusModel=complaintStatusModel;
     this.context=context;
    }
    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.crime_row, parent, false);
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


        date=complaintStatusModel.getCitizenData().getResults().get(position).getDate();

        holder.textView.setText(date);

      holder.itemView.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              complaint_id=complaintStatusModel.getCitizenData().getResults().get(position).getId();
              district=complaintStatusModel.getCitizenData().getResults().get(position).getDistrict();
              police_station=complaintStatusModel.getCitizenData().getResults().get(position).getPolice_Station();
              complaint_type=complaintStatusModel.getCitizenData().getResults().get(position).getComplaint_type();
              place=complaintStatusModel.getCitizenData().getResults().get(position).getPlace_of_occurence();
              date=complaintStatusModel.getCitizenData().getResults().get(position).getDate();
              time=complaintStatusModel.getCitizenData().getResults().get(position).getTime();
              details=complaintStatusModel.getCitizenData().getResults().get(position).getDetails();
              flagset=complaintStatusModel.getCitizenData().getResults().get(position).getFlagset();
              SharedPreferences sharedPreferences=context.getSharedPreferences("complaint_status",Context.MODE_PRIVATE);
              SharedPreferences.Editor editor=sharedPreferences.edit();

              editor.putInt("complaint_id",complaint_id);
              editor.putString("district",district);
              editor.putString("police_station",police_station);
              editor.putString("complaint_type",complaint_type);
              editor.putString("place",place);
              editor.putString("date",date);
              editor.putString("time",time);
              editor.putString("details",details);
              editor.putString("flagset",flagset);
              editor.apply();
              Intent i=new Intent(context, ComplaintEncryption.class);
              holder.itemView.getContext().startActivity(i);
          }
      });
    }

    @Override
    public int getItemCount() {
        return complaintStatusModel.getCitizenData().getResults().size();
    }

    public class myViewHolder extends RecyclerView.ViewHolder
    {

        TextView textView;
        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.event_date);

        }
    }
}
