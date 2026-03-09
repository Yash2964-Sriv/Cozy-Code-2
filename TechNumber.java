
/**
 * Basic DSA Problems - Tech Number
 * Simple and essential DSA problems for beginners
 */
import java.util.*;

public class TechNumber {
    
    // Problem: Check if a Number is Tech Number
    // A Tech number has even number of digits. When split into two equal halves,
    // the sum of those halves, when squared, equals the original number.
    // Example: 2025 -> 20 + 25 = 45, 45^2 = 2025
    
    /**
     * Count number of digits in a number
     * Time Complexity: O(log n)
     */
    public static int countDigits(int n) {
        if (n == 0) return 1;
        int count = 0;
        int num = Math.abs(n);
        while (num > 0) {
            count++;
            num /= 10;
        }
        return count;
    }
    
    /**
     * Check if a number is Tech number
     * Time Complexity: O(log n)
     * Space Complexity: O(1)
     */
    public static boolean isTechNumber(int n) {
        if (n < 0) return false;
        
        int digits = countDigits(n);
        if (digits % 2 != 0) return false;
        
        int half = digits / 2;
        int divisor = (int) Math.pow(10, half);
        
        int firstHalf = n / divisor;
        int secondHalf = n % divisor;
        
        int sum = firstHalf + secondHalf;
        return (long) sum * sum == n;
    }
    
    /**
     * Get the halves and sum for a Tech number
     * Returns int[3] = {firstHalf, secondHalf, sum} or null if not Tech
     */
    public static int[] getTechNumberSplit(int n) {
        if (!isTechNumber(n)) return null;
        
        int digits = countDigits(n);
        int half = digits / 2;
        int divisor = (int) Math.pow(10, half);
        
        int firstHalf = n / divisor;
        int secondHalf = n % divisor;
        int sum = firstHalf + secondHalf;
        
        return new int[] { firstHalf, secondHalf, sum };
    }
    
    /**
     * Find all Tech numbers in a given range
     */
    public static ArrayList<Integer> getTechNumbersInRange(int start, int end) {
        ArrayList<Integer> result = new ArrayList<>();
        for (int num = start; num <= end; num++) {
            if (isTechNumber(num)) {
                result.add(num);
            }
        }
        return result;
    }
    
    public static void main(String[] args) {
        System.out.println("=".repeat(60));
        System.out.println("Problem: Check if a Number is Tech Number");
        System.out.println("=".repeat(60));
        
        // Test 1: 2025 (20+25=45, 45^2=2025)
        int n1 = 2025;
        boolean r1 = isTechNumber(n1);
        int[] split1 = getTechNumberSplit(n1);
        System.out.println("Number: " + n1);
        System.out.println("Split: " + split1[0] + " + " + split1[1] + " = " + split1[2] + ", " + split1[2] + "^2 = " + n1);
        System.out.println("Is Tech number: " + r1);
        
        // Test 2: 81 (8+1=9, 9^2=81)
        int n2 = 81;
        boolean r2 = isTechNumber(n2);
        System.out.println("\nNumber: " + n2 + " -> 8+1=9, 9^2=81. Is Tech: " + r2);
        
        // Test 3: Not Tech (odd digits)
        int n3 = 123;
        boolean r3 = isTechNumber(n3);
        System.out.println("\nNumber: " + n3 + " (odd digits). Is Tech: " + r3);
        
        // Test 4: Not Tech (100 - 10+0=10, 10^2=100 - actually 100 IS tech!)
        int n4 = 100;
        boolean r4 = isTechNumber(n4);
        System.out.println("\nNumber: " + n4 + " -> 10+0=10, 10^2=100. Is Tech: " + r4);
        
        // Test 5: Tech numbers in range
        ArrayList<Integer> techNums = getTechNumbersInRange(10, 9999);
        System.out.println("\nTech numbers in [10, 9999]: " + techNums);
    }
}
