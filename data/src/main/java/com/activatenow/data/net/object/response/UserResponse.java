package com.activatenow.data.net.object.response;

import com.activatenow.data.net.object.response.core.User;

/**
 * Created by mobiledev on 6/10/2017.
 */

public class UserResponse {
    User data;
    int StatusCode;
    String StatusMessage;

    public User getData() {
        return data;
    }

    public int getStatusCode() {
        return StatusCode;
    }

    public String getStatusMessage() {
        return StatusMessage;
    }
}
