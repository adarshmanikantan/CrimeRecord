package com.adarsh.crimerecord;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.view.ViewCompat;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.adarsh.crimerecord.Retro.Api;
import com.adarsh.crimerecord.Retro.Api_client;
import com.adarsh.crimerecord.Retro.CitizenLoginModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CitizenLogin extends AppCompatActivity {

    ImageView top_curve;
    EditText email,password;
    TextView email_text, password_text, login_title;
    ImageView logo;
    LinearLayout new_user_layout;
    LinearLayout login_card;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_citizen_login);
        top_curve = findViewById(R.id.top_curve);
        email = findViewById(R.id.email);
        email_text = findViewById(R.id.email_text);
        password = findViewById(R.id.password);
        password_text = findViewById(R.id.password_text);
        logo = findViewById(R.id.logo);
        login_title = findViewById(R.id.login_text);
        new_user_layout = findViewById(R.id.new_user_text);
        login_card = findViewById(R.id.login_card);


        Animation top_curve_anim = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.top_down);
        top_curve.startAnimation(top_curve_anim);

        Animation editText_anim = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.edittext_anim);
        email.startAnimation(editText_anim);
        password.startAnimation(editText_anim);

        Animation field_name_anim = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.field_name_anim);
        email_text.startAnimation(field_name_anim);
        password_text.startAnimation(field_name_anim);
        logo.startAnimation(field_name_anim);
        login_title.startAnimation(field_name_anim);

        Animation center_reveal_anim = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.center_reveal_anim);
        login_card.startAnimation(center_reveal_anim);

        Animation new_user_anim = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.down_top);
        new_user_layout.startAnimation(new_user_anim);



    }


    public void register(View view) {

       Intent i=new Intent(this,CitizenSignUp.class);
       startActivity(i);
    }

    public void loginButton(View view) {
        if(email.getText().toString().equals(""))
        {
         email.setError("enter email");
        }
        else if(password.getText().toString().equals(""))
        {
          password.setError("enter password");
        }
        else {
            Api api = Api_client.CitizenRegister().create(Api.class);
            final String s_email = email.getText().toString();
            String s_pswd = password.getText().toString();

            api.CITIZEN_LOGIN_MODEL_CALL(s_email, s_pswd).enqueue(new Callback<CitizenLoginModel>() {
                @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
                @Override
                public void onResponse(Call<CitizenLoginModel> call, Response<CitizenLoginModel> response) {
                    CitizenLoginModel citizenLoginModel = response.body();
                    String status = citizenLoginModel.getStatus();
                    if (status.equalsIgnoreCase("Success")) {
                        int userid= citizenLoginModel.getUser_id();

                        SharedPreferences sharedPreferences=getApplicationContext().getSharedPreferences("userpref",MODE_PRIVATE);
                        SharedPreferences.Editor editor=sharedPreferences.edit();
                        editor.putInt("key1",userid);
                        editor.putString("key2",s_email);
                        editor.apply();
                        Toast.makeText(CitizenLogin.this, status, Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(CitizenLogin.this, CitizenHome.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(CitizenLogin.this, "Login failed", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<CitizenLoginModel> call, Throwable t) {

                }
            });
        }

    }
}
