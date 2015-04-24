package com.soul.coopang;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 하나의 문서가 있다라고 가정하였을때, 문서에서 가장 많이 카운팅 된 단어를 n 번순위까지 구하라.
 */
public class WordCount {
    private Map<String, Integer> wordMap = new HashMap<>();

    private class Word {
        private String word;
        private int count;

        private Word(String word, int count) {
            this.word = word;
            this.count = count;
        }
    }

    public Word[] sort() {
        Word[] words = new Word[wordMap.size()];
        Iterator<String> iter = wordMap.keySet().iterator();
        for (int i = 0; iter.hasNext(); i++) {
            String tempWord = iter.next();
            Word word = new Word(tempWord, wordMap.get(tempWord));
            words[i] = word;
        }

        quickSort(words, 0, words.length - 1);
        return words;
    }

    private void quickSort(Word[] words, int left, int right) {
        if (left < right) {
            int pivot = words[(left + right) / 2].count;
            int i = left - 1;
            int j = right + 1;

            while (true) {

                while (words[++i].count > pivot) ;
                while (words[--j].count < pivot) ;
                if (i >= j) break;

                Word temp = words[i];
                words[i] = words[j];
                words[j] = temp;
            }
            quickSort(words, left, i - 1);
            quickSort(words, j + 1, right);
        }
    }

    public void count() throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(this.getClass().getClassLoader()
                .getResourceAsStream("wordcount.txt"), "euc-kr"));
        String line = null;
        while ((line = reader.readLine()) != null) {
            String[] splitWord = line.split(" ");
            for (String word : splitWord) {
                Integer count = wordMap.get(word);
                if (count == null) {
                    wordMap.put(word, 1);
                } else {
                    wordMap.put(word, count + 1);
                }
            }
        }
    }

    public void printTopWord(Word[] words, int topNo) {
        if (words.length < topNo) {
            topNo = words.length;
        }
        for (int i = 0; i < topNo; i++) {
            System.out.println(String.format("word:%s, count:%s", words[i].word, words[i].count));
        }
    }

    public static void main(String[] args) throws Exception {
        WordCount wordCount = new WordCount();
        wordCount.count();
        Word[] words = wordCount.sort();

        wordCount.printTopWord(words, 5);
    }
}
