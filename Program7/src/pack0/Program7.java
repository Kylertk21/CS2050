package pack0; 


// Kyler Kramer 
// Program 6

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.lang.NullPointerException; 

public class Program7 {
    public static void main(String[] args) throws FileNotFoundException, IOException {

        File numbersFile = new File("NumbersInFile.txt");
        File stringFile = new File("StringsInFIle");
        File results = new File("Results.txt");
        FileWriter writeTo = new FileWriter(results);

        Scanner numbersScanner = new Scanner(numbersFile);
        Scanner stringScanner = new Scanner(stringFile);

        String[] stringSelectionSorted = new String[10000];
        String[] stringBubbleSorted = new String[10000];
        int[] selectionSorted = new int[20000];
        int[] bubbleSorted = new int[20000];
        int[] insertionSorted = new int[20000];
        
        ArrayList<Integer> listInsertionSorted = new ArrayList<Integer> (20000); 
        ArrayList<String> collectionSorted = new ArrayList<String> (20000); 
        ArrayList<String> stringInsertionSorted = new ArrayList<String> (20000); 
        
        int stringCounter = 0;
        int counter = 0;

        while (stringScanner.hasNextLine()) {
            String stringsIn = stringScanner.nextLine();
            collectionSorted.add(stringsIn);
            stringInsertionSorted.add(stringsIn);
            stringBubbleSorted[stringCounter] = stringsIn;
            stringSelectionSorted[stringCounter] = stringsIn;
            stringCounter++;
        }

        while (numbersScanner.hasNextInt()) {
            int numbersIn = numbersScanner.nextInt();
            listInsertionSorted.add(numbersIn); 
            selectionSorted[counter] = numbersIn;
            bubbleSorted[counter] = numbersIn;
            insertionSorted[counter] = numbersIn; 
            counter++;
        }
        
        long startTime; 
        long endTime;
        long exTime;
        
        startTime = System.nanoTime(); 
        selectionSort(selectionSorted); 
        endTime = System.nanoTime();
        exTime = (endTime - startTime)/1000000;
        writeTo.write("Int Selection Sort Time In Milliseconds:     " + exTime + " | Number of Ints: " + counter + "\n");
        
        startTime = System.nanoTime();
        bubbleSort(bubbleSorted); 
        endTime = System.nanoTime();
        exTime = (endTime - startTime)/1000000;
        writeTo.write("Int Bubble Sort Time In Milliseconds:       " + exTime + " | Number of Ints: " + counter + "\n");
        
        startTime = System.nanoTime();
        Collections.sort(collectionSorted);
        endTime = System.nanoTime();
        exTime = (endTime - startTime)/1000000;
        writeTo.write("Int Collection Sort Time In Milliseconds:     " + exTime + " | Number of Ints: " + counter + "\n");
        
        
        startTime = System.nanoTime();
        stringBubbleSort(stringBubbleSorted); 
        endTime = System.nanoTime();
        exTime = (endTime - startTime)/1000000;
        writeTo.write("String Bubble Sort Time In Milliseconds:    " + exTime + " | Number of Strings: " + stringCounter + "\n");
        
        startTime = System.nanoTime();
        stringSelectionSort(stringSelectionSorted);
        endTime = System.nanoTime();
        exTime = (endTime - startTime)/1000000;
        writeTo.write("String Selection Sort Time In Milliseconds: " + exTime + " | Number of Strings: " + stringCounter + "\n");
         
        startTime = System.nanoTime();
        insertionSort(insertionSorted);
        endTime = System.nanoTime();
        exTime = (endTime - startTime)/1000000;
        writeTo.write("Insertion Sort Array List Time In Milliseconds: " + exTime + " | Number of Strings: " + stringCounter + "\n");
        
        
        startTime = System.nanoTime();
        insertionArraylistSortInt(listInsertionSorted);
        endTime = System.nanoTime();
        exTime = (endTime - startTime)/1000000;
        writeTo.write("Insertion Sort Array List Time In Milliseconds: " + exTime + " | Number of Strings: " + stringCounter + "\n");
        
        startTime = System.nanoTime();
        insertionArraylistSortString(stringInsertionSorted); 
        endTime = System.nanoTime();
        exTime = (endTime - startTime)/1000000;
        writeTo.write("Insertion Sort Array List String Time In Milliseconds: " + exTime + " | Number of Strings: " + stringCounter + "\n");
        

        writeTo.close();
        numbersScanner.close();
        stringScanner.close();
    }

    public static int[] selectionSort(int x[]) { //integer selection sort
        int length = x.length;
        for (int i = 0; i < length - 1; i++) {
            int minimum = x[i];
            int indexMinimum = i;
            for (int j = i + 1; j < length; j++) {
                if (x[j] < minimum) {
                    minimum = x[j];
                    indexMinimum = j;
                }
            }
            swap(x, i, indexMinimum);
        }
        return x;
    }
   
    public static int[] bubbleSort(int x[]) { //integer bubble sort
        int temp;
        int n = x.length;
        for (int i = 0; i < n - 1; i++)
            for (int j = i + 1; j < n; j++) {
                if (x[j] < x[i]) {
                    temp = x[i];
                    x[i] = x[j];
                    x[j] = temp;
                }
            }
        return x;
    }
    
    public static String[] stringBubbleSort(String x[]) {//string bubble sort
        String temp;
        int n = x.length;
        for (int i = 0; i < n - 1; i++)
            for (int j = i + 1; j < n; j++) {
                if (x[j].compareTo(x[i]) < 0)  {
                    temp = x[i];
                    x[i] = x[j];
                    x[j] = temp;
                }
            }
        return x;
    }

    public static String[] stringSelectionSort(String x[]) {//string selection sort
         
    	int smallest;
        
    	for (int i = 0; i < x.length - 1; i++) {
            smallest = i;
            for (int j = i + 1; j < x.length; j++) {
            	if (x[j].compareTo(x[smallest]) < 0 )  {
                    smallest = j;
                }
            }
            if (smallest != i) {
                stringSwap(x, i, smallest);
            }
        }
        return x;
    }
  	
    	 public static int[] insertionSort(int[] x) {//integer insertion sort
    	        int n = x.length;
    	        for (int i = 1; i < n; i++) {
    	            int key = x[i];
    	            int j = i - 1;
    	            
    	            while (j >= 0 && x[j] > key) {
    	                x[j + 1] = x[j];
    	                j--;
    	            }
    	            x[j + 1] = key;
    	        }
    	        return x;
    	    }
    	 
    	 public static void insertionArraylistSortInt(ArrayList<Integer> list) {//integer arraylist insertion sort
    	        int n = list.size();
    	        for (int i = 1; i < n; i++) {
    	            int key = list.get(i);
    	            int j = i - 1;

    	            while (j >= 0 && list.get(j) > key) {
    	                list.set(j + 1, list.get(j));
    	                j--;
    	            }
    	            list.set(j + 1, key);
    	        }
    	    }

    	    public static void insertionArraylistSortString(ArrayList<String> list) {//string arraylist insertion sort
    	        int n = list.size();
    	        for (int i = 1; i < n; i++) {
    	            String key = list.get(i);
    	            int j = i - 1;

    	            while (j >= 0 && list.get(j).compareTo(key) > 0) {
    	                list.set(j + 1, list.get(j));
    	                j--;
    	            }
    	            list.set(j + 1, key);
    	        }
    	    }
    	

    private static void swap(int[] x, int a, int b) {
        int temp = x[a];
        x[a] = x[b];
        x[b] = temp;
    }

    private static void stringSwap(String[] x, int a, int b) {
        String temp = x[a];
        x[a] = x[b];
        x[b] = temp;
    }
}
