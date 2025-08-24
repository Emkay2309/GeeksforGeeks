class Solution {
    public void quickSort(int[] arr, int low, int high) {
        // code here
        if(low >= high) return;
        
        int pi = partition(arr , low , high);
        
        quickSort( arr , low , pi-1);
        quickSort( arr , pi+1 , high);
    }

    private int partition(int[] arr, int low, int high) {
        
        int n = arr.length;
        int pivot = arr[high];
        int pIndex = low;
        
        for(int i=low ; i<high ; i++) {
            if(arr[i] <= pivot) {
                swap(arr , i , pIndex);
                pIndex++;
            }
        }
        swap(arr , pIndex , high);
        return pIndex;
    }
    
    private void swap(int [] arr , int s , int e) {
        int temp = arr[s];
        arr[s] = arr[e];
        arr[e] = temp;
    }
}