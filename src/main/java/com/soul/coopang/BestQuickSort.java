package com.soul.coopang;

/**
 * 평균적으로 O(n log n)번의 비교를 수행하며, 최악의 경우에 O(n^2)의 비교를 수행
 */
public class BestQuickSort {
    public static void sort(int[] inputArr, int left, int right) {
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
            sort(inputArr, left, i - 1);
            sort(inputArr, j + 1, right);
        }
    }

    public static void main(String a[]) {
        int[] input = {2, 2, 1, 2, 1, 2, 1, 2};
        BestQuickSort.sort(input, 0, input.length - 1);

        for (int i : input) {
            System.out.print(i);
            System.out.print(" ");
        }
    }
}