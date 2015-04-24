package com.soul.skp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 두 단어에 대한 아나그램 검사 함수 작성
 */
public class Anagram {

    public static void main(String[] args) {


        String s1 = "3123";
        String s2 = "3213";
//        System.out.println(isAnagram(s1, s2));
        System.out.println(isCompleteAnagram(s1, s2));
    }

    /**
     * Map<String, Map<Integer, Integer>> wordCounter 변수의 설명
     * key(String) : 한 문자가 들어간다.
     * <p/>
     * Map<Integer, Integer>
     * - key : 위의 예제에서 s1 0번, s2 1번
     * - value : 하나씩 값을 증가시킨다.
     *
     * 위와 같이 값을 입력한 후 Map<Integer, Integer> 에서 key의 0과 1의 value 값이 같다면 1값을 리턴 나머지 경우에는 -1리턴 결국 아나그램이 맞다면 total 값은 0가 될것이다.
     *
     * @param wordCounter
     * @param idx
     * @param str
     * @return
     */
    public static int increaseCount(Map<String, Map<Integer, Integer>> wordCounter, int idx, String str) {
        int oppositeIdx = idx == 1 ? 0 : 1;

        if (wordCounter.get(str) == null) { //아직 검사하지 않은 문자의 경우
            Map<Integer, Integer> innerCount = new HashMap<>();
            innerCount.put(idx, 1);
            wordCounter.put(str, innerCount);

            return -1;
        } else {    //이미 등록된 문자가 있는 경우.
            int wordCount = 1;
            Map<Integer, Integer> innerCount = wordCounter.get(str);
            if (innerCount.get(idx) == null) {  //다른 단어에서 입력하여 등록된 경우.
                innerCount.put(idx, wordCount);
            } else {    //같은 단어에서 입력된 경우
                wordCount = innerCount.get(idx);
                wordCount++;
                innerCount.put(idx, wordCount);
            }

            //2개의 다른 단어에서의 증가시킨 카운트 값이 같다면 1값을 리턴
            if (wordCount == innerCount.get(oppositeIdx)) {
                return 1;
            }
            return -1;
        }
    }

    public static boolean isCompleteAnagram(String s1, String s2) {
        if (s1.length() == s2.length()) {
            int total = 0;
            Map<String, Map<Integer, Integer>> wordCounter = new HashMap();
            for (int idx = 0; idx < s1.length(); idx++) {
                String temp1 = s1.substring(idx, idx + 1);
                String temp2 = s2.substring(idx, idx + 1);

                total += increaseCount(wordCounter, 0, temp1);
                total += increaseCount(wordCounter, 1, temp2);
            }

            //2개의 단어의 카운트를 비교해서 0의 값이 된다면, 첫번째 등록시는 반대 단어에 증가시킨 값이 없으므로 -1을 리턴할 것이고 그후 반대 단어에서 1을 리턴하므로 최종적으로 0의 값을 갖는다.
            if (total == 0) {
                return true;
            }
        }

        return false;
    }

    //두개의 단어를 넣어서 정렬한 후 비교하여 리턴타입으로 boolean을 주어 아나그램이면true, 아니면false를 반환한다.
    public static boolean isAnagram(String a, String b) {


        char[] a1 = a.toCharArray(); //문자열 두개를 배열에다 넣는다.
        char[] a2 = b.toCharArray();

        Arrays.sort(a1); //문자열을 정렬시킨다.
        Arrays.sort(a2);

        if (Arrays.equals(a1, a2)) { // 두 배열이 일치하는지 판단한다.
            return true;
        } else {
            return false;
        }
    }
}
