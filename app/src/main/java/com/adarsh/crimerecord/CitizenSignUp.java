package com.adarsh.crimerecord;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


import com.adarsh.crimerecord.Retro.Api;
import com.adarsh.crimerecord.Retro.Api_client;
import com.adarsh.crimerecord.Retro.CitizenRegisterModel;
import com.adarsh.crimerecord.Retro.CitizenRegisterRequest;
import com.google.gson.Gson;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CitizenSignUp extends AppCompatActivity {
    // variables to store extracted xml data
    String uid, name, gender, yearOfBirth, careOf, villageTehsil, street, postOffice, district, subdistrict, state, house, postCode;

    EditText name_edt, email_edt, phone_edt, password_edt, confirmpswd_edt;
    // Storage
    Storage storage;
    String Json;
    RequestBody requestBody = null;


    private static final int MY_CAMERA_REQUEST_CODE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //hide the default action bar
        setContentView(R.layout.activity_citizen_sign_up);

        name_edt = findViewById(R.id.citizennameedt);
        email_edt = findViewById(R.id.citizenemailedt);
        phone_edt = findViewById(R.id.citizennumberedt);
        password_edt = findViewById(R.id.citizenpasswordedt);
        confirmpswd_edt = findViewById(R.id.citizenconfirmedt);

        storage = new Storage(this);
    }

    public void checkCameraPermission() {

    }

    /**
     * onclick handler for scan new card
     *
     * @param view
     */
    public void signupClick(View view) {


        // we need to check if the user has granted the camera permissions
        // otherwise scanner will not work
        if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CAMERA)
                == PackageManager.PERMISSION_DENIED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, MY_CAMERA_REQUEST_CODE);
            return;
        }

        IntentIntegrator integrator = new IntentIntegrator(this);
        integrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE_TYPES);
        integrator.setPrompt("Scan a Aadharcard QR Code");
        integrator.setCameraId(0);  // Use a specific camera of the device
        integrator.initiateScan();

    }

    /**
     * function handle scan result
     *
     * @param requestCode
     * @param resultCode
     * @param intent
     */
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        //retrieve scan result
        super.onActivityResult(requestCode, resultCode, intent);
        IntentResult scanningResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, intent);

        if (scanningResult != null) {
            //we have a result
            String scanContent = scanningResult.getContents();
            String scanFormat = scanningResult.getFormatName();

            // process received data
            if (scanContent != null && !scanContent.isEmpty()) {
                processScannedData(scanContent);


            } else {
                Toast toast = Toast.makeText(getApplicationContext(), "Scan Cancelled", Toast.LENGTH_SHORT);
                toast.show();
            }

        } else {
            Toast toast = Toast.makeText(getApplicationContext(), "No scan data received!", Toast.LENGTH_SHORT);
            toast.show();
        }
    }

    /**
     * process xml string received from aadhaar card QR code
     *
     * @param scanData
     */
    protected void processScannedData(String scanData) {
        Log.d("Rajdeol", scanData);
        XmlPullParserFactory pullParserFactory;

        try {
            // init the parserfactory
            pullParserFactory = XmlPullParserFactory.newInstance();
            // get the parser
            XmlPullParser parser = pullParserFactory.newPullParser();

            parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
            parser.setInput(new StringReader(scanData));

            // parse the XML
            int eventType = parser.getEventType();
            while (eventType != XmlPullParser.END_DOCUMENT) {
                if (eventType == XmlPullParser.START_DOCUMENT) {
                    Log.d("Rajdeol", "Start document");
                } else if (eventType == XmlPullParser.START_TAG && DataAttributes.AADHAAR_DATA_TAG.equals(parser.getName())) {
                    // extract data from tag
                    //uid
                    uid = parser.getAttributeValue(null, DataAttributes.AADHAR_UID_ATTR);
                    //name
                    name = parser.getAttributeValue(null, DataAttributes.AADHAR_NAME_ATTR);
                    //gender
                    gender = parser.getAttributeValue(null, DataAttributes.AADHAR_GENDER_ATTR);
                    // year of birth
                    yearOfBirth = parser.getAttributeValue(null, DataAttributes.AADHAR_YOB_ATTR);
                    // care of
                    careOf = parser.getAttributeValue(null, DataAttributes.AADHAR_CO_ATTR);

                    house = parser.getAttributeValue(null, DataAttributes.AADHAR_HOUSE_ATTR);

                    street = parser.getAttributeValue(null, DataAttributes.AADHAR_STREET_ATTR);
                    // village Tehsil
                    villageTehsil = parser.getAttributeValue(null, DataAttributes.AADHAR_VTC_ATTR);
                    // Post Office
                    postOffice = parser.getAttributeValue(null, DataAttributes.AADHAR_PO_ATTR);
                    // district
                    district = parser.getAttributeValue(null, DataAttributes.AADHAR_DIST_ATTR);

                    subdistrict = parser.getAttributeValue(null, DataAttributes.AADHAR_SUBDIST_ATTR);
                    // state
                    state = parser.getAttributeValue(null, DataAttributes.AADHAR_STATE_ATTR);
                    // Post Code
                    postCode = parser.getAttributeValue(null, DataAttributes.AADHAR_PC_ATTR);

                    if (verifyData()) {
                        Toast.makeText(this, scanData, Toast.LENGTH_SHORT).show();
                        if (scanData.contains(name_edt.getText().toString())) {
                            displayScannedData();

                            //Retro
                            final Api api = Api_client.CitizenRegister().create(Api.class);
                            CitizenRegisterRequest citizenRegisterRequest = new CitizenRegisterRequest();
                            CitizenRegisterRequest.UserBean userBean = new CitizenRegisterRequest.UserBean();
                            userBean.setUsername(name_edt.getText().toString());
                            userBean.setFirst_name(name_edt.getText().toString());
                            userBean.setEmail(email_edt.getText().toString());
                            userBean.setPassword(password_edt.getText().toString());
                            citizenRegisterRequest.setUser(userBean);

                            citizenRegisterRequest.setUid(uid);
                            citizenRegisterRequest.setPhone(phone_edt.getText().toString());
                            citizenRegisterRequest.setGender(gender);
                            citizenRegisterRequest.setYob(yearOfBirth);
                            citizenRegisterRequest.setCo(careOf);
                            citizenRegisterRequest.setHouse(house);
                            citizenRegisterRequest.setStreet(street);
                            citizenRegisterRequest.setVtc(villageTehsil);
                            citizenRegisterRequest.setPo(postOffice);
                            citizenRegisterRequest.setDist(district);
                            citizenRegisterRequest.setSubdist(subdistrict);
                            citizenRegisterRequest.setState(state);
                            citizenRegisterRequest.setPc(postCode);

                            Gson gson = new Gson();
                            Json = gson.toJson(citizenRegisterRequest).trim();
                            try {
                                requestBody = RequestBody.create(MediaType.parse("application/json"), Json.getBytes("UTF-8"));
                            } catch (Exception e) {
                                e.printStackTrace();
                                Toast.makeText(CitizenSignUp.this, "" + e, Toast.LENGTH_SHORT).show();
                            }
                            Call<CitizenRegisterModel> CitizenRegisterCall = api.CITIZEN_REGISTER_MODEL_CALL(requestBody);
                            CitizenRegisterCall.enqueue(new Callback<CitizenRegisterModel>() {
                                @Override
                                public void onResponse(Call<CitizenRegisterModel> call, Response<CitizenRegisterModel> response) {

                                    CitizenRegisterModel citizenRegisterModel = response.body();


                                    try {
                                        String status = citizenRegisterModel.getStatus();
                                    }catch (Exception e)
                                    {
                                        Toast.makeText(CitizenSignUp.this, "status fail"+e, Toast.LENGTH_SHORT).show();
                                    }
//                                    Toast.makeText(CitizenSignUp.this, ""+status, Toast.LENGTH_SHORT).show();
//                                    if (status.equalsIgnoreCase("success")) {
//                                        //Intent i = new Intent(CitizenSignUp.this, CitizenHome.class);
//                                       // startActivity(i);
//                                        Toast.makeText(CitizenSignUp.this, "Registered Successfully", Toast.LENGTH_SHORT).show();
//                                    }else
//                                    {
//                                        Toast.makeText(CitizenSignUp.this, ""+citizenRegisterModel.getStatus(), Toast.LENGTH_SHORT).show();
//                                    }

                                }

                                @Override
                                public void onFailure(Call<CitizenRegisterModel> call, Throwable t) {
                                    Toast.makeText(CitizenSignUp.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                                }
                            });


                        } else {
                            Toast.makeText(this, "Invalid Aadhar card", Toast.LENGTH_SHORT).show();
                        }
                    }

                } else if (eventType == XmlPullParser.END_TAG) {
                    Log.d("Rajdeol", "End tag " + parser.getName());

                } else if (eventType == XmlPullParser.TEXT) {
                    Log.d("Rajdeol", "Text " + parser.getText());

                }
                // update eventType
                eventType = parser.next();
            }

            // display the data on screen
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }// EO function

    /**
     * show scanned information
     */
    public void displayScannedData() {
        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("pref", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("key1", uid);
        editor.putString("key2", name);
        editor.putString("key3", gender);
        editor.putString("key4", yearOfBirth);
        editor.putString("key5", careOf);
        editor.putString("key6", house);
        editor.putString("key7", villageTehsil);
        editor.putString("key8", postOffice);
        editor.putString("key9", district);
        editor.putString("key10", state);
        editor.putString("key11", postCode);
        editor.apply();


    }

    public boolean verifyData() {
        if (name_edt.getText().toString().equals("")) {
            name_edt.setError("Enter name");
        } else if (email_edt.getText().toString().equals("")) {
            email_edt.setError("Enter email");
        } else if (password_edt.getText().toString().equals("")) {
            password_edt.setError("Enter password");
        } else if (confirmpswd_edt.getText().toString().equals("")) {
            confirmpswd_edt.setError("Confirm your password");
        } else if (!password_edt.getText().toString().equals(confirmpswd_edt.getText().toString())) {
            confirmpswd_edt.setError("Password does not match");

        } else {
            Toast.makeText(this, "All fields are filled", Toast.LENGTH_SHORT).show();
            return true;
        }
        return false;
    }

}

