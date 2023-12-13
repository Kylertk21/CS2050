// By: Kyler Kramer

package pack0;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class Program9 {

    private static RedBlackTree bst = new RedBlackTree();

    public static void main(String[] args) {

        try {
            BufferedReader read = new BufferedReader(new FileReader("dracula.txt"));
            PrintWriter analysis = new PrintWriter(new BufferedWriter(new FileWriter("analysis.txt", true)));
            String preProcessing;

            while ((preProcessing = read.readLine()) != null) {
                breakout(preProcessing);
            }

            bst.prettyPrint(3);

            int nodeCount = analyzeBST(bst.getRoot(), bst.getTNULL()); // Pass the root of the Red-Black Tree
            int maxNodes = (int) Math.pow(2, findHeight(bst.getRoot()) + 1) - 1;
            int height = analyzeBST(bst.getRoot(), bst.getTNULL());

            analysis.write("RBT Analysis: \n");
            analysis.write("Number of duplicates of 'the': " + bst.searchTree("the") + "\n");
            analysis.write("Number of nodes in RBT: " + nodeCount + "\n");
            analysis.write("Height of the RBT is: " + height + "\n");
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
        String[] tokenizedText = input.split("[^a-zA-Z0-9']+");

        for (String word : tokenizedText) {
            if (!word.isEmpty()) {
                bst.insert(word);
            }
        }
    }


    public static void processTokens(String input) {
        StringBuilder processedWord = new StringBuilder();
        for (char ch : input.toCharArray()) {
            if (Character.isLetterOrDigit(ch)) {
                processedWord.append(ch);
            }
        }

        if (processedWord.length() > 0) {
            bst.insert(processedWord.toString()); // Insert into the Red-Black Tree
        }
    }

    public static int analyzeBST(Node node, Node TNULL) {
        if (node == null || node == TNULL) {
            return 0;
        }

        int leftHeight = analyzeBST(node.left, TNULL);
        int rightHeight = analyzeBST(node.right, TNULL);

        // The height of the current node is the maximum height of its left and right subtrees plus 1
        int height = Math.max(leftHeight, rightHeight) + 1;

        return height;
    }


    public static int findHeight(Node node) {
        if (node == null) {
            return -1;
        } else {
            int left = findHeight(node.left);
            int right = findHeight(node.right);

            return Math.max(left, right) + 1;
        }
    }
}
