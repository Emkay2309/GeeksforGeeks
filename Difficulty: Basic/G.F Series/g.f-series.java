// User function Template for Java
class Solution {
    // recursive function
    static long solve(int N) {
        if (N == 1) return 0;
        if (N == 2) return 1;

        long a = solve(N - 2);
        long b = solve(N - 1);

        return a * a - b;
    }

    static void gfSeries(int N) {
        for (int i = 1; i <= N; i++) {
            System.out.print(solve(i) + " ");
        }
        System.out.println();
    }
}
