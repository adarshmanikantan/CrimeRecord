package com.adarsh.crimerecord.Authority;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.adarsh.crimerecord.Adapter.DistrictAdapter;
import com.adarsh.crimerecord.R;

public class AuthorityHome extends AppCompatActivity {

    RecyclerView recyclerView;

    String[]districts={"Ariyalur","Chengalpattu","Chennai","Coimbatore","Cuddalore","Dharmapuri","Dindigul",
            "Erode","Kanchipuram","Kanniyakumari","Karur","Krishnagiri","Madurai","Nagapattinam","Namakkal",
            "Nilgiris","Perambalur","Pudukkottai","Ramanathapuram","Ranipet","Salem","Sivagangai",
            "Thenkasi","Thanjavur","Theni","Thoothukudi","Tiruchirappalli","Tirunelveli","Tirupattur","Tiruppur","Tiruvallur","Thiruvannamalai",
            "Tiruvarur","Vellore","Viluppuram","Virudhunagar"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authority_home);
        recyclerView=findViewById(R.id.recyclerview);

        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getApplicationContext(),RecyclerView.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);
        DistrictAdapter districtAdapter=new DistrictAdapter(getApplicationContext(),districts);
        recyclerView.setAdapter(districtAdapter);

    }

    public void addPoliceStation(View view) {

        Intent i=new Intent(AuthorityHome.this,AddPoliceStationActivity.class);
        startActivity(i);

    }
}
