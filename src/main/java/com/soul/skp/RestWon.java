package com.soul.skp;

/**
 * 총 잔액과 화폐 액수 배열이 주어질 때 (2960, [5000,1000,500,100]) 거스름 돈 구성하기(거스름돈 구성이 어려우면 나머지로 표시)
 * - 예) 1000원 2개, 500원 1개, 100원 4개, 나머지 60원
 */
public class RestWon {
    public static void main(String args[]) {
        int total = 2960;
        int[] money = {5000, 1000, 500, 100};

        for (int i = 0; i < money.length; i++) {
            int share = total / money[i];
            total %= money[i];

            if (share > 0) {
                System.out.print(String.format("%sWon %sCount, ", money[i], share));
            }

            if (i == money.length - 1) {
                System.out.print(String.format("Rest %sWon", total));
            }
        }
    }
}

