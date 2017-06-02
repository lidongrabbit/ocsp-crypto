package com.aisainfo.ocdp.stream.crypto;

/**
 * Created by lidong on 2017/5/2.
 */
import org.apache.commons.codec.binary.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class AesCipher {
    private static final String ALGORITHM = "AES/CBC/PKCS5Padding";
    private static byte[] ivValue = null;
    private static final IvParameterSpec IV_SPEC;

    public AesCipher() {
    }

    public static String encrypt(String message) {
        return encrypt(message, "b6fa92796c6431c5");
    }

    private static String fillChar(String key) {
        int minLen = 16;
        if(key != null && key.length() >= 8) {
            int leng = key.length();
            if(leng >= minLen) {
                return key;
            } else {
                for(int i = leng; i < minLen; ++i) {
                    key = key + "m";
                }

                return key;
            }
        } else {
            return "b6fa92796c6431c5";
        }
    }

    public static String encrypt(String message, String key) {
        try {
            return encrypt(message, "AES/CBC/PKCS5Padding", new SecretKeySpec(fillChar(key).getBytes("UTF-8"), "AES"), IV_SPEC);
        } catch (UnsupportedEncodingException var3) {
            var3.printStackTrace();
            return message;
        }
    }

    public static String encrypt(String message, String algorithm, SecretKeySpec keySpec, IvParameterSpec ivSpec) {
        try {
            Cipher e = Cipher.getInstance(algorithm);
            if(ivSpec != null) {
                e.init(1, keySpec, ivSpec);
            } else {
                e.init(1, keySpec);
            }

            byte[] encVal = e.doFinal(message.getBytes("UTF-8"));
            String encryptedValue = Base64.encodeBase64String(encVal);
            return encryptedValue;
        } catch (NoSuchAlgorithmException var7) {
            var7.printStackTrace();
        } catch (NoSuchPaddingException var8) {
            var8.printStackTrace();
        } catch (UnsupportedEncodingException var9) {
            var9.printStackTrace();
        } catch (InvalidKeyException var10) {
            var10.printStackTrace();
        } catch (InvalidAlgorithmParameterException var11) {
            var11.printStackTrace();
        } catch (IllegalBlockSizeException var12) {
            var12.printStackTrace();
        } catch (BadPaddingException var13) {
            var13.printStackTrace();
        }

        return message;
    }

    public static String decrypt(String encryptedData) {
        return decrypt(encryptedData, "b6fa92796c6431c5");
    }

    public static String decrypt(String encryptedData, String key) {
        try {
            return decrypt(encryptedData, "AES/CBC/PKCS5Padding", new SecretKeySpec(fillChar(key).getBytes("UTF-8"), "AES"), IV_SPEC);
        } catch (UnsupportedEncodingException var3) {
            var3.printStackTrace();
            return encryptedData;
        }
    }

    public static String decrypt(String encryptedData, String algorithm, SecretKeySpec keySpec, IvParameterSpec ivSpec) {
        try {
            Cipher e = Cipher.getInstance(algorithm);
            if(ivSpec != null) {
                e.init(2, keySpec, ivSpec);
            } else {
                e.init(2, keySpec);
            }

            byte[] decordedValue = Base64.decodeBase64(encryptedData);
            byte[] decValue = e.doFinal(decordedValue);
            String decryptedValue = new String(decValue);
            return decryptedValue;
        } catch (NoSuchAlgorithmException var8) {
            var8.printStackTrace();
        } catch (NoSuchPaddingException var9) {
            var9.printStackTrace();
        } catch (InvalidKeyException var10) {
            var10.printStackTrace();
        } catch (InvalidAlgorithmParameterException var11) {
            var11.printStackTrace();
        } catch (IllegalBlockSizeException var12) {
            var12.printStackTrace();
        } catch (BadPaddingException var13) {
            var13.printStackTrace();
        }

        return encryptedData;
    }

    static {
        try {
            ivValue = "7b51fd7053196308".getBytes("UTF-8");
        } catch (UnsupportedEncodingException var1) {
            var1.printStackTrace();
        }

        IV_SPEC = new IvParameterSpec(ivValue);
    }
}
