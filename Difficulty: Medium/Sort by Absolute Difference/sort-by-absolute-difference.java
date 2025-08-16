import java.util.*;

class Solution {
    public void rearrange(int[] arr, int x) {
        // code here
        Integer [] nums = Arrays.stream(arr).boxed().toArray(Integer[] :: new);
        
        Arrays.sort(nums , Comparator.comparingDouble(a->Math.abs(x-a)));
        
        for (int i = 0; i < arr.length; i++) {
            arr[i] = nums[i];
        }
    }
}
