class Solution {
    /**
     * Finds the K-th (1-indexed) symbol in the N-th row of the grammar table.
     * @param n The row number (1-indexed).
     * @param k The position in the row (1-indexed).
     * @return The symbol at the specified position (0 or 1).
     */
    public int kthGrammar(int n, int k) {
        // Base case: The first row always has 0 at the first position.
        if (n == 1) {
            return 0;
        }
        
        // Calculate the midpoint of the current row.
        // The length of row n-1 is 2^(n-2), which is the midpoint for row n.
        int midpoint = (int) Math.pow(2, n - 2);
        
        // If k is in the first half of the current row:
        // The value is the same as the k-th value in the previous row.
        if (k <= midpoint) {
            return kthGrammar(n - 1, k);
        } 
        // If k is in the second half of the current row:
        // The value is the bitwise inversion (XOR 1) of the corresponding value 
        // in the first half of the previous row (adjust k for the new index).
        else {
            return 1 ^ kthGrammar(n - 1, k - midpoint);
        }
    }
}
