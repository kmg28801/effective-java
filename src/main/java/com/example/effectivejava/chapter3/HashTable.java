package com.example.effectivejava.chapter3;

public class HashTable implements Cloneable {

    private Entry[] buckets = new Entry[10];

    //LinkedList의 Head에 해당하는 노드
    private static class Entry {
        final Object key;
        Object value;
        Entry next;

        Entry(Object key, Object value, Entry next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public void add(Object key, Object value) {
            this.next = new Entry(key, value, null);
        }

        public Entry deepCopy() {
            return new Entry(key, value, next == null ? null : next.deepCopy());
        }

//        public Entry deepCopy() {
//            Entry result = new Entry(key, value, next);
//            for (Entry p = result; p.next != null; p = p.next) {
//                p.next = new Entry(p.next.key, p.next.value, p.next.next);
//            }
//            return result;
//        }
    }

//    /**
//     * Shallow Copy(얕은 복사)
//     * 새로 만든 인스턴스 배열의 인스턴스들이 동일한 인스턴스라는 것.
//     * 배열 내부에 참조하고 있는 인스턴스들이 COPY한 것과 원본이 동일하다.
//     * TODO hashTable -> entryH[],
//     * TODO copy -> entryC[]
//     * TODO entryH[0] == entryC[0]
//     */
//    @Override
//    public HashTable clone() {
//        HashTable result = null;
//        try {
//            result = (HashTable) super.clone();
//            result.buckets = this.buckets.clone(); //shallow copy 라서 위험하다.
//            return result;
//        } catch (CloneNotSupportedException e) {
//            throw new AssertionError();
//        }
//    }

    //deepCopy
    @Override
    public HashTable clone() {
        HashTable result = null;
        try {
            result = (HashTable) super.clone();
            result.buckets = new Entry[this.buckets.length];
            for (int i = 0; i < this.buckets.length; i++) {
                if (buckets[i] != null) {
                    result.buckets[i] = this.buckets[i].deepCopy(); //83페이지 deep copy
                }
            }
            return result;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    public static void main(String[] args) {
        HashTable hashTable = new HashTable();
        Entry entry = new Entry(new Object(), new Object(), null);
        hashTable.buckets[0] = entry;
        HashTable clone = hashTable.clone();
        System.out.println(hashTable.buckets[0] == entry);
        System.out.println(hashTable.buckets[0] == clone.buckets[0]);
    }
}
