class Solution {
    countAtMostK(arr, k) {
        // code here
        const map = new Map();
        let j = 0, ans = 0
        
        for(let i = 0; i < arr.length; i++){
            map.set(arr[i], 1 + (map.get(arr[i]) ?? 0))
            while(map.size > k){
                const el = map.get(arr[j])
                if(el == 1){
                    map.delete(arr[j])
                }else{
                    map.set(arr[j], el - 1)
                }
                j++
            }
            ans+= (i - j + 1)
        }
        
        return ans
    }
}