class Solution {
    public int sumDiffPairs(int[] arr, int K) {
        // code here
        int N = arr.length;
        int sum = 0;
        Arrays.sort(arr);
        for (int i = N - 1; i > 0; i--)
        {
            if (arr[i] - arr[i - 1] < K)
            {
                sum += arr[i] + arr[i - 1];
                i--;
            }
        }
        return sum;
    }
}