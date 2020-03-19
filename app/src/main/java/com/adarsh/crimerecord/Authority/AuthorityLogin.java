package com.adarsh.crimerecord.Authority;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.adarsh.crimerecord.R;
import com.adarsh.crimerecord.Retro.Api;
import com.adarsh.crimerecord.Retro.Api_client;
import com.adarsh.crimerecord.Retro.AuthorityLoginModel;
import com.google.android.material.textfield.TextInputEditText;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AuthorityLogin extends AppCompatActivity {

    private TextInputEditText email;
    private TextInputEditText pswd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authority_login);
        initView();
    }

    private void initView() {
        email = findViewById(R.id.email);
        pswd = findViewById(R.id.pswd);
    }

    public void LoginClick(View view) {
        if(email.getText().toString().equals(""))
        {
           email.setError("Enter email");
        }
        else if(pswd.getText().toString().equals(""))
        {
            pswd.setError("Enter Password");
        }
        else
        {
            Api api=Api_client.CitizenRegister().create(Api.class);
            api.AUTHORITY_LOGIN_MODEL_CALL(email.getText().toString(),pswd.getText().toString()).enqueue(new Callback<AuthorityLoginModel>() {
                @Override
                public void onResponse(Call<AuthorityLoginModel> call, Response<AuthorityLoginModel>response) {
                    AuthorityLoginModel authorityLoginModel=response.body();
                   if(response.body()==null)
                   {
                       Toast.makeText(AuthorityLogin.this, "null", Toast.LENGTH_SHORT).show();
                   }
                   else
                   {
                       if(authorityLoginModel.getStatus().equalsIgnoreCase("success"))
                       {
                           Toast.makeText(AuthorityLogin.this,authorityLoginModel.getStatus(), Toast.LENGTH_SHORT).show();
                           Intent i=new Intent(AuthorityLogin.this,AuthorityHome.class);
                           startActivity(i);
                       }
                       else
                       {
                           Toast.makeText(AuthorityLogin.this,authorityLoginModel.getStatus(), Toast.LENGTH_SHORT).show();
                       }
                   }

                }

                @Override
                public void onFailure(Call<AuthorityLoginModel> call, Throwable t) {
                    Toast.makeText(AuthorityLogin.this,t.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
