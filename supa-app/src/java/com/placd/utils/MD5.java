package com.placd.utils;

import java.security.*;

/**
 * User: Vusa Dube <vusadube at gmail.com>
 * Date: 02 Mar 2010, 7:51:42 PM
 * @author <a href="mailto:vusadube@gmail.com">Vusa Dube</a>
 */
public class MD5 {

    private MessageDigest md = null;
    static private MD5 md5 = null;
    private static final char[] hexChars = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    private MD5() throws NoSuchAlgorithmException {
        md = MessageDigest.getInstance("MD5");
    }

    public static MD5 getInstance() throws NoSuchAlgorithmException {
        if (md5 == null) {
            md5 = new MD5();
        }
        return (md5);
    }

    public String hashData(byte[] dataToHash) {
        return hexStringFromBytes((calculateHash(dataToHash)));
    }

    public String hashData(String stringToHash) {
        return hashData(stringToHash.getBytes());
    }

    private byte[] calculateHash(byte[] dataToHash) {
        md.update(dataToHash, 0, dataToHash.length);
        return (md.digest());
    }

    public String hexStringFromBytes(byte[] b) {
        String hex = "";
        int msb;

        int lsb = 0;
        int i;

        // MSB maps to idx 0
        for (i = 0; i < b.length; i++) {
            msb = ((int) b[i] & 0x000000FF) / 16;
            lsb = ((int) b[i] & 0x000000FF) % 16;
            hex = hex + hexChars[msb] + hexChars[lsb];
        }
        return (hex);
    }
}