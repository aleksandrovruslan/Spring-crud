package com.users.task.springrestfullcrud.Learn;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Learn {
    private static String str = "fAod";
    private static String pattern = "([A-Z{1,}])([0-9{1,}])";

    public static void main(String[] args) {
        Pattern p = Pattern.compile(pattern);
        Matcher matcher = p.matcher(str);
        System.out.println(matcher.find());
    }
}
