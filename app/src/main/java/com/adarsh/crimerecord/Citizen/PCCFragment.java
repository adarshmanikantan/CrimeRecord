package com.adarsh.crimerecord.Citizen;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.adarsh.crimerecord.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class PCCFragment extends Fragment {

    LinearLayout filepcc,viewpcc;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root=inflater.inflate(R.layout.fragment_pcc, container, false);
        filepcc=root.findViewById(R.id.file_pcc_layout);
        viewpcc=root.findViewById(R.id.pcc_status_layout);

        filepcc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getActivity(),FilePCC.class);
                startActivity(i);
            }
        });

        viewpcc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getActivity(),ViewPCC.class);
                startActivity(i);
            }
        });
        return root;
    }

}
