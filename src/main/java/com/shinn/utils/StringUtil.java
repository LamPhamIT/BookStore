package com.shinn.utils;

import java.io.BufferedReader;
import java.io.IOException;

public class StringUtil {
    public static String convertJsonToJsonString(BufferedReader reader){
        StringBuilder stringBuilder = new StringBuilder();
        try {
            String line;
            while((line = reader.readLine()) != null) {
                stringBuilder.append(line);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return stringBuilder.toString();
    }
}
