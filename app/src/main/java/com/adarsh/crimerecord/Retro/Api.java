package com.adarsh.crimerecord.Retro;

import com.adarsh.crimerecord.Citizen.IPCSections;

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

    @GET("authority/authlogin/")
    Call<AuthorityLoginModel>AUTHORITY_LOGIN_MODEL_CALL(@Query("email")String email,@Query("password")String password);

    @POST("authority/policereg/")
    Call<AddPoliceResponseModel>ADD_POLICE_RESPONSE_MODEL_CALL(@Body RequestBody requestBody);

    @GET("/authority/police/?district=Chengalpattu")
    Call<PoliceStationByDistrictModel>POLICE_STATION_BY_DISTRICT_MODEL_CALL(@Query("district")String district);

    @GET("authority/policelogin/?")
    Call<PoliceLoginModel>POLICE_LOGIN_MODEL_CALL(@Query("code")String code,@Query("password")String password);

    @GET("complaint/policeview/")
    Call<ViewComplaintsByPoliceStationModel>VIEW_COMPLAINTS_BY_POLICE_STATION_MODEL_CALL(@Query("police_station")String policestation);

    @GET("complaint/Compalintverify/?complaint_id=1")
    Call<ComplaintVerificationModel>COMPLAINT_VERIFICATION_MODEL_CALL(@Query("complaint_id")int complaintid);

    @GET("complaint/IPCSections/")
    Call<IpcModel>IPC_MODEL_CALL();
}
