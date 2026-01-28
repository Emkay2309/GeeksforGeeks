class Solution {
    public String firstNonRepeating(String s) {
        // code here
        StringBuilder sb=new StringBuilder(); 
        Map<Character,Integer> mp=new LinkedHashMap<>();
        for(int i=0;i<s.length();i++)
        {
            char ch=s.charAt(i);
            mp.put(ch,mp.getOrDefault(ch,0)+1);
            boolean isfound=false;
            for(Map.Entry<Character,Integer> entry:mp.entrySet())
            {
                if(!isfound && entry.getValue()==1)
                {
                    isfound=true;
                    sb.append(entry.getKey());
                }
            }
            if(!isfound)
            {
                sb.append("#");
            }
        }
        return sb.toString();
    }
}

