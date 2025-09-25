class Solution {
    public ArrayList<String> generateBinary(int n) {
        ArrayList<String> list = new ArrayList<>();
        for(int i = 1; i <= n; i++) {
            String binary = Integer.toBinaryString(i);
            list.add(binary);
        }
        return list;
    }
    
}