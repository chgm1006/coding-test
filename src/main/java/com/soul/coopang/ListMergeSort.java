package com.soul.coopang;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 하나의 리스트에 숫자값과 리스트가 혼합해서 들어가 있을때, 하나의 리스트로 합치고 정렬하라
 * 조건 : 중복 제거, 병합, 정렬
 * <p/>
 * 순서
 * 1. List의 int 값들을 하나의 list로 병합한다.
 * 2. list를 array로 변경한다.
 * 3. quicksort를 이용하여 정렬
 * 4. list에 데이터를 담으면서 중복된 값들을 제거한다.
 */
public class ListMergeSort {
    public List<Integer> sort(List<Integer> list) {
        int[] numbers = new int[list.size()];
        Iterator<Integer> iter = list.iterator();
        for (int i = 0; iter.hasNext(); i++) {
            numbers[i] = iter.next();
        }

        quickSort(numbers, 0, numbers.length - 1);
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < numbers.length; i++) {
            int j = i + 1;
            int idx = i;
            while (j < numbers.length) {
                if (numbers[i] == numbers[j]) {
                    j++;
                    i++;
                } else {
                    break;
                }
            }
            result.add(numbers[idx]);
        }
        return result;
    }

    public void quickSort(int[] inputArr, int left, int right) {
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

    public List<Integer> merge(List originList) {
        List<Integer> list = new ArrayList<>();
        for (Object o : originList) {
            if (o instanceof List) {
                List<Integer> innerList = (List<Integer>) o;
                for (int val : innerList) {
                    list.add(val);
                }
            } else {
                list.add((int) o);
            }
        }

        return list;
    }

    public List<Integer> executeMergeSort(List originList) {
        List<Integer> list = merge(originList);
        list = sort(list);
        return list;
    }

    public void print(List<Integer> result) {
        Iterator<Integer> iter = result.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }
    }

    public static void main(String[] args) {
        List temp = new ArrayList();
        temp.add(7);
        temp.add(10);

        List temp2 = new ArrayList();
        temp2.add(10);
        temp2.add(1);

        List list = new ArrayList();
        list.add(5);
        list.add(1);
        list.add(3);
        list.add(10);
        list.add(temp);
        list.add(temp2);

        ListMergeSort mergeSort = new ListMergeSort();
        List<Integer> result = mergeSort.executeMergeSort(list);
        mergeSort.print(result);
    }
}