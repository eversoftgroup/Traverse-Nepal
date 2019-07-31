package com.eversoft.api;

import com.eversoft.entities.User;
import com.eversoft.entities.UserLogin;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiUserService {

    @Headers({"Accept:application/json", "Content-Type:application/json;"})
    @POST("auth/login")
    Call<UserLogin> userLogin(
            @Query("username") String username,
            @Query("password") String password);


   // @Headers({"Accept:application/json", "Content-Type:application/json;"})
    @GET("user/get")
    Call<User> getUser(
            @Query("id") int id,
            @Query("key") String key);
}
