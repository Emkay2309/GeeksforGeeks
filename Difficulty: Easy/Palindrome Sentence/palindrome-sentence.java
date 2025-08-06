class Solution {
    public boolean isPalinSent(String s) {
        int i = 0;
        int j = s.length() - 1;

        while (i <= j) {
            // Move i forward if not alphanumeric
            while (i < j && !Character.isLetterOrDigit(s.charAt(i))) {
                i++;
            }

            // Move j backward if not alphanumeric
            while (i < j && !Character.isLetterOrDigit(s.charAt(j))) {
                j--;
            }

            // Compare lowercase versions
            if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) {
                return false;
            }

            i++;
            j--;
        }

        return true;
    }
}
