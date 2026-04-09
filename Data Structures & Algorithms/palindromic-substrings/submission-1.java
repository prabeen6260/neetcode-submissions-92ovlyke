class Solution {
    public int countSubstrings(String s) {
        int n=s.length();
        int ans=0;
        for(int i=0;i<n;i++){
            //for odd length
            int l=i;
            int r=i;
            while(l>=0 && r<n && s.charAt(l)==s.charAt(r)){
                ans++;
                l--;
                r++;
            }
            //for even length
            l=i;
            r=i+1;
            while(l>=0 && r<n && s.charAt(l)==s.charAt(r)){
                l--;
                r++;
                ans++;
            }
        }
        return ans;
    }
}
