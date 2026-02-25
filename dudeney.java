/**
 * Basic DSA Problems - Dudeney Number
 * Simple and essential DSA problems for beginners
 */
import java.util.*;

public class dudeney {
    
    // Problem: Check if a Number is Dudeney Number
    // A Dudeney number is a perfect cube whose sum of digits equals its cube root.
    // Example: 512 -> sum of digits = 8, cube root = 8. So 512 is Dudeney.
    // Others: 0, 1, 17, 18, 26, 27, 4913...
    
    /**
     * Sum of digits of a number
     */
    public static int sumOfDigits(long n) {
        int sum = 0;
        n = Math.abs(n);
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }
    
    /**
     * Check if a number is perfect cube
     */
    public static boolean isPerfectCube(long n) {
        if (n < 0) return false;
        long cbrt = (long) Math.cbrt(n);
        return cbrt * cbrt * cbrt == n;
    }
    
    /**
     * Check if a number is Dudeney number
     * Time Complexity: O(1)
     * Space Complexity: O(1)
     */
    public static boolean isDudeneyNumber(long n) {
        if (n < 0) return false;
        if (!isPerfectCube(n)) return false;
        
        long cubeRoot = (long) Math.cbrt(n);
        return sumOfDigits(n) == cubeRoot;
    }
    
    /**
     * Find Dudeney numbers in a range
     */
    public static ArrayList<Long> getDudeneyNumbersInRange(long start, long end) {
        ArrayList<Long> result = new ArrayList<>();
        for (long num = start; num <= end; num++) {
            if (isDudeneyNumber(num)) result.add(num);
        }
        return result;
    }
    
    public static void main(String[] args) {
        System.out.println("=".repeat(60));
        System.out.println("Problem: Check if a Number is Dudeney Number");
        System.out.println("=".repeat(60));
        
        // Test 1: 512 (5+1+2=8, cube root=8)
        long n1 = 512;
        boolean r1 = isDudeneyNumber(n1);
        System.out.println("Number: " + n1 + " -> sum=" + sumOfDigits(n1) + ", cbrt=" + (long)Math.cbrt(n1));
        System.out.println("Is Dudeney: " + r1);
        
        // Test 2: 1 (1^3=1, sum=1)
        long n2 = 1;
        boolean r2 = isDudeneyNumber(n2);
        System.out.println("\nNumber: " + n2 + ". Is Dudeney: " + r2);
        
        // Test 3: 8 (2^3=8, sum=8 but cbrt=2, so not Dudeney)
        long n3 = 8;
        boolean r3 = isDudeneyNumber(n3);
        System.out.println("\nNumber: " + n3 + " -> sum=8, cbrt=2. Is Dudeney: " + r3);
        
        // Test 4: 27 (3^3=27, sum=9, 9!=3)
        long n4 = 27;
        boolean r4 = isDudeneyNumber(n4);
        System.out.println("\nNumber: " + n4 + " -> sum=9, cbrt=3. Is Dudeney: " + r4);
        
        // Test 5: 4913 (17^3, 4+9+1+3=17)
        long n5 = 4913;
        boolean r5 = isDudeneyNumber(n5);
        System.out.println("\nNumber: " + n5 + " -> sum=" + sumOfDigits(n5) + ", cbrt=17. Is Dudeney: " + r5);
        
        // Test 6: Dudeney numbers in range
        ArrayList<Long> dudeney = getDudeneyNumbersInRange(0, 10000);
        System.out.println("\nDudeney numbers in [0, 10000]: " + dudeney);
    }
}