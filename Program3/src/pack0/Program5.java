package pack0;

import java.io.*;
import java.util.*;

public class Program5 {
    private static Stack<String> stack = new Stack<String>();

    public static void main(String args[]) throws IOException, FileNotFoundException {
        try {
            File program3In = new File("Program3.txt");
            File program4Out = new File("Program5.out");
            program4Out.createNewFile(); // Create the output file if it doesn't exist
            FileWriter fileWriter = new FileWriter(program4Out);

            Scanner fileData = new Scanner(program3In);
            String textInput;

            while (fileData.hasNext()) {
                textInput = fileData.nextLine();
                String postfix; 
                if (textInput.contains("@") || textInput.contains("&")) {
                	postfix = "[Invalid Character]";
                	
                } else
                
                postfix = InfixToPostfix(textInput);
                
                // Print postfix expression
                System.out.println(postfix);

                // Write postfix expression to output file
                fileWriter.write(postfix + "\n");

                // Push postfix to linked list
                stack.push(postfix);
            }
            fileWriter.close();
            fileData.close();
        } catch (EmptyStackException e) {
            System.out.println("Array out of bounds, check values. \n Index Value: ");
        }
    }

    public static String InfixToPostfix(String s) {
        Stack<String> stack = new Stack<String>();
        
        StringBuilder postfix = new StringBuilder();
        
        
        
        String[] tokens = s.split("\\s+");

        for (String token : tokens) {
            token = token.trim(); // Remove leading/trailing spaces

            if (token.isEmpty()) {
                continue; // Skip empty tokens
            }

            if (isDouble(token) || isInt(token)) {
                postfix.append(token).append(" ");
            } else if (isOperator(token)) {
                while (!stack.isEmpty() && hasHigherPrecedence(stack.peek(), token)) {
                    postfix.append(stack.pop()).append(" ");
                }
                stack.push(token);
            } else if (token.equals("(")) {
                stack.push(token);
            } else if (token.equals(")")) {
                while (!stack.isEmpty() && !stack.peek().equals("(")) {
                    postfix.append(stack.pop()).append(" ");
                }
                if (!stack.isEmpty() && stack.peek().equals("(")) {
                    stack.pop(); // Pop the opening parenthesis
                }
            } else if (token.equals("@") || token.equals("&")) {
                postfix.setLength(0); // Clear the postfix expression
                postfix.append("[invalid character]");
                break; // Stop processing the current expression
            }
        }

        while (!stack.isEmpty()) {
            postfix.append(stack.pop()).append(" ");
        }

        return postfix.toString().trim();
    }

    public static boolean isOperator(String s) {
        return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/") || s.equals("%") || s.equals("&") || s.equals("@");
    }

    public static boolean hasHigherPrecedence(String op1, String op2) {
        int prec1 = getPrecedence(op1);
        int prec2 = getPrecedence(op2);

        return prec1 >= prec2;
    }

    public static boolean isDouble(String s) {
        try {
            Double.parseDouble(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isInt(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static int getPrecedence(String operator) {
        if (operator.equals("*") || operator.equals("/") || operator.equals("%")) {
            return 2;
        } else if (operator.equals("+") || operator.equals("-")) {
            return 1;
        } else if (operator.equals("&") || operator.equals("@")) {
        	return 0; // Lower precedence for "@" and "&"
        } else {
            return -1; // Default precedence for other operators
        }
    }
}
