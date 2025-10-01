class Solution {
    public static ArrayList<ArrayList<Integer>> uniquePerms(int[] arr) {
        // code here
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        Arrays.sort(arr);  // sort to handle duplicates
        boolean[] used = new boolean[arr.length];
        backtrack(arr, new ArrayList<>(), used, ans);
        return ans;
    }
    
    private static void backtrack(int[] arr, ArrayList<Integer> curr,
                                  boolean[] used, ArrayList<ArrayList<Integer>> ans) {
        if (curr.size() == arr.length) {
            ans.add(new ArrayList<>(curr));
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if (used[i]) continue; // already taken

            // skip duplicates
            if (i > 0 && arr[i] == arr[i - 1] && !used[i - 1]) continue;

            used[i] = true;
            curr.add(arr[i]);

            backtrack(arr, curr, used, ans);

            curr.remove(curr.size() - 1);
            used[i] = false;
        }
    }
};