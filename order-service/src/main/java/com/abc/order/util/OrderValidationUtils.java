package com.abc.order.util;

public class OrderValidationUtils {

    public static boolean isFileAcceptable(long fileSize){
        return fileSize*0.0009765625 >= 100 ? true:false;
    }
}
