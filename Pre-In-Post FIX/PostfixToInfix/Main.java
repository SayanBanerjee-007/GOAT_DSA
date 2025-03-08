package PostfixToInfix;

import java.util.Stack;

public class Main {
    public static String postfixToInfix(String postfix) {
        Stack<String> stack = new Stack<>();

        for (char c : postfix.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                stack.push(String.valueOf(c));
            } else {
                String second = stack.pop();
                String first = stack.pop();
                StringBuilder newEx = new StringBuilder();
                // TC for the below line is O(n) where n is the length of the string
                newEx.append('(');
                newEx.append(first);
                newEx.append(c);
                newEx.append(second);
                newEx.append(')');
                stack.push(newEx.toString());
            }
        }
        return stack.peek();
    }

    public static void main(String[] args) {
        String postfix = "ab+ef*g*-";
        System.out.println("Postfix: " + postfix);
        System.out.println("Infix: " + postfixToInfix(postfix));
    }
}
