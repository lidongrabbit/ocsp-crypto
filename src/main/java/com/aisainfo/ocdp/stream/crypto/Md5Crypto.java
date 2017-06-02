package com.aisainfo.ocdp.stream.crypto;

/**
 * Created by lidong on 2017/5/2.
 */
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Md5Crypto {
    private static char[] hexDigits = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public Md5Crypto() {
    }

    public static String encrypt(String message) {
        try {
            MessageDigest e = MessageDigest.getInstance("MD5");
            byte[] md = e.digest(message.getBytes());
            int j = md.length;
            char[] str = new char[j * 2];
            int k = 0;

            for(int i = 0; i < j; ++i) {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 15];
                str[k++] = hexDigits[byte0 & 15];
            }

            return String.valueOf(str);
        } catch (NoSuchAlgorithmException var8) {
            var8.printStackTrace();
            return message;
        }
    }
}
