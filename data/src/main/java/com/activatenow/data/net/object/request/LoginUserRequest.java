package com.activatenow.data.net.object.request;

/**
 * Created by mobiledev on 6/10/2017.
 */

public class LoginUserRequest {
    String Email;
    String Password;

    public LoginUserRequest(String email, String password) {
        Email = email;
        Password = password;
    }
}
