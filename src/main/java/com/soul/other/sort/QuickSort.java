package com.soul.other.sort;

/**
 * Created by soul on 2015-04-15.
 */
public class QuickSort {
    public static void quickSort(int[] inputArr, int left, int right) {
        if (left < right) {
            int pivot = inputArr[(left + right) / 2];
            int i = left - 1;
            int j = right + 1;
            while (true) {
                while (inputArr[++i] < pivot) ;
                while (inputArr[--j] > pivot) ;
                if (i >= j) break;

                int temp = inputArr[i];
                inputArr[i] = inputArr[j];
                inputArr[j] = temp;
            }

            quickSort(inputArr, left, i - 1);
            quickSort(inputArr, j + 1, right);
        }
    }

    public static void main(String[] args) {
        int[] input = {20, 1, 50, 200, 30, 2};
        quickSort(input, 0, input.length - 1);

        for (int i : input) {
            System.out.println(i);
        }
    }
}
