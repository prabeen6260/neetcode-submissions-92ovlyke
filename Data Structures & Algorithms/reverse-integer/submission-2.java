class Solution {
    public int reverse(int x) {
        int reverse=0;
        while(x!=0){
            int mod=x%10;
            int q=x/10;
            if (reverse > Integer.MAX_VALUE/10 || (reverse == Integer.MAX_VALUE/10 && mod > Integer.MAX_VALUE%10)) return 0;
            if (reverse < Integer.MIN_VALUE/10 || (reverse == Integer.MIN_VALUE/10 && mod < Integer.MIN_VALUE%10)) return 0;
            reverse= (reverse*10)+mod;
            x=q;
        }
        return reverse;
    }
}
