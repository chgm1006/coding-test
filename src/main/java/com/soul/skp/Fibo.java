package com.soul.skp;

/**
 * Created by soul on 2015-04-09.
 */
public class Fibo {
    static int i = 0;

    public static int fibo(int n) {
        i++;
        if (n == 0 || n == 1) {
            return n;
        } else {
            return fibo(n - 1) + fibo(n - 2);
        }
    }

    public static void main(String[] args) {
        // 1부터 시작하는 10개의 수열 구하기..
        /*for (int i = 1; i <= 10; i++) {
            System.out.print(fibo(i) + " ");
        }
        System.out.println();
        System.out.println(i);*/

        int total = 20;
        int[] arr = new int[total];
        arr[0] = 1;
        arr[1] = 1;

        for (int i = 0; i < total - 2; i++) {
            arr[i + 2] = arr[i] + arr[i + 1];
        }

        for (int j = 0; j < arr.length; j++) {
            System.out.print(arr[j] + " ");
        }
    }
}
