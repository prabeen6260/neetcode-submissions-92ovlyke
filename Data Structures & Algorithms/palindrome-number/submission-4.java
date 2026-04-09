class Solution {
    public boolean isPalindrome(int x) {
        if(x<0)return false;
        if(x==0)return true;
        if(x%10==0)return false;
        int reverse=0;
        //int org=x;
        while(reverse<x){
            int mod=x%10;
            x=x/10;
            reverse=(reverse*10)+mod;
        }
        if(x==reverse || x==reverse/10)return true;
        return false;
        
    }
}