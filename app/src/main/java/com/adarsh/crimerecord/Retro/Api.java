package com.adarsh.crimerecord.Retro;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface Api{
    @POST("accounts/register/")
    Call<CitizenRegisterModel>CITIZEN_REGISTER_MODEL_CALL(@Body RequestBody requestBody);

}
