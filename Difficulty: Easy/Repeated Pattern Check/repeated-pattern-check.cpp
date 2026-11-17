class Solution {
  public:
    virtual bool findPattern(string& s){
      int count=0;
      int n=s.size();

      int i=0;
      while(i<n){
       while(i<n && s[i]=='x') { count++; i++; }

       while(i<n && s[i]=='y') { 
         count--; i++; 
         if(count<0) return false;  
       }

       if(count) return false;

      }


      return count==0;
    }
};