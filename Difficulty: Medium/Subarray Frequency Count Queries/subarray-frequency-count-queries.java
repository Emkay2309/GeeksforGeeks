class Solution {
    public ArrayList<Integer> freqInRange(int[] arr, int[][] queries) {
        int n = arr.length;
        
        // Store positions of each value
        HashMap<Integer, ArrayList<Integer>> positions = new HashMap<>();
        
        for (int i = 0; i < n; i++) {
            positions.computeIfAbsent(arr[i], k -> new ArrayList<>()).add(i);
        }
        
        ArrayList<Integer> ans = new ArrayList<>();
        for (int[] q : queries) {
            int l = q[0];
            int r = q[1];
            int val = q[2];
            
            if (!positions.containsKey(val)) {
                ans.add(0);
                continue;
            }
            
            ArrayList<Integer> pos = positions.get(val);
            // Binary search for count of positions in [l, r]
            int left = lowerBound(pos, l);
            int right = upperBound(pos, r);
            ans.add(right - left);
        }
        return ans;
    }
    
    private int lowerBound(ArrayList<Integer> list, int target) {
        int left = 0, right = list.size();
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid) < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
    
    private int upperBound(ArrayList<Integer> list, int target) {
        int left = 0, right = list.size();
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid) <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}