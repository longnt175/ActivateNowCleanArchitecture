package com.activatenow.data.net;

import com.activatenow.data.net.object.request.LoginUserRequest;
import com.activatenow.data.net.object.response.UserResponse;
import com.activatenow.data.net.wrapper.UserWrapper;
import com.activatenow.domain.entity.MessageEntity;
import com.activatenow.domain.entity.UserEntity;
import com.activatenow.domain.entity.VersionEntity;

import io.reactivex.Observable;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface RestApi {

    String ACCEPT = "application/json";
    String URL_BASE = "https://demo.cqcommand.com/";

    @POST("/users")
    Observable<Response<UserEntity>> createUser(@Body UserWrapper userWrapper);

    @DELETE("/users/0")
    Observable<Response<Void>> deleteUser(@Header("Authorization") String token);

    @POST("/users/reset_password")
    Observable<Response<MessageEntity>> resetPassword(@Header("Authorization") String token,
                                                      @Body UserWrapper userWrapper);

    @POST("api/login/CheckUser")
    Observable<Response<UserResponse>> doLogin(@Body LoginUserRequest loginUserRequest);

    @DELETE("/users/logout")
    Observable<Response<Void>> doLogout(@Header("Authorization") String token);

    @GET("/versions/state")
    Observable<Response<VersionEntity>> checkVersionExpiration(
                                                            @Header("Authorization") String token);
//    @POST("userregister")
//    Observable<Response<UserResponse>> createUser(@Body UserLoginModel userWrapper);
//
//    @POST("/users/reset_password")
//    Observable<Response<MessageEntity>> resetPassword(@Body UserLoginModel userWrapper);
//
//    @POST("userlogin")
//    Observable<Response<UserResponse>> doLogin(@Body UserLoginModel userLoginModel);
}
