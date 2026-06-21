import java.util.*;
class LeaersInArray {
    public List<Integer> leaders(int[] nums) {
        ArrayList<Integer> leaders = new ArrayList<>();
        int max = nums[nums.length-1];
        for(int i=nums.length-1 ; i>=0 ; i--){
            if(nums[i]>max || i==nums.length-1 ) {
                leaders.add(nums[i]);
                max=nums[i];
            }
            
        }
        Collections.reverse(leaders);
        return leaders;


        
    }
}