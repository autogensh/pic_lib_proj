package com.piclib.web.util;

import java.util.Random;

public class Generator {
    public static final String number = "0123456789";
    public static final String lowerAlpha = "qwertyuiopasdfghjklzxcvbnm";
    public static final String upperAlpha = "QWERTYUIOPASDFGHJKLZXCVBNM";
    public static final String character = number + lowerAlpha + upperAlpha;
    public static final Random random = new Random();
    public static StringBuilder sb = new StringBuilder();

    public static String generateString(int length) {
        sb.setLength(0);
        for (int i = 0; i < length; i++) {
            sb.append(character.charAt(random.nextInt(62)));
        }
        return sb.toString();
    }
}
