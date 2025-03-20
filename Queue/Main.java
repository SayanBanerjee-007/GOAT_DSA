package Queue;

public class Main {
    private class Queue {
        private final int length = 3;
        private final int queue[] = new int[length];
        private int front = -1, rear = -1;

        public int size() {
            if (front == -1)
                return 0;
            if (front <= rear)
                return rear - front + 1;
            return length - front + rear + 1;
        }

        public boolean isFull() {
            return (rear + 1) % length == front;
        }

        public boolean isEmpty() {
            return front == -1;
        }

        public void enqueue(int value) {
            if (isFull()) {
                System.out.println("Enqueue: Queue is full");
                return;
            }
            if (front == -1) {
                front = rear = 0;
            } else {
                rear = (rear + 1) % length;
            }
            queue[rear] = value;
        }

        public int dequeue() {
            if (isEmpty()) {
                System.out.println("Dequeue: Queue is empty");
                return Integer.MIN_VALUE;
            }
            int value = queue[front];
            if (front == rear) {
                front = rear = -1;
            } else {
                front = (front + 1) % length;
            }
            return value;
        }

        public int front() {
            if (isEmpty()) {
                System.out.println("Front: Queue is empty");
                return Integer.MIN_VALUE;
            }
            return queue[front];
        }

        public int rear() {
            if (isEmpty()) {
                System.out.println("Rear: Queue is empty");
                return Integer.MIN_VALUE;
            }
            return queue[rear];
        }

        @Override
        public String toString() {
            if (isEmpty()) {
                return "[]";
            }
            if (front <= rear) {
                StringBuilder sb = new StringBuilder();
                sb.append("[ ");
                for (int i = front; i <= rear; i++) {
                    sb.append(queue[i]);
                    if (i != rear) {
                        sb.append(", ");
                    }
                }
                sb.append(" ]");
                return sb.toString();
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("[ ");
                for (int i = front; i < length; i++) {
                    sb.append(queue[i]);
                    sb.append(", ");
                }
                for (int i = 0; i <= rear; i++) {
                    sb.append(queue[i]);
                    if (i != rear) {
                        sb.append(", ");
                    }
                }
                sb.append(" ]");
                return sb.toString();
            }
        }

    }

    public static void main(String[] args) {
        Queue queue = new Main().new Queue();
        queue.front();
        queue.rear();
        queue.dequeue();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        System.out.println(queue);
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue);
        System.out.println(queue.dequeue());
        queue.enqueue(5);
        queue.enqueue(6);
        queue.enqueue(7);
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.front());
        System.out.println(queue.rear());
        System.out.println(queue.size());
    }
}
