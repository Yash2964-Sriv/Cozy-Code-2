
import java.util.*;

public class LinearSearchRecursion {
    public static void main(String [] args){
        int [] arr = {2,3,55,3232,32,54,121,664,32656,226,56,23,23,56,34,76};
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the element you want to search: ");
        int ele=sc.nextInt();
        System.out.println(exists(arr,ele,0));
    }

    public static boolean exists(int []arr,int ele, int ix){
        if(ix==arr.length) return false;
        else if(arr[ix]==ele) return true;
        return exists(arr,ele,ix+1);
    }
    
} 
