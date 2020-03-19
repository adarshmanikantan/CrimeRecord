package com.adarsh.crimerecord.Police;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.adarsh.crimerecord.R;
import com.adarsh.crimerecord.Retro.Api;
import com.adarsh.crimerecord.Retro.Api_client;
import com.adarsh.crimerecord.Retro.PoliceLoginModel;
import com.google.android.material.textfield.TextInputEditText;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PoliceLogin extends AppCompatActivity {

    private TextInputEditText psCode;
    private TextInputEditText psPswd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_police_login);
        initView();


    }

    private void initView() {
        psCode = findViewById(R.id.ps_code);
        psPswd = findViewById(R.id.ps_pswd);
    }

    public void PoliceLoginClick(View view) {
        Api api= Api_client.CitizenRegister().create(Api.class);
        api.POLICE_LOGIN_MODEL_CALL(psCode.getText().toString(),psPswd.getText().toString()).enqueue(new Callback<PoliceLoginModel>() {
            @Override
            public void onResponse(Call<PoliceLoginModel> call, Response<PoliceLoginModel> response) {
                PoliceLoginModel policeLoginModel=response.body();
                if(policeLoginModel.getStatus().equalsIgnoreCase("success"))
                {
                    Toast.makeText(PoliceLogin.this,policeLoginModel.getStatus(), Toast.LENGTH_SHORT).show();

                    int policestation_id=policeLoginModel.getPoliceDetails().getResults().get(0).getId();
                    String name=policeLoginModel.getPoliceDetails().getResults().get(0).getName();
                    String district=policeLoginModel.getPoliceDetails().getResults().get(0).getDistrict();
                    String email=policeLoginModel.getPoliceDetails().getResults().get(0).getEmail();
                    String password=policeLoginModel.getPoliceDetails().getResults().get(0).getPassword();
                    String code=policeLoginModel.getPoliceDetails().getResults().get(0).getCode();

                    SharedPreferences sharedPreferences=getApplicationContext().getSharedPreferences("police",MODE_PRIVATE);
                    SharedPreferences.Editor editor=sharedPreferences.edit();
                    editor.putInt("policestation_id",policestation_id);
                    editor.putString("name",name);
                    editor.putString("district",district);
                    editor.putString("email",email);
                    editor.putString("password",password);
                    editor.putString("code",code);
                    editor.apply();

                    Intent i=new Intent(PoliceLogin.this,PoliceHome.class);
                    startActivity(i);
                }
                else
                {
                    Toast.makeText(PoliceLogin.this,policeLoginModel.getStatus(), Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onFailure(Call<PoliceLoginModel> call, Throwable t) {
                Toast.makeText(PoliceLogin.this,t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }
}
