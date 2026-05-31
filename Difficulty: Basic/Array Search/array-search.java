class Solution {
    public int search(int arr[], int x) {
        return java.util.stream.IntStream.range(0, arr.length)
            .filter(i -> arr[i] == x)
            .findFirst()
            .orElse(-1);
    }
}