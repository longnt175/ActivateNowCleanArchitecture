package com.activatenow.data.net.object.response.core;

/**
 * Created by mobiledev on 6/10/2017.
 */

public class User {
    String UserId;
    String RoleId;
    String Alias;
    String WorkAreaId;
    String WorkArea;
    String StaffName;
    String EmailId;
    String ClientId;
    int PinAvailable;
    String ClientSiteID;

    public String getUserId() {
        return UserId;
    }

    public String getRoleId() {
        return RoleId;
    }

    public String getAlias() {
        return Alias;
    }

    public String getWorkAreaId() {
        return WorkAreaId;
    }

    public String getWorkArea() {
        return WorkArea;
    }

    public String getStaffName() {
        return StaffName;
    }

    public String getEmailId() {
        return EmailId;
    }

    public String getClientId() {
        return ClientId;
    }

    public int getPinAvailable() {
        return PinAvailable;
    }

    public String getClientSiteID() {
        return ClientSiteID;
    }
}
