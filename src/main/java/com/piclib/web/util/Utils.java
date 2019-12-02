package com.piclib.web.util;

public class Utils {
    public static String humanSize(long size) {
        double kb = 1024;
        double mb = kb * 1024;
        double gb = mb * 1024;
        if (size > gb) {
            return String.format("%.3fGB", size / gb);
        }
        if (size > mb) {
            return String.format("%.3fMB", size / mb);
        }
        if (size > kb) {
            return String.format("%.3fKB", size / kb);
        }
        return String.format("%dB", size);
    }
}
