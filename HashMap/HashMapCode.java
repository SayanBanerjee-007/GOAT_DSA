package HashMap;

import java.util.*;

public class HashMapCode {
    static class HashMap<K, V> {
        private class Node {
            K key;
            V value;

            public Node(K key, V value) {
                this.key = key;
                this.value = value;
            }
        }

        private int bucketSize;
        public int size;
        private LinkedList<Node>[] bucket;

        @SuppressWarnings("unchecked")
        public HashMap() {
            this.size = 0;
            this.bucketSize = 4;
            this.bucket = new LinkedList[this.bucketSize];
            for (int i = 0; i < bucket.length; i++) {
                bucket[i] = new LinkedList<>();
            }
        }

        private int hashKey(K key) {
            int hashedKey = key.hashCode();
            return Math.abs(hashedKey) % bucketSize;
        }

        private int searchBucket(int bucketIndex, K key) {
            LinkedList<Node> ll = bucket[bucketIndex];
            for (int i = 0; i < ll.size(); i++) {
                if (ll.get(i).key == key) {
                    return i;
                }
            }
            return -1;
        }

        @SuppressWarnings("unchecked")
        private void rehash() {
            LinkedList<Node> oldBucket[] = bucket;
            bucketSize <<= 1;
            bucket = new LinkedList[this.bucketSize];

            for (int i = 0; i < bucketSize; i++) {
                bucket[i] = new LinkedList<>();
            }

            for (int i = 0; i < oldBucket.length; i++) {
                LinkedList<Node> ll = oldBucket[i];
                for (int j = 0; j < ll.size(); j++) {
                    Node node = ll.remove(j);
                    put(node.key, node.value);
                }
            }
        }

        public void put(K key, V value) {
            int bucketIndex = hashKey(key);
            int llIndex = searchBucket(bucketIndex, key);

            if (llIndex != -1) {
                Node node = bucket[bucketIndex].get(llIndex);
                node.value = value;
            } else {
                Node newNode = new Node(key, value);
                bucket[bucketIndex].add(newNode);
                size++;
            }

            double lambda = (double) size / bucketSize;
            if (lambda > 2.0) {
                rehash();
            }
        }

        public boolean containsKey(K key) {
            int bucketIndex = hashKey(key);
            int llIndex = searchBucket(bucketIndex, key);
            return llIndex != -1;
        }

        public V remove(K key) {
            return null;
        }

        public V get(K key) {
            return null;
        }

    }
}
