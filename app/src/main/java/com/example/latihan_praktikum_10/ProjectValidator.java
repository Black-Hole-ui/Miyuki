package com.example.latihan_praktikum_10;

public class ProjectValidator {
    public static boolean isValidName(String name) {
        return name != null && name.length() >= 3;
    }
}
