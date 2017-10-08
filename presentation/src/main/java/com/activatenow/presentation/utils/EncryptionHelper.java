package com.activatenow.presentation.utils;

import com.activatenow.presentation.AppConfig;

/**
 * Created by mobiledev on 6/10/2017.
 */

public class EncryptionHelper {
    public static String encryptString(String textToEncrypt) {
        try {
            CryptLib cryptLib = new CryptLib();
            return cryptLib.encrypt(textToEncrypt, CryptLib.SHA256(AppConfig.ENCRYPTION_KEY, 31), AppConfig.INIT_VECTOR);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
