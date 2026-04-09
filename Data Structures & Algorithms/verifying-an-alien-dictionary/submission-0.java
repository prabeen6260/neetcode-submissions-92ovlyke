class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        if(words.length==1)return true;
        Map<Character,Integer> map = new HashMap<>();
        for(int i=0;i<order.length();i++){
            map.put(order.charAt(i),i);
        }
        for(int i=1;i<words.length;i++){
            String prev=words[i-1];
            String curr=words[i];
            for(int j=0;j<prev.length();j++){
                if(map.get(prev.charAt(j))==map.get(curr.charAt(j))){
                    if(curr.length()-1==j && curr.length()<prev.length())return false;
                    continue;
                }
                else if(map.get(prev.charAt(j))>map.get(curr.charAt(j))){
                    return false;
                }
                else break;
            }
        }
        return true;
    }
}