class Solution {

    public String encode(List<String> strs) {
        String ans=new String();
        for(String s:strs){
            ans+=s.length()+"#"+s;
        }
        return ans;
    }

    public List<String> decode(String str) {
        List<String> ans = new ArrayList<>();
        int i=0;
        int j=0;
        while(i<str.length()){
            while(str.charAt(j)!='#'){
                j++;
            }
            int len=Integer.parseInt(str.substring(i,j));
            String s=str.substring(j+1,j+1+len);
            ans.add(s);
            i=j+1+len;
            j=i;
        }
        return ans;
    }
}
