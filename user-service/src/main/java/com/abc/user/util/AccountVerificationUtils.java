package com.abc.user.util;

import java.util.concurrent.ThreadLocalRandom;

public class AccountVerificationUtils {

    public static String generateActivationCode(){
        int rand = ThreadLocalRandom.current().nextInt(100000,999999);
        return String.valueOf(rand);
    }
}
