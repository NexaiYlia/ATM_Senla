package com.nexai.validator;

public class CardValidator {
    public String FORMAT_OF_CARD_NUMBER = "([0-9]{4}\\-){3}[0-9]{4}";

    public boolean validate(String number) {
        if (number.matches(FORMAT_OF_CARD_NUMBER)) {
            return true;
        } else {
            System.out.println("Card number entered incorrectly:" + number);
            return false;
        }
    }
}
