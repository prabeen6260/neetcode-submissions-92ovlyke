class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        if(words.length==1)return true;
        int[] freq=new int[26];
        for(int i=0;i<order.length();i++){
            freq[order.charAt(i)-'a']=i;
        }
        for(int i=1;i<words.length;i++){
            String prev=words[i-1];
            String curr=words[i];
            for(int j=0;j<prev.length();j++){
                if(freq[prev.charAt(j)-'a']==freq[curr.charAt(j)-'a']){
                    if(curr.length()-1==j && curr.length()<prev.length())return false;
                    continue;
                }
                else if(freq[prev.charAt(j)-'a']>freq[curr.charAt(j)-'a']){
                    return false;
                }
                else break;
            }
        }
        return true;
    }
}