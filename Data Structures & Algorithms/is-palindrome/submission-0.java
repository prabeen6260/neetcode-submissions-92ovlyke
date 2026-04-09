class Solution {
    public boolean isPalindrome(String s) {
        int n = s.length();
        int l=0;
        int r=n-1;
        char[] newS =s.toCharArray();
        while(l<r){
            while(!Character.isLetterOrDigit(newS[l]) && l<r){
                l++;
            }
            while(!Character.isLetterOrDigit(newS[r]) && l<r){
                r--;
            }
            if(Character.toLowerCase(newS[l])!=Character.toLowerCase(newS[r])){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
