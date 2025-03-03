package Stack;

public class Main {
    private class MyStack {
        private final int length = 1000;
        private final int stack[] = new int[length];
        private int top = -1;

        public int size() {
            return top + 1;
        }

        public int top() {
            if (top == -1)
                return Integer.MIN_VALUE;
            return stack[top];
        }

        public void push(int value) {
            if (top == length - 1)
                return;
            stack[++top] = value;
        }

        public int pop() {
            if (top == -1)
                return Integer.MIN_VALUE;
            return stack[top--];
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("[ ");
            for (int i = 0; i <= top; i++) {
                sb.append(String.valueOf(stack[i]));
                if (i != top)
                    sb.append(", ");
            }
            sb.append(" ]");
            return sb.toString();
        }
    }

    public static void main(String[] args) {
        Main mainInstance = new Main();
        MyStack stack = mainInstance.new MyStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack);
        stack.pop();
        stack.pop();
        System.out.println(stack);
        System.out.println("Size -> " + stack.size());
        System.out.println("Top -> " + stack.top());
    }
}
