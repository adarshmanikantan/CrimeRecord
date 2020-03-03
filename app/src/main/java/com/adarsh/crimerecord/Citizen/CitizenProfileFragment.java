package com.adarsh.crimerecord.Citizen;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.adarsh.crimerecord.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class CitizenProfileFragment extends Fragment {

     TextView uid,name,gender,yearOfBirth,careof,house,
              villageTehsil,postOffice,district,state,postCode;

    String suid,sname,sgender,syearOfBirth,scareOf,svillageTehsil,spostOffice,sdistrict,sstate,shouse,spostCode;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_citizen_profile, container, false);
        // Inflate the layout for this fragment

              uid=view.findViewById(R.id.tv_sd_uid);
              name=view.findViewById(R.id.tv_sd_name);
              gender=view.findViewById(R.id.tv_sd_gender);
              yearOfBirth=view.findViewById(R.id.tv_sd_yob);
              careof=view.findViewById(R.id.tv_sd_co);
              house=view.findViewById(R.id.tv_sd_house);
              villageTehsil=view.findViewById(R.id.tv_sd_vtc);
              postOffice=view.findViewById(R.id.tv_sd_po);
              district=view.findViewById(R.id.tv_sd_dist);
              state=view.findViewById(R.id.tv_sd_state);
              postCode=view.findViewById(R.id.tv_sd_pc);


        SharedPreferences sharedPreferences=getActivity().getSharedPreferences("pref", Context.MODE_PRIVATE);

        suid=sharedPreferences.getString("key1",null);
        sname=sharedPreferences.getString("key2",null);
        sgender=sharedPreferences.getString("key3",null);
        syearOfBirth=sharedPreferences.getString("key4",null);
         scareOf=sharedPreferences.getString("key5",null);
          shouse=sharedPreferences.getString("key6",null);
          svillageTehsil=sharedPreferences.getString("key7",null);
          spostOffice=sharedPreferences.getString("key8",null);
         sdistrict=sharedPreferences.getString("key9",null);
         sstate=sharedPreferences.getString("key10",null);
         spostOffice=sharedPreferences.getString("key11",null);

         uid.setText(suid);
         name.setText(sname);
         gender.setText(sgender);
         yearOfBirth.setText(syearOfBirth);
         careof.setText(scareOf);
         house.setText(shouse);
         villageTehsil.setText(svillageTehsil);
         postOffice.setText(spostOffice);
         district.setText(sdistrict);
         state.setText(sstate);
         postOffice.setText(spostOffice);
         postCode.setText(spostCode);
        return view;
    }

}
