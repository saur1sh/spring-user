package com.example.h2demo.validation;

import com.example.h2demo.entity.User;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validate {

    public static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    public static boolean validateEmail(String emailStr) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
        return matcher.matches();
    }

    public static boolean validate(User user) {
        return user.getFirstName() != null && !user.getFirstName().trim().isEmpty() &&
                user.getLastName() != null && !user.getLastName().trim().isEmpty() &&
                user.getEmail() != null && validateEmail(user.getEmail());
    }
}
