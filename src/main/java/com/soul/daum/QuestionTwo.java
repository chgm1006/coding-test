package com.soul.daum;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Created by soul on 2015-04-09.
 */
public class QuestionTwo {
    private String p = "XYZ";
    private String q = "XY";
    private String r = "6PP";
    private String[] pqr = new String[]{p, q, r};
    private int matchedCnt = 0;
    Set<Character> chars = new LinkedHashSet<Character>();

    /**
     * 주어진 식에 대입하여 결과 값이 맞으면 출력한다.
     *
     * @param predictionNumber
     */
    private boolean displayMatchedNumber(int predictionNumber) {
        String predictionNumberStr = String.valueOf(predictionNumber);
        String[] tempPQR = new String[pqr.length];
        Character c = null;

        for (int i = 0; i < tempPQR.length; i++) {
            tempPQR[i] = pqr[i];

            Iterator<Character> iter = chars.iterator();
            int tempCnt = 0;
            while (iter.hasNext()) {
                c = new Character(predictionNumberStr.charAt(tempCnt));
                tempPQR[i] = tempPQR[i].replaceAll(iter.next().toString(), c.toString());
                tempCnt++;
            }

            if ("0".equals(new Character(tempPQR[i].charAt(0)).toString())) {
                return false;
            }
        }

        int pVal = Integer.parseInt(tempPQR[0]);
        int qVal = Integer.parseInt(tempPQR[1]);
        int rVal = Integer.parseInt(tempPQR[2]);

        if ((pVal + qVal) == rVal) {
            matchedCnt++;
            System.out.println(pVal + "+" + qVal + " = " + rVal);
        }
        return true;
    }

    /**
     * 위의 예에서 변수는 X, Y, P, Z 총 4개이고 각 변수에는 다른 값이 대입되어야 한다.
     * 매개 변수의 값의 각 자리의 값이 다른지를 검사한다.
     *
     * @param predictionNumber 대입할 값
     * @return
     */
    private boolean checkDifferenceDecimalPoint(int predictionNumber) {
        String tempStr = String.valueOf(predictionNumber);
        int length = tempStr.length();

        for (int i = 0; i < length - 1; i++) {
            for (int j = i + 1; j < length; j++) {
                if (tempStr.charAt(i) == tempStr.charAt(j)) {
                    return false;
                }
            }
        }

        return true;
    }

    /**
     * 각 알파벳 마다 값을 대입하여 나올수 있는 경우의 수를 출력한다.
     */
    public void substituteChar() {
        int maxLength = p.length() > q.length() ? p.length() : q.length();

        //XYZ + XY = 6PP 에서 변수가 X, Y, P, Z 4개 이므로 각 변수에 대입하려면 총4개의 값이 필요하다.
        //위의 경우 9999 ~ 1000 까지 값을 대입해 본다.
        int maxVal = (int) Math.pow(10, chars.size()) - 1;
        int minVal = (int) Math.pow(10, chars.size() - 1);

        while (maxVal > minVal) {
            //각 자리의 값이 다른 경우에만 대입한다.
            //각 알파벳은 값이 다르게 대입되어야 하기 때문. 예)9876, 9875
            if (checkDifferenceDecimalPoint(maxVal)) {
                displayMatchedNumber(maxVal);
            }
            maxVal--;
        }
    }

    /**
     * p + q = r의 식을 만족하는 경우의 수를 계산한다.
     */
    public void calculateWayOfOccasion() {
        String sumStr = p + q + r;

        for (int i = 0; i < sumStr.length(); i++) {
            char tempChar = sumStr.charAt(i);
            if (!('0' <= tempChar && tempChar <= '9'))
                chars.add(tempChar);
        }

        substituteChar();
        System.out.println("일치하는 총 수는 : " + matchedCnt);
    }

    public static void main(String[] args) {
        QuestionTwo question = new QuestionTwo();
        question.calculateWayOfOccasion();
    }
}
