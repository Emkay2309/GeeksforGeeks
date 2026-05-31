class Solution {
    static boolean isPrime(int n) {
        if(n <= 1) return false;
        if(n <= 3) return true;
        if(n%2==0 || n%3==0) return false;
        
        // Check using 6k ± 1 pattern: all primes > 3 are of form 6k±1
        // Check up to sqrt(n) by using i * i <= n (avoids sqrt() call)
        for (int i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) {
                return false;
            }
        }
        
        return true;
    }
}