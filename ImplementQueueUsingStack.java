/**
 * Basic DSA Problems - One Fundamental Queue/Stack Question
 * Simple and essential DSA problem for beginners
 */
public class ImplementQueueUsingStack {

    // Problem 1: Implement Queue using Stacks
    // Implement a queue using two stacks:
    // - push(x): Push element x to the back of queue.
    // - pop(): Removes the element from in front of queue and returns that element.
    // - peek(): Get the front element.
    // - empty(): Returns whether the queue is empty.

    static class MyQueue {
        private final java.util.Stack<Integer> inStack = new java.util.Stack<>();
        private final java.util.Stack<Integer> outStack = new java.util.Stack<>();

        public void push(int x) {
            inStack.push(x);
        }

        private void shiftIfNeeded() {
            if (outStack.isEmpty()) {
                while (!inStack.isEmpty()) {
                    outStack.push(inStack.pop());
                }
            }
        }

        public Integer pop() {
            shiftIfNeeded();
            if (outStack.isEmpty()) {
                return null;
            }
            return outStack.pop();
        }

        public Integer peek() {
            shiftIfNeeded();
            if (outStack.isEmpty()) {
                return null;
            }
            return outStack.peek();
        }

        public boolean empty() {
            return inStack.isEmpty() && outStack.isEmpty();
        }
    }

    // Test cases
    public static void main(String[] args) {
        System.out.println("=".repeat(60));
        System.out.println("Problem 1: Implement Queue using Stacks");
        System.out.println("=".repeat(60));

        MyQueue q = new MyQueue();
        System.out.println("empty -> " + q.empty());
        q.push(1);
        q.push(2);
        q.push(3);
        System.out.println("peek -> " + q.peek());
        System.out.println("pop -> " + q.pop());
        System.out.println("peek -> " + q.peek());
        System.out.println("pop -> " + q.pop());
        System.out.println("pop -> " + q.pop());
        System.out.println("pop (empty) -> " + q.pop());
        System.out.println("empty -> " + q.empty());
    }
}