class Solution {
    public boolean palindromePair(String[] arr) {
        int N = arr.length;
         if (N == 1) {
            return false;
        }
        Arrays.sort(arr, new Comparator<String>(){
            @Override
            public int compare(String string1, String string2) {
                return string1.length() - string2.length();
            }
        });
        Trie root = new Trie();
        Trie reverse = new Trie();
        for (String word : arr) {
            if (searchTrie(root, reverse, word)) {
                return true;
            }
            insertTrie(root, reverse, word);
        }
        return false;
    }

    private  void insertTrie(Trie root, Trie reverse, String word) {
        Trie current = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (current.children[ch - 'a'] == null) {
                current.children[ch - 'a'] = new Trie();
            }
            current = current.children[ch - 'a'];
        }
        current.isWord = true;
        current = reverse;
        for (int i = word.length() - 1; i >= 0; i--) {
            char ch = word.charAt(i);
            if (current.children[ch - 'a'] == null) {
                current.children[ch - 'a'] = new Trie();
            }
            current = current.children[ch - 'a'];
        }
        current.isWord = true;
    }

    private  boolean searchTrie(Trie root, Trie reverse, String word) {
        Trie current = reverse;
        int i = 0;
        for (; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (current.children[ch - 'a'] == null) {
                break;
            }
            current = current.children[ch - 'a'];
        }
        if (current.isWord && i != 0 && isPalindrome(word, i, word.length() - 1)) {
            return true;
        }
        current = root;
        for (i = word.length() - 1; i >= 0; i--) {
            char ch = word.charAt(i);
            if (current.children[ch - 'a'] == null) {
                break;
            }
            current = current.children[ch - 'a'];
        }
        return current.isWord && i != word.length() - 1 && isPalindrome(word, 0, i);
    }

    private  boolean isPalindrome(String word, int start, int end) {
        while (start < end) {
            if (word.charAt(start) != word.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
class Trie {
    boolean isWord;
    Trie[] children;
    public Trie() {
        this.isWord = false;
        this.children = new Trie[26];
    }
}