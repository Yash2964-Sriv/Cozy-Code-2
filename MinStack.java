/**
 * Basic DSA Problems - One Fundamental Stack Question
 * Simple and essential DSA problem for beginners
 */
public class MinStack {
    
    // Problem 1: Min Stack
    // Design a stack that supports push, pop, top, and retrieving the minimum element in O(1) time.
    //
    // Approach:
    // - Maintain two stacks: one for values and one for current minimums.
    
    public static class MinStack {
        private int[] values;
        private int[] mins;
        private int size;
        
        public MinStack() {
            this.values = new int[16];
            this.mins = new int[16];
            this.size = 0;
        }
        
        public void push(int val) {
            ensureCapacity(size + 1);
            values[size] = val;
            mins[size] = (size == 0) ? val : Math.min(mins[size - 1], val);
            size++;
        }
        
        public Integer pop() {
            if (size == 0) return null;
            int v = values[size - 1];
            size--;
            return v;
        }
        
        public Integer top() {
            if (size == 0) return null;
            return values[size - 1];
        }
        
        public Integer getMin() {
            if (size == 0) return null;
            return mins[size - 1];
        }
        
        private void ensureCapacity(int needed) {
            if (needed <= values.length) return;
            int newCap = values.length * 2;
            while (newCap < needed) newCap *= 2;
            
            int[] nv = new int[newCap];
            int[] nm = new int[newCap];
            System.arraycopy(values, 0, nv, 0, size);
            System.arraycopy(mins, 0, nm, 0, size);
            values = nv;
            mins = nm;
        }
        
        public int size() {
            return size;
        }
    }
    
    // Test cases
    public static void main(String[] args) {
        System.out.println("=".repeat(60));
        System.out.println("Problem 1: Min Stack");
        System.out.println("=".repeat(60));
        
        MinStack st = new MinStack();
        System.out.println("push(-2), push(0), push(-3)");
        st.push(-2);
        st.push(0);
        st.push(-3);
        System.out.println("min: " + st.getMin()); // -3
        System.out.println("pop: " + st.pop());    // -3
        System.out.println("top: " + st.top());    // 0
        System.out.println("min: " + st.getMin()); // -2
        
        System.out.println("\nEmpty checks");
        MinStack empty = new MinStack();
        System.out.println("top: " + empty.top());
        System.out.println("min: " + empty.getMin());
        System.out.println("pop: " + empty.pop());
    }
}

