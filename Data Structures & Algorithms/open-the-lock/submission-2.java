class Solution {
    public int openLock(String[] deadends, String target) {
        Deque<String> q=new ArrayDeque<>();
        Set<String> visited = new HashSet<>();
        Set<String> deadSet = new HashSet<>(Arrays.asList(deadends));
        if(deadSet.contains("0000"))return -1;
        q.offer("0000");
        visited.add("0000");
        int turns=0;
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                String val = q.poll();
                if(val.equals(target))return turns;
                if(deadSet.contains(val))continue;
                for(String s:children(val)){
                    if(!visited.contains(s)){
                        q.offer(s);
                        visited.add(s);
                    }
                }
            }
            turns++;
        }
        return -1;
    }
    private List<String> children(String val){
        List<String> res= new ArrayList<>();
        for(int i=0;i<4;i++){
            char[] arr=val.toCharArray();
            arr[i]=(char)(((arr[i]-'0')+ 1)%10+'0');
            res.add(new String(arr));
            arr=val.toCharArray();
            arr[i]=(char)(((arr[i]-'0')-1 + 10)%10+'0');
            res.add(new String(arr));
        }
        return res;
    }
}