package fr.m2i.saladetomatesoignonsback.utils;

import org.apache.commons.codec.digest.DigestUtils;

public class HashUtil {

    public static String toMd5(String string) {
        return DigestUtils.md5Hex(string);
    }
}
