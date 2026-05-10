class Solution {
    static class Task {
        int a, b, diff;
        Task(int a, int b) {
            this.a = a;
            this.b = b;
            this.diff = a - b;
        }
    }
    public int maxProfit(int x, int y, int[] a, int[] b) {
      int n = a.length;
        List<Task> tasks = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            tasks.add(new Task(a[i], b[i]));
        }

        // Sort by absolute difference descending
        tasks.sort((t1, t2) -> Integer.compare(Math.abs(t2.diff), Math.abs(t1.diff)));

        int profit = 0;
        for (Task t : tasks) {
            if ((t.diff >= 0 && x > 0) || y == 0) {
                profit += t.a;
                x--;
            } else {
                profit += t.b;
                y--;
            }
        }
        return profit;
    }
}