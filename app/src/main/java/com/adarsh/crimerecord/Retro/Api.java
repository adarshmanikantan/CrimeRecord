package com.adarsh.crimerecord.Retro;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface Api{
    @POST("accounts/register/")
    Call<CitizenRegisterModel>CITIZEN_REGISTER_MODEL_CALL(@Body RequestBody requestBody);

    @GET("accounts/login/")
    Call<CitizenLoginModel>CITIZEN_LOGIN_MODEL_CALL(@Query("email")String email,@Query("password")String password);

    @POST("complaint/postcomplaint/")
    Call<PostComplaintResponseModel>POST_COMPLAINT_RESPONSE_MODEL_CALL(@Body RequestBody requestBody);

    @GET("complaint/complaintDetails/")
    Call<ComplaintStatusModel>COMPLAINT_STATUS_MODEL_CALL(@Query("owner_id")int user_id);

    @POST("complaint/postcomplaint/")
    Call<ComplaintsListModel>POST_COMPLAINT_RESPONSE_MODEL_CALL();

}
