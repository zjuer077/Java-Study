package com.ljt.base;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexMatches2 {
    private static final String REGEX = "a*b";
    private static final String INPUT = "aabfooaabfooabfoobkkk";
    private static final String REPLACE = "-";

    public static void main(String[] args) {
        Pattern p = Pattern.compile(REGEX);
        // get a matcher object
        Matcher m = p.matcher(INPUT);
        StringBuffer sb = new StringBuffer();
        while (m.find()) {

            // INPUT = Pattern.compile(REGEX).matcher(INPUT).replaceAll(REPLACE);
            m.appendReplacement(sb, REPLACE);

        }
        m.appendTail(sb);
        System.out.println(sb);
        // 这句话的用法是调用系统类 System 中的标准输出对象 out 中的方法 println()。
    }
}