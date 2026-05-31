class Solution {
    public int firstSearch(int[] arr, int k) {
        // Code Here
        return java.util.stream.IntStream.range(0, arr.length)
            .filter(i -> arr[i] == k)
            .findFirst()
            .orElse(-1);
    }
}

