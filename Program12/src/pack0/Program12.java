// Program 12
// By: Kyler Kramer


package pack0;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

public class Program12 {

    private static HashMap<String, Integer> wordCountMap = new HashMap<>();

  
    private static PrintWriter resultsWriter;

    public static void main(String[] args) {

        try {
           
            resultsWriter = new PrintWriter(new BufferedWriter(new FileWriter("results.txt")));

            
            processFileWithHashMap();

          
            wordCountMap.clear();

          
            processFileWithHashMap(10000, 0.75);

            
            wordCountMap.clear();

           
            processFileWithHashMap(20000, 0.75);

            
            resultsWriter.close();
        } catch (IOException e) {
            System.err.println("IOException, check filenames");
            e.printStackTrace();
        }
    }

    private static void processFileWithHashMap() throws IOException {
        BufferedReader read = new BufferedReader(new FileReader("dracula.txt"));

        long startTime = System.nanoTime();

        String preProcessing;
        while ((preProcessing = read.readLine()) != null) {
            processTokensWithHashMap(preProcessing);
        }

        long endTime = System.nanoTime();
        long elapsedTime = endTime - startTime;
        
        resultsWriter.write("Number of Nodes From Program 11: 163415 \n \n");
        resultsWriter.write("HashMap Analysis (Default Constructor):\n");
        resultsWriter.write("Time taken (nanoseconds): " + elapsedTime + "\n");
        resultsWriter.write("Size of HashMap: " + wordCountMap.size() + "\n");
        resultsWriter.write("Load Factor: " + calculateLoadFactor(wordCountMap) + "\n");
        resultsWriter.write("============================================\n");

       
        read.close();
    }

    private static void processFileWithHashMap(int initialCapacity, double loadFactor) throws IOException {
        BufferedReader read = new BufferedReader(new FileReader("dracula.txt"));
        wordCountMap = new HashMap<>(initialCapacity, (float) loadFactor);

        long startTime = System.nanoTime();

        String preProcessing;
        while ((preProcessing = read.readLine()) != null) {
            processTokensWithHashMap(preProcessing);
        }

        long endTime = System.nanoTime();
        long elapsedTime = endTime - startTime;

        resultsWriter.write("HashMap Analysis (Initial Capacity: " + initialCapacity + ", Load Factor: " + loadFactor + "):\n");
        resultsWriter.write("Time taken (nanoseconds): " + elapsedTime + "\n");
        resultsWriter.write("Size of HashMap: " + wordCountMap.size() + "\n");
        resultsWriter.write("Number of nodes: " + calculateNodesInHashMap() + "\n");
        resultsWriter.write("Load Factor: " + calculateLoadFactor(wordCountMap) + "\n");
        resultsWriter.write("============================================\n");

        
        read.close();
    }

    private static int calculateNodesInHashMap() {
        int nodes = 0;
        for (int value : wordCountMap.values()) {
            nodes += value;
        }
        return nodes;
    }


    private static void processTokensWithHashMap(String input) {
        input = input.toLowerCase();
        input = input.strip();
        String[] tokenizedText = input.split("[^a-zA-Z0-9']+");

        for (String word : tokenizedText) {
            if (!word.isEmpty()) {
                
                wordCountMap.merge(word, 1, Integer::sum);
            }
        }
    }


    private static float calculateLoadFactor(HashMap<?, ?> map) {
        return (float) map.size() / map.size();
    }
}
