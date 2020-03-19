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

public class DistrictAdapter extends RecyclerView.Adapter<DistrictAdapter.myViewHolder> {
    Context context;
    String[]districts;
    public DistrictAdapter(Context context,String[]districts)
    {
        this.context=context;
        this.districts=districts;
    }
    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.district_row,parent,false);
        DistrictAdapter.myViewHolder holder=new DistrictAdapter.myViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final myViewHolder holder, final int position) {
      holder.district.setText(districts[position]);
      holder.itemView.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              Intent i=new Intent(context, ViewPoliceStations.class);
              holder.itemView.getContext().startActivity(i);

              SharedPreferences sharedPreferences=context.getSharedPreferences("district",Context.MODE_PRIVATE);
              SharedPreferences.Editor editor=sharedPreferences.edit();
              editor.putString("districts",districts[position]);
              editor.apply();
          }
      });
    }

    @Override
    public int getItemCount() {
        return districts.length;
    }

    public class myViewHolder extends RecyclerView.ViewHolder {
        TextView district;
        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            district=itemView.findViewById(R.id.district_txtview);
        }
    }
}
