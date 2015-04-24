package com.soul.other.sort;

/**
 * Created by soul on 2015-04-15.
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] input = {20, 1, 50, 200, 30, 2};

        boolean switched;
        do {
            switched = false;
            for (int i = 0; i < input.length - 1; i++) {
                if (input[i + 1] < input[i]) {
                    int temp = input[i + 1];
                    input[i + 1] = input[i];
                    input[i] = temp;
                    switched = true;
                }
            }
        } while (switched);

        for (int i : input) {
            System.out.println(i);
        }
    }
}
