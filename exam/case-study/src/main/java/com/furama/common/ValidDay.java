package com.furama.common;

import java.time.LocalDate;
import java.time.Period;

public class ValidDay {
    public static boolean checkAge18(String value) {
        try {
            LocalDate.parse(value);
        } catch (Exception exception) {
            return true;
        }
        int checkAge = Period.between(LocalDate.parse(value), LocalDate.now()).getYears();
        return checkAge >=18;
    }
    public static boolean isValidDay(String value) {
        try {
            LocalDate.parse(value);
        } catch (Exception exception) {
            return false;
        }
        return true;
    }
}
