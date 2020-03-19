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

import com.adarsh.crimerecord.Citizen.ComplaintEncryption;
import com.adarsh.crimerecord.Police.ViewComplaintDetails;
import com.adarsh.crimerecord.R;
import com.adarsh.crimerecord.Retro.ComplaintStatusModel;
import com.adarsh.crimerecord.Retro.ViewComplaintsByPoliceStationModel;


public class ComplaintListPoliceStationAdapter extends RecyclerView.Adapter<ComplaintListPoliceStationAdapter.myViewHolder>{
    ViewComplaintsByPoliceStationModel complaintStatusModel;
    Context context;
    int complaint_id;
    String district,police_station,complaint_type,
     place,date, time, details, flagset;
    public ComplaintListPoliceStationAdapter(Context context, ViewComplaintsByPoliceStationModel complaintStatusModel)
    {
     this.complaintStatusModel=complaintStatusModel;
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


        date=complaintStatusModel.getComplaintData().getResults().get(position).getDate();
        holder.name.setText(complaintStatusModel.getComplaintData().getResults().get(position).getComplaint_type());
        holder.textView.setText(date);

      holder.itemView.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              complaint_id=complaintStatusModel.getComplaintData().getResults().get(position).getId();
              district=complaintStatusModel.getComplaintData().getResults().get(position).getDistrict();
              police_station=complaintStatusModel.getComplaintData().getResults().get(position).getPolice_Station();
              complaint_type=complaintStatusModel.getComplaintData().getResults().get(position).getComplaint_type();
              place=complaintStatusModel.getComplaintData().getResults().get(position).getPlace_of_occurence();
              date=complaintStatusModel.getComplaintData().getResults().get(position).getDate();
              time=complaintStatusModel.getComplaintData().getResults().get(position).getTime();
              details=complaintStatusModel.getComplaintData().getResults().get(position).getDetails();
              flagset=complaintStatusModel.getComplaintData().getResults().get(position).getFlagset();
              SharedPreferences sharedPreferences=context.getSharedPreferences("complaint",Context.MODE_PRIVATE);
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
              Intent i=new Intent(context, ViewComplaintDetails.class);
              holder.itemView.getContext().startActivity(i);
          }
      });
    }

    @Override
    public int getItemCount() {
        return complaintStatusModel.getComplaintData().getResults().size();
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
