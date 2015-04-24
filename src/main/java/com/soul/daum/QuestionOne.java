package com.soul.daum;

/**
 * Created by soul on 2015-04-09.
 */
public class QuestionOne {
    int posA[] = {1, 18, 30, 44, 57};
    int posB[] = {2, 41, 58};
    int posC[] = {3, 42, 53, 58};


    /**
     * 3단어가 가장 근접한 거리를 찾는다.
     */
    public void calculateMinDistance() {
        int indexA = 0;
        int indexB = 0;
        int indexC = 0;

        int shortestDistance = 65555;
        int minVal = 0, maxVal = 0;
        int distance;

        int min = 0, max = 0;

        int i = 0;
        while (true) {
            i++;
            minVal = min(posA[indexA], posB[indexB], posC[indexC]);
            maxVal = max(posA[indexA], posB[indexB], posC[indexC]);
            distance = maxVal - minVal;

            if (distance < shortestDistance) {
                shortestDistance = distance;
                min = minVal;
                max = maxVal;
            }

            //최소 거리에 있는 배열의 위치를 하나씩 증가시킨다.
            if (minVal == posA[indexA]) {
                indexA++;
            } else if (minVal == posB[indexB]) {
                indexB++;
            } else if (minVal == posC[indexC]) {
                indexC++;
            }

            //3개의 배열중 마지막에 도달한 배열이 있다면 루프를 벗어난다.
            if (indexA == posA.length || indexB == posB.length || indexC == posC.length) {
                break;
            }
        }

        System.out.println(min + "," + max + "에 있고 거리는 " + (max - min) + "이다" + " : " + i);
    }

    /**
     * 3개 위치중 최단 거리에 있는 위치를 찾는다.
     *
     * @param a a단어의 위치
     * @param b b단어의 위치
     * @param c c단어의 위치
     * @return
     */
    private int min(int a, int b, int c) {
        int min = Math.min(a, b);
        min = Math.min(min, c);

        return min;
    }

    /**
     * 3개 위치중 최장 거리에 있는 위치를 찾는다.
     *
     * @param a a단어의 위치
     * @param b b단어의 위치
     * @param c c단어의 위치
     * @return
     */
    private int max(int a, int b, int c) {
        int max = Math.max(a, b);
        max = Math.max(max, c);

        return max;
    }


    public static void main(String[] args) {
        QuestionOne question = new QuestionOne();
        question.calculateMinDistance();
    }
}
