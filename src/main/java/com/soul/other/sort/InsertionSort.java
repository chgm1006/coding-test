package com.soul.other.sort;

import java.util.LinkedList;
import java.util.List;

/**
 * 삽입정렬 예제.
 * 1) 중간에 값을 삽입해야 하기 때문에 ArrayList 보다 LinkedList를 사용한다.
 */
public class InsertionSort {
    public static void main(String[] args) {
        int[] input = {20, 1, 50, 200, 30, 2};

        List<Integer> sorted = new LinkedList<>();


        for (int i = 0; i < input.length; i++) {
            boolean isContinue = false;
            for (int j = 0; j < sorted.size(); j++) {
                if (input[i] < sorted.get(j)) {
                    sorted.add(j, input[i]);
                    isContinue = true;
                    break;
                }
            }

            if (!isContinue) {
                sorted.add(sorted.size(), input[i]);
            }
        }

        for (int value : sorted) {
            System.out.println(value);
        }
    }
}
