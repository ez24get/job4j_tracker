package ru.job4j.early;

import java.util.Arrays;

public class PasswordValidator {
    private static final String[] FORBIDDEN = {"qwerty", "12345", "password", "admin", "user"};

    public static String validate(String password) {
        if (password == null) {
            throw new IllegalArgumentException(
                    "Password can't be null"
            );
        }
        if (password.length() < 8 || password.length() > 32) {
            throw new IllegalArgumentException(
                    "Password should be length [8, 32]"
            );
        }

        boolean hasUpCase = false;
        boolean hasLowCase = false;
        boolean hasDigit = false;
        boolean hasSpecial = false;
        for (char symbol : password.toCharArray()) {
            if (Character.isUpperCase(symbol)) {
                hasUpCase = true;
            }
            if (Character.isLowerCase(symbol)) {
                hasLowCase = true;
            }
            if (Character.isDigit(symbol)) {
                hasDigit = true;
            }
            if (Character.isLetterOrDigit(symbol)) {
                hasSpecial = true;
            }
        }
        if (!hasUpCase) {
            throw new IllegalArgumentException(
                    "Password should contain at least one uppercase letter"
            );
        }
        if (!hasLowCase) {
            throw new IllegalArgumentException(
                    "Password should contain at least one lowercase letter"
            );
        }
        if (!hasDigit) {
            throw new IllegalArgumentException(
                    "Password should contain at least one figure"
            );
        }
        if (!hasSpecial) {
            throw new IllegalArgumentException(
                    "Password should contain at least one special symbol"
            );
        }

        char[] passwordF = password.toCharArray();
        for (int p = 0; p < passwordF.length; p++) {
            if ((passwordF[p] == FORBIDDEN[0].charAt(0)
                    || Character.isUpperCase(passwordF[p])
                    == Character.isUpperCase(FORBIDDEN[0].charAt(0))
                    || Character.isLowerCase(passwordF[p])
                    == Character.isLowerCase(FORBIDDEN[0].charAt(0)))) {
                char[] check = Arrays.copyOfRange(passwordF, p, passwordF.length);
                for (int i = 0; i < FORBIDDEN.length; i++) {
                    char[] forbidden = FORBIDDEN[i].toCharArray();
                    for (int j = 0; j < forbidden.length; j++) {
                        if (check[j] == forbidden[j]
                                || Character.isUpperCase(passwordF[p])
                                == Character.isUpperCase(FORBIDDEN[i].charAt(j))
                                || Character.isUpperCase(passwordF[p])
                                == Character.isUpperCase(FORBIDDEN[i].charAt(j))) {
                            throw new IllegalArgumentException(
                                    "Password shouldn't contain substrings: qwerty, 12345, password, admin, user"
                            );
                        }
                    }
                }
            }
        }
        return password;
    }
}









