class Solution {
    public boolean isPalindrome(String s) {
        int n=s.length();
        int l=0;
        int r=n-1;
        String ns=s.toLowerCase();
        while(l<r){
            if(!Character.isLetterOrDigit(ns.charAt(l))){
                l++;
                continue;
            }
            else if(!Character.isLetterOrDigit(ns.charAt(r))){
                r--;
                continue;
            }
            if(ns.charAt(l)!=(ns.charAt(r)))return false;
            l++;
            r--;
        }
        return true;
    }
}
