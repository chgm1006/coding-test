package com.soul.skp;

/**
 * 1~입력값까지 곱해서 끝자리부터 0이 몇 개인지 산출하라.
 */
public class ExtractZeroCnt {
    public static void main(String[] args) {
        long mul = 1;
        for (int i = 1; i <= 10; i++) {
            mul *= i;
        }

        int zeroCnt = 0;
        String mulStr = String.valueOf(mul);
        for (int i = mulStr.length() - 1; i >= 0; i--) {
            if (mulStr.charAt(i) == '0') {
                zeroCnt++;
            }
        }
        System.out.println(mul + " : " + zeroCnt);
    }
}
