package PrefixToInfix;

import java.util.Stack;

public class Main {

    public static String prefixToInfix(String prefix) {
        Stack<String> stack = new Stack<>();
        for (int i = prefix.length() - 1; i >= 0; i--) {
            char c = prefix.charAt(i);
            if (Character.isLetterOrDigit(c)) {
                stack.push(c + "");
            } else {
                String op1 = stack.pop();
                String op2 = stack.pop();
                stack.push("(" + op1 + c + op2 + ")");
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        String prefix = "*+AB-CD";
        System.out.println("Prefix: " + prefix);
        System.out.println("Infix: " + prefixToInfix(prefix));
    }
}
