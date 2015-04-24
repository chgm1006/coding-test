package com.soul.skp;

/**
 * 주어진 소수점 이하 자리에 대한 반올림(round) 함수 작성
 */
public class FloatRound {
    public static double round(double value, int roundPoint) {
        String[] splitValue = String.valueOf(value).split("\\.");

        if (splitValue.length == 2 && splitValue[1].length() > roundPoint) {
            int number = Character.getNumericValue(splitValue[1].charAt(roundPoint));
            long rest = Long.parseLong(splitValue[1].substring(0, roundPoint));
            if (number > 4) {
                rest++;
            }

            return Double.parseDouble(splitValue[0] + "." + rest);
        }

        return value;
    }

    public static void main(String args[]) {
        int point = 7;
        double value = 20.25980943;
        String str = String.format("%." + point + "f", value);
        System.out.println(str);

        double result = round(value, point);
        System.out.println(result);
    }
}