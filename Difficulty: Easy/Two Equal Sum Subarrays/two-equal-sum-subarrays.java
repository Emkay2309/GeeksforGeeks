class Solution {
    public boolean canSplit(int arr[]) {
        // code here
        int total = Arrays.stream(arr).sum();
        int sum = 0;
        for(int curr : arr) {
            sum += curr;
            if(sum == total-sum)    return true;
        }
        return false;
    }
}