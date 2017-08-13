package com.rexehate.danbitests;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

class HashCalc {
    String cryptMyString(String cryptThisString) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.reset();
        md.update(cryptThisString.getBytes());
        byte[] digest = md.digest();
        BigInteger bigInt = new BigInteger(1, digest);
        String md5 = bigInt.toString(16);
        System.out.println(md5);
        return md5;
    }
}
