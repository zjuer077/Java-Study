package com.ljt.base;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexMatches2 {
    private static String REGEX = "a*b";
    private static String INPUT = "aabfooaabfooabfoobkkk";
    private static String REPLACE = "-";

    public static void main(String[] args) {
        // Pattern p = Pattern.compile(REGEX);
        // get a matcher object
        //Matcher m = p.matcher(INPUT);
        Pattern p = Pattern.compile(REGEX);
        Matcher m = p.matcher(INPUT);
        StringBuffer sb = new StringBuffer();
        while (m.find()) {

            // INPUT = Pattern.compile(REGEX).matcher(INPUT).replaceAll(REPLACE);
            m.appendReplacement(sb, REPLACE);

        }
        m.appendTail(sb);
        System.out.println(sb.toString());
    }
}