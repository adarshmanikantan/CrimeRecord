package com.adarsh.crimerecord.Citizen;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.fragment.app.Fragment;

import com.adarsh.crimerecord.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {

    LinearLayout complaintfile_linearLayout,complaintstatus;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        complaintfile_linearLayout=view.findViewById(R.id.file_complaint_layout);
        complaintstatus=view.findViewById(R.id.complaint_status_layout);
        complaintfile_linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),FileComplaint.class);
                startActivity(intent);
            }
        });

        complaintstatus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getActivity(),ComplaintStatus.class);
                startActivity(i);
            }
        });



        return view;
    }


}
