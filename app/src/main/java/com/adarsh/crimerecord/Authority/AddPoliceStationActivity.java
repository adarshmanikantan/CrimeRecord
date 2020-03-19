package com.adarsh.crimerecord.Authority;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.adarsh.crimerecord.CitizenSignUp;
import com.adarsh.crimerecord.R;
import com.adarsh.crimerecord.Retro.AddPoliceRequestModel;
import com.adarsh.crimerecord.Retro.AddPoliceResponseModel;
import com.adarsh.crimerecord.Retro.Api;
import com.adarsh.crimerecord.Retro.Api_client;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.gson.Gson;

import java.util.ArrayList;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddPoliceStationActivity extends AppCompatActivity {
    private TextInputEditText policeStationName;
    private Spinner districtspinner;
    private TextInputLayout outlinedCodeField;
    private TextInputEditText policeStationCode;
    private TextInputLayout outlinedTextField;
    private TextInputEditText policeStationEmail;
    private TextInputEditText policeStationPswd;
    String district;
    String Json;
    RequestBody requestBody;
    String[]districtss={"Ariyalur","Chengalpattu","Chennai","Coimbatore","Cuddalore","Dharmapuri","Dindigul",
            "Erode","Kanchipuram","Kanniyakumari","Karur","Krishnagiri","Madurai","Nagapattinam","Namakkal",
            "Nilgiris","Perambalur","Pudukkottai","Ramanathapuram","Ranipet","Salem","Sivagangai",
             "Thenkasi","Thanjavur","Theni","Thoothukudi","Tiruchirappalli","Tirunelveli","Tirupattur","Tiruppur","Tiruvallur","Thiruvannamalai",
            "Tiruvarur","Vellore","Viluppuram","Virudhunagar"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_police_station);
        initView();
        final ArrayList<String> districts = new ArrayList<>();
        ArrayAdapter<String> adapt = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,districtss);

        districtspinner.setAdapter(adapt);


    districtspinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            district=districtss[position];
            Toast.makeText(AddPoliceStationActivity.this,district, Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    });

    }

    public void addPoliceStationMethod(View view) {
        Api api= Api_client.CitizenRegister().create(Api.class);
        String psname=policeStationName.getText().toString();
        String psdistrict=district;
        String code=policeStationCode.getText().toString();
        String email=policeStationEmail.getText().toString();
        String password=policeStationPswd.getText().toString();
        final AddPoliceRequestModel addPoliceRequestModel=new AddPoliceRequestModel();
        addPoliceRequestModel.setAuthority_id(3);
        addPoliceRequestModel.setName(psname);
        addPoliceRequestModel.setDistrict(psdistrict);
        addPoliceRequestModel.setCode(code);
        addPoliceRequestModel.setEmail(email);
        addPoliceRequestModel.setPassword(password);

        Gson gson = new Gson();
        Json = gson.toJson(addPoliceRequestModel).trim();
        try {
            requestBody = RequestBody.create(MediaType.parse("application/json"), Json.getBytes("UTF-8"));
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(AddPoliceStationActivity.this, "" + e, Toast.LENGTH_SHORT).show();
        }

        api.ADD_POLICE_RESPONSE_MODEL_CALL(requestBody).enqueue(new Callback<AddPoliceResponseModel>() {
            @Override
            public void onResponse(Call<AddPoliceResponseModel> call, Response<AddPoliceResponseModel> response) {
                AddPoliceResponseModel addPoliceResponseModel = response.body();
                if (response.body() == null) {
                    Toast.makeText(AddPoliceStationActivity.this,district, Toast.LENGTH_SHORT).show();
                } else {
                    if (addPoliceResponseModel.getStatus().equalsIgnoreCase("success")) {
                        Toast.makeText(AddPoliceStationActivity.this, addPoliceResponseModel.getStatus()+district, Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(AddPoliceStationActivity.this, addPoliceResponseModel.getStatus(), Toast.LENGTH_SHORT).show();
                    }

                }
            }

            @Override
            public void onFailure(Call<AddPoliceResponseModel> call, Throwable t) {
                Toast.makeText(AddPoliceStationActivity.this,t.getMessage()+district, Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void initView() {
        policeStationName = findViewById(R.id.police_station_name);
        districtspinner = findViewById(R.id.districtspinner);
        outlinedCodeField = findViewById(R.id.outlinedCodeField);
        policeStationCode = findViewById(R.id.police_station_code);
        outlinedTextField = findViewById(R.id.outlinedTextField);
        policeStationEmail = findViewById(R.id.police_station_email);
        policeStationPswd = findViewById(R.id.police_station_pswd);
    }
}
