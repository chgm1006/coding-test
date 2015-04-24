package com.soul.coopang;

/**
 * 해쉬테이블에 설명해봐라 직접 구현해봐라. 빅오값이 얼마냐
 */
public class HashTableEx<K, V> {
    private final int INIT_CAPACITY = 11;
    private Entry[] hTable;
    private int size;

    public HashTableEx() {
        hTable = new Entry[INIT_CAPACITY];
    }

    private int getIndex(int hashCode) {
        return hashCode % INIT_CAPACITY;
    }

    public V put(K key, V value) {
        int idx = getIndex(key.hashCode());
        Entry entry = new Entry(key, value);

        //hash table에 값이 없다면 저장 후 null 리턴
        if (this.hTable[idx] == null) {
            System.out.println("init : " + key);
            this.hTable[idx] = entry;
            size++;
            return null;
        }

        //값이 존재 한다면.
        Entry<K, V> lastEntry = null;   //같은 키값으로 존재하는 데이터가 없다면 마지막 번째 entry에 새로들러온 entry를 추가하기 위함.
        for (Entry<K, V> e = this.hTable[idx]; e != null; e = e.next) {
            lastEntry = e;
            //hash 코드값이 같고 && 참조주소가 같거나 || equals가 같다면 같은 키값이다.
            if (key.hashCode() == e.key.hashCode() && key.equals(e.key)) {
                V oldValue = e.value;
                this.hTable[idx].value = value;
                return oldValue;
            }
        }

        size++;
        lastEntry.next = entry;
        return null;
    }

    public V get(Object key) {
        int idx = getIndex(key.hashCode());

        for (Entry<K, V> e = hTable[idx]; e != null; e = e.next) {
            if (e.key.hashCode() == key.hashCode() && e.key.equals(key)) {
                return e.value;
            }
        }

        return null;
    }

    public V remove(Object key) {
        int idx = getIndex(key.hashCode());

        for (Entry<K, V> e = hTable[idx], prev = null; e != null; prev = e, e = e.next) {
            if (e.key.hashCode() == key.hashCode() && e.key.equals(key)) {
                if (prev != null) {
                    prev.next = e.next;
                } else {
                    hTable[idx] = e.next;
                }
                size--;
                return e.value;
            }
        }
        return null;
    }

    private class Entry<K, V> {
        private K key;
        private V value;
        private Entry<K, V> next;

        private Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        HashTableEx hashTableEx = new HashTableEx();
        //11로 나누었을때 같은 index를 갖도록 하기 위해 key값을 1, 12, 23 로 주었다.
        hashTableEx.put(1, 1);
        hashTableEx.put(12, 12);
        hashTableEx.put(23, 23);

        hashTableEx.put(2, 2);
        System.out.println(String.format("totalSize : %s, value : %s", hashTableEx.size, hashTableEx.get(12)));

        //linkedlist로 연결된 key값에서 중간 값을 삭제하고 정상적으로 연결이 되어있는지 테스트.
        hashTableEx.remove(12);
        System.out.println(String.format("totalSize : %s, value : %s", hashTableEx.size, hashTableEx.get(12)));
        System.out.println(String.format("totalSize : %s, value : %s", hashTableEx.size, hashTableEx.get(1)));
        System.out.println(String.format("totalSize : %s, value : %s", hashTableEx.size, hashTableEx.get(23)));
    }
}