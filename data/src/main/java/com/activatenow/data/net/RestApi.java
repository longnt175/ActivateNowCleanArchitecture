package com.activatenow.data.net;

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

    String URL_BASE = "http://192.168.0.10:3000";
    int API_VERSION = 1;
    String VERSION_HEADER = "application/vnd.railsapibase.v" + API_VERSION;

    @POST("/users")
    Observable<Response<UserEntity>> createUser(@Body UserWrapper userWrapper);

    @DELETE("/users/0")
    Observable<Response<Void>> deleteUser(@Header("Authorization") String token);

    @POST("/users/reset_password")
    Observable<Response<MessageEntity>> resetPassword(@Header("Authorization") String token,
                                                      @Body UserWrapper userWrapper);

    @POST("/users/login")
    Observable<Response<UserEntity>> doLogin(@Body UserWrapper userWrapper);

    @DELETE("/users/logout")
    Observable<Response<Void>> doLogout(@Header("Authorization") String token);

    @GET("/versions/state")
    Observable<Response<VersionEntity>> checkVersionExpiration(
                                                            @Header("Authorization") String token);
}
