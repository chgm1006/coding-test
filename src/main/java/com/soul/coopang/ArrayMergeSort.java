package com.soul.coopang;

/**
 * 정렬된 2개의 배열의 정렬을 한다.
 */
public class ArrayMergeSort {
    public static int[] merge(int[] a, int[] b) {

        int[] answer = new int[a.length + b.length];
        int i = 0, j = 0, k = 0;

        //2개의 배열중 하나의 배열의 값이 모두 정렬될때 까지 돌게 된다.
        while (i < a.length && j < b.length) {
            if (a[i] < b[j]) {
                answer[k++] = a[i++];
            } else {
                answer[k++] = b[j++];
            }
        }

        while (i < a.length) {
            answer[k++] = a[i++];
        }

        while (j < b.length) {
            answer[k++] = b[j++];
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] a = {1, 7, 20};
        int[] b = {3, 4, 6, 10};
        int[] answer = ArrayMergeSort.merge(a, b);

        for (int i : answer) {
            System.out.println(i);
        }
    }
}