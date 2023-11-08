//By: Kyler Kramer

package pack0;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

class Node {
    String data;
    Node left, right;

    public Node(String input) {
        data = input;
        left = right = null;
    }
}

public class Program8 {
    
	private static ArrayList<String> processedText = new ArrayList<>();
    private static String[] tokenizedText;
    private static Node root;
    private static int counter = 0;

    public static void main(String[] args) {

        try {
            BufferedReader read = new BufferedReader(new FileReader("dracula.txt"));
            PrintWriter analysis = new PrintWriter(new BufferedWriter(new FileWriter("analysis.txt" , true))); 
            String preProcessing;

            while ((preProcessing = read.readLine()) != null) {
                breakout(preProcessing);
                counter++;
            }

            for (String input : processedText) { //create BST from processed text
                if (root == null) {
                    root = new Node(input);
                } else {
                    insert(root, input);
                }
            }
            
            int maxNodes = (int) Math.pow(2, findHeight(root) + 1) - 1;
            int nodeCount = analyzeBST(root); 
            
            analysis.write("BST Analysis: \n"); // printout of Node data to analysis.txt
            analysis.write("Number of nodes in BST: " + nodeCount + "\n");
            analysis.write("Height of the BST is: " + findHeight(root) + "\n");
            analysis.write("Max possible height: " + maxNodes + "\n");
            analysis.write("============================================\n");
           
            read.close();
            analysis.close(); 
        } catch (IOException e) {
            System.err.println("IOException, check filenames");
        	e.printStackTrace();
        }
    }

    public static void breakout(String input) {
        input = input.toLowerCase();
        input = input.strip();
        tokenizedText = input.split("\\s+"); // Split input string by whitespace

        for (String word : tokenizedText) {
            processTokens(word);
        }
    }

    public static void processTokens(String input) { // remove unnecessary characters
        StringBuilder processedWord = new StringBuilder();
        for (char ch : input.toCharArray()) {
            if (Character.isLetterOrDigit(ch)) {
                processedWord.append(ch);
            }
        }

        if (processedWord.length() > 0) {
            processedText.add(processedWord.toString());
        }
    }

    public static void insert(Node node, String input) { //node insertion function
        if (input.compareTo(node.data) < 0) {
            if (node.left != null) {
                insert(node.left, input);
            } else {
                node.left = new Node(input);
            }
        } else if (input.compareTo(node.data) > 0) {
            if (node.right != null) {
                insert(node.right, input);
            } else {
                node.right = new Node(input);
            }
        }
    }

    /*public static String printNodes(Node node) { // to check nodes are being ordered correctly
        if (node != null) {
            String printOut = "";

            printOut += printNodes(node.left);
            printOut += node.data + " ";
            printOut += printNodes(node.right);

            return printOut;
        }

        return "";
    } */

    public static int analyzeBST(Node node) { // post-order traversal 
        if (node == null) {
            return 0;
        }
        int left = analyzeBST(node.left);
        int right = analyzeBST(node.right);
        int total = left + right + 1;
        return total;
    }
    
    public static int findHeight(Node node) { // find height of longest branch
        if (node == null) {
            return -1; 
        } else {
            int left = findHeight(node.left);
            int right = findHeight(node.right);

            
            return Math.max(left, right) + 1;
        }
    }
    
    
}
