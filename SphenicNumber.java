/**
 * Basic DSA Problems - Sphenic Number
 * Simple and essential DSA problems for beginners
 */
import java.util.*;

public class SphenicNumber {
    
    // Problem: Check if a Number is Sphenic Number
    // A Sphenic number is the product of exactly three distinct primes.
    // Example: 30 = 2 * 3 * 5; 42 = 2 * 3 * 7; 66 = 2 * 3 * 11
    
    /**
     * Check if n is prime
     */
    public static boolean isPrime(int n) {
        if (n < 2) return false;
        if (n == 2) return true;
        if (n % 2 == 0) return false;
        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0) return false;
        }
        return true;
    }
    
    /**
     * Check if a number is Sphenic (product of exactly 3 distinct primes)
     * Time Complexity: O(√n)
     * Space Complexity: O(1)
     */
    public static boolean isSphenicNumber(int n) {
        if (n < 2) return false;
        
        ArrayList<Integer> primes = new ArrayList<>();
        int temp = n;
        
        for (int p = 2; p * p <= temp && primes.size() < 4; p++) {
            if (!isPrime(p)) continue;
            while (temp % p == 0) {
                if (primes.size() >= 3) return false;
                if (primes.isEmpty() || primes.get(primes.size() - 1) != p) {
                    primes.add(p);
                } else {
                    return false;  // Repeated prime factor
                }
                temp /= p;
            }
        }
        
        if (temp > 1) {
            if (!isPrime(temp) || primes.size() >= 3) return false;
            primes.add(temp);
        }
        
        return primes.size() == 3;
    }
    
    /**
     * Get the three distinct prime factors (if Sphenic). Returns int[3] or null.
     */
    public static int[] getSphenicFactors(int n) {
        if (!isSphenicNumber(n)) return null;
        
        int[] factors = new int[3];
        int idx = 0;
        int temp = n;
        for (int p = 2; p * p <= temp && idx < 3; p++) {
            if (!isPrime(p) || temp % p != 0) continue;
            factors[idx++] = p;
            temp /= p;
        }
        if (temp > 1) factors[idx] = temp;
        return factors;
    }
    
    /**
     * Find Sphenic numbers in a range
     */
    public static ArrayList<Integer> getSphenicNumbersInRange(int start, int end) {
        ArrayList<Integer> result = new ArrayList<>();
        for (int num = start; num <= end; num++) {
            if (isSphenicNumber(num)) result.add(num);
        }
        return result;
    }
    
    public static void main(String[] args) {
        System.out.println("=".repeat(60));
        System.out.println("Problem: Check if a Number is Sphenic Number");
        System.out.println("=".repeat(60));
        
        // Test 1: 30 = 2 * 3 * 5
        int n1 = 30;
        boolean r1 = isSphenicNumber(n1);
        int[] f1 = getSphenicFactors(n1);
        System.out.println("Number: " + n1 + " = " + f1[0] + " * " + f1[1] + " * " + f1[2]);
        System.out.println("Is Sphenic: " + r1);
        
        // Test 2: 42 = 2 * 3 * 7
        int n2 = 42;
        boolean r2 = isSphenicNumber(n2);
        System.out.println("\nNumber: " + n2 + " = 2 * 3 * 7. Is Sphenic: " + r2);
        
        // Test 3: 8 = 2^3 (not Sphenic - repeated prime)
        int n3 = 8;
        boolean r3 = isSphenicNumber(n3);
        System.out.println("\nNumber: " + n3 + " (2^3). Is Sphenic: " + r3);
        
        // Test 4: 10 = 2 * 5 (only 2 primes)
        int n4 = 10;
        boolean r4 = isSphenicNumber(n4);
        System.out.println("\nNumber: " + n4 + " (2 primes). Is Sphenic: " + r4);
        
        // Test 5: 66 = 2 * 3 * 11
        int n5 = 66;
        boolean r5 = isSphenicNumber(n5);
        System.out.println("\nNumber: " + n5 + " = 2 * 3 * 11. Is Sphenic: " + r5);
        
        // Test 6: Sphenic numbers in range
        ArrayList<Integer> sphenic = getSphenicNumbersInRange(30, 70);
        System.out.println("\nSphenic numbers in [30, 70]: " + sphenic);
    }
}