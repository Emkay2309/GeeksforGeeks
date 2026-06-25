class Solution {
    public static ArrayList<Integer> increasingNumbers(int n) {
        ArrayList<Integer> result = new ArrayList<>();
        
        // If n > 10, no such number exists
        if (n > 10) {
            return result;
        }
        
        // For n = 1, we need to include 0
        if (n == 1) {
            for (int i = 0; i <= 9; i++) {
                result.add(i);
            }
            return result;
        }
        
        // For n > 1, we start from 1 (can't start with 0)
        for (int i = 1; i <= 9; i++) {
            generateNumbers(i, 1, i, n, result);
        }
        
        Collections.sort(result);
        return result;
    }
    
    private static void generateNumbers(int currentNum, int position, int lastDigit, int n, ArrayList<Integer> result) {
        // If we've built an n-digit number, add it to result
        if (position == n) {
            result.add(currentNum);
            return;
        }
        
        // Try adding digits greater than lastDigit
        for (int nextDigit = lastDigit + 1; nextDigit <= 9; nextDigit++) {
            int newNum = currentNum * 10 + nextDigit;
            generateNumbers(newNum, position + 1, nextDigit, n, result);
        }
    }
}