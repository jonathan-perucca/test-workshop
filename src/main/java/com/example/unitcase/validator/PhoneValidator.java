package com.example.unitcase.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneValidator {
    Pattern phonePattern;

    public PhoneValidator() {
        phonePattern = Pattern.compile("(0|\\+33|0033)[1-9][0-9]{8}");
    }

    public boolean validate(String number) {
        final Matcher matcher = phonePattern.matcher(number);
        return matcher.matches();
    }
}
