// User function Template for Java

class Solution {
    // Function to find common elements in three arrays.
    public List<Integer> commonElements(List<Integer> arr1, List<Integer> arr2,
                                        List<Integer> arr3) {
        // Code Here
        int i = 0, j = 0, k = 0;
        int n1 = arr1.size();
        int n2 = arr2.size();
        int n3 = arr3.size();
        
        List<Integer> list = new ArrayList<>();

        while (i < n1 && j < n2 && k < n3) {

            int a = arr1.get(i);
            int b = arr2.get(j);
            int c = arr3.get(k);

            if (a == b && b == c) {

                // add only if not duplicate in result
                if (list.isEmpty() || list.get(list.size() - 1) != a) {
                    list.add(a);
                }

                i++; j++; k++;
            }
            else if (a < b) {
                i++;
            }
            else if (b < c) {
                j++;
            }
            else {
                k++;
            }
        }

        if (list.isEmpty()) {
            list.add(-1);
        }

        return list;
    }
}