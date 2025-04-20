package com.universalqa.utils;

import java.util.Random;
import java.util.UUID;

/**
 * Utility class for generating dynamic test data.
 */
public class TestDataUtil {

    public static String randomAlphaNumeric(int length) {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789abcdefghijklmnopqrstuvwxyz";
        StringBuilder sb = new StringBuilder();
        Random rand = new Random();
        for (int i = 0; i < length; i++) {
            sb.append(chars.charAt(rand.nextInt(chars.length())));
        }
        return sb.toString();
    }

    public static String randomEmail() {
        return "user_" + randomAlphaNumeric(6).toLowerCase() + "@test.com";
    }

    public static String randomPhoneNumber() {
        return "+9715" + (1000000 + new Random().nextInt(9000000));
    }

    public static String randomUUID() {
        return UUID.randomUUID().toString();
    }

    public static int randomInt(int min, int max) {
        return new Random().nextInt(max - min + 1) + min;
    }
}