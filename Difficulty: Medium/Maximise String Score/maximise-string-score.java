import java.util.*;

class Solution {
    public int maxScore(String s, char[][] jumps) {
        int n = s.length();
        if (n == 0) return 0;

        // -------- prefix sum of ASCII values --------
        long[] psums = new long[n + 1];
        for (int i = 0; i < n; i++) {
            psums[i + 1] = psums[i] + (int) s.charAt(i);
        }

        // -------- per-character prefix count --------
        Set<Character> unique = new HashSet<>();
        for (char c : s.toCharArray()) unique.add(c);

        Map<Character, long[]> charPrefix = new HashMap<>();
        Map<Character, Integer> ordMap = new HashMap<>();

        for (char c : unique) ordMap.put(c, (int) c);

        for (char ch : unique) {
            long[] arr = new long[n + 1];
            int targetOrd = ordMap.get(ch);

            for (int i = 0; i < n; i++) {
                arr[i + 1] = arr[i] + (s.charAt(i) == ch ? 1 : 0);
            }
            charPrefix.put(ch, arr);
        }

        // -------- build jump map --------
        Map<Character, Set<Character>> jumpMap = new HashMap<>();
        for (char[] jp : jumps) {
            jumpMap.computeIfAbsent(jp[0], k -> new HashSet<>()).add(jp[1]);
        }

        long[] dp = new long[n + 1];

        // best_val map
        Map<Character, Long> bestVal = new HashMap<>();
        for (char c : unique) bestVal.put(c, Long.MIN_VALUE);

        // -------- main logic (reverse DP) --------
        for (int pos = n - 1; pos >= 0; pos--) {

            char ch = s.charAt(pos);
            int chOrd = ordMap.get(ch);

            long maxScore = 0;

            // chars to check = same + jump allowed
            Set<Character> charsToCheck = new HashSet<>();
            charsToCheck.add(ch);
            if (jumpMap.containsKey(ch)) charsToCheck.addAll(jumpMap.get(ch));

            long baseSum = psums[pos];

            for (char target : charsToCheck) {
                long best = bestVal.getOrDefault(target, Long.MIN_VALUE);
                if (best == Long.MIN_VALUE) continue;

                long[] targetPref = charPrefix.get(target);
                int targetOrd = ordMap.get(target);
                long baseCount = targetPref[pos];

                long score = best + baseCount * targetOrd - baseSum;
                if (score > maxScore) maxScore = score;
            }

            dp[pos] = maxScore;

            // update bestVal for character ch
            long[] arr = charPrefix.get(ch);
            long val = psums[pos + 1] + dp[pos] - arr[pos + 1] * chOrd;

            if (val > bestVal.get(ch)) {
                bestVal.put(ch, val);
            }
        }

        return (int) dp[0];
    }
}