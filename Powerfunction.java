public class Power {
    public double myPow(double x, int n) {
        // Base case
        if (n == 0) return 1.0;
        
        // Handle negative exponents
        long N = n; 
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }

        return fastPow(x, N);
    }

    private double fastPow(double x, long n) {
        if (n == 0) return 1.0;
        
        double half = fastPow(x, n / 2);
        
        if (n % 2 == 0) {
            return half * half; // Even case
        } else {
            return x * half * half; // Odd case
        }
    }
}
