package InfixToPrefix;

import java.util.Stack;

public class Main {

    public static int precedence(char ch) {
        switch (ch) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }

    public static String infixToPrefixStack(String infix) {
        String reversedInfix = reverseInfix(infix);
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (char ch : reversedInfix.toCharArray()) {
            if (Character.isLetterOrDigit(ch)) {
                result.append(ch);
            } else if (ch == '(') {
                stack.push(ch);
            } else if (ch == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    result.append(stack.pop());
                }
                stack.pop();
            } else {
                // while (!stack.isEmpty() && precedence(ch) <= precedence(stack.peek())) {
                while (!stack.isEmpty() && precedence(ch) < precedence(stack.peek())) {
                    result.append(stack.pop());
                }
                stack.push(ch);
            }
        }
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }
        return result.reverse().toString();
    }

    private static String reverseInfix(String infix) {
        StringBuilder result = new StringBuilder();
        for (int i = infix.length() - 1; i >= 0; i--) {
            char ch = infix.charAt(i);
            if (ch == '(') {
                result.append(')');
            } else if (ch == ')') {
                result.append('(');
            } else {
                result.append(ch);
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String infix = "(A+B^X+N^W^W)*C-D+F";
        String prefixStack = infixToPrefixStack(infix);
        System.out.println("Infix: " + infix);
        System.out.println("Prefix: " + prefixStack);
        System.out.println("Correct: +-*++A^BX^^NWWCDF");
    }
}
