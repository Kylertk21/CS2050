package pack0;

import java.io.*;
import java.util.*;

class Program11 {

    static class KeyValuePair<K, V> {
        K key;
        V value;

        public KeyValuePair(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    static class HashTable<K, V> {
        private final int TABLE_SIZE;
        private LinkedList<KeyValuePair<K, V>>[] table;
        private int size;

        public HashTable(int tableSize) {
            TABLE_SIZE = tableSize;
            table = new LinkedList[TABLE_SIZE];
            for (int i = 0; i < TABLE_SIZE; i++) {
                table[i] = new LinkedList<>();
            }
            size = 0;
        }

        private int hash(K key) {
            int hashValue = 0;
            for (char c : key.toString().toCharArray()) {
                hashValue = (hashValue * 31 + c) % TABLE_SIZE;
            }
            return hashValue;
        }

        public void put(K key) {
            int index = hash(key);

            LinkedList<KeyValuePair<K, V>> bucket = table[index];

            for (KeyValuePair<K, V> pair : bucket) {
                if (pair.key.equals(key)) {
                    pair.value = increment(pair.value);
                    return;
                }
            }

            int nextIndex = (index + 1) % TABLE_SIZE;
            while (nextIndex != index) {
                LinkedList<KeyValuePair<K, V>> nextBucket = table[nextIndex];
                if (nextBucket.isEmpty()) {
                    nextBucket.add(new KeyValuePair<>(key, increment(null)));
                    size++;
                    return;
                }
                nextIndex = (nextIndex + 1) % TABLE_SIZE;
            }
        }

        private V increment(V value) {
            if (value == null) {
                return (V) (Integer) 1;
            } else {
                return (V) (Integer) (((Integer) value) + 1);
            }
        }

        public double calculateLoadFactor() {
            return (double) size / TABLE_SIZE;
        }

        public int getTotalNodes() {
            int totalNodes = 0;
            for (LinkedList<KeyValuePair<K, V>> bucket : table) {
                totalNodes += bucket.size();
            }
            return totalNodes;
        }
    }

    public static void main(String[] args) {
        try {
            int TABLE_SIZE = 999998; // table size

            try (PrintWriter analysis = new PrintWriter(new BufferedWriter(new FileWriter("results.txt", true)))) {
                HashTable<String, Integer> hashTable = new HashTable<>(TABLE_SIZE);

                BufferedReader read = new BufferedReader(new FileReader("dracula.txt"));
                String preProcessing;

                while ((preProcessing = read.readLine()) != null) {
                    breakout(preProcessing, hashTable);
                }

                // Calculate load factor
                double loadFactor = hashTable.calculateLoadFactor();

                // Get the total number of nodes
                int totalNodes = hashTable.getTotalNodes();

                // Write results to analysis file
                analysis.write("Hash Table Analysis (Size " + TABLE_SIZE + "):\n");
                analysis.write("Load Factor: " + loadFactor + "\n");
                analysis.write("Total Number of Nodes: " + totalNodes + "\n");
                analysis.write("Algorithm Used: hash = (hash * 31 + ASCII(c)) % TABLE_SIZE\n"
                               + "Open Addressing Method Used: Linear Probing \n");
                analysis.write("============================================\n");
            }
        } catch (IOException e) {
            System.err.println("IOException, check filenames");
            e.printStackTrace();
        }
    }

    // process string tokens
    private static void breakout(String input, HashTable<String, Integer> hashTable) {
        input = input.toLowerCase();
        input = input.strip();
        String[] tokenizedText = input.split("[^a-zA-Z0-9']+");

        for (String word : tokenizedText) {
            if (!word.isEmpty()) {
                hashTable.put(word);
            }
        }
    }
}
