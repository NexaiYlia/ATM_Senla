package com.nexai.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CardValidator {
    public static final String FORMAT_OF_CARD_NUMBER = "(\\d{4}\\-){3}\\d{4}";
    public static final String FORMAT_OF_PASSWORD = "\\d{4}";

    public static boolean validateCardNumber(String number) {
        if (number.matches(FORMAT_OF_CARD_NUMBER) && number.length() == 19) {
            return true;
        } else {
            System.out.println("Card number entered incorrectly:" + number);
            return false;
        }
    }

    public static boolean validPassword(String password) {
        Pattern pattern = Pattern.compile(FORMAT_OF_PASSWORD);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }
}
