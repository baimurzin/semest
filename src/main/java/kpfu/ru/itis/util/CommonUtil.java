package kpfu.ru.itis.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by vbaimurzin on 22.11.2015.
 */
public class CommonUtil {

    public static String decodeString(String strToDecode) {
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        md.update(strToDecode.getBytes());
        byte[] bytes = md.digest();
        StringBuilder sb = new StringBuilder();
        for (byte aByte : bytes) {
            sb.append(Integer.toString((aByte & 0xff) + 0x100, 16).substring(1));
        }
        return sb.toString();
    }

    public static boolean checkString(String notDecodedString, String decodedStr) {
        return decodedStr.equals(decodeString(notDecodedString));
    }
}
