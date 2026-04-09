class WordDictionary {
    class TrieNode{
        TrieNode[] children;
        boolean isEnd;
        TrieNode(){
            children = new TrieNode[26];
            isEnd=false;
        }
    }
    TrieNode root;
    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode current=root;
        for(char c:word.toCharArray()){
            int index=c-'a';
            if(current.children[index]==null){
                current.children[index]=new TrieNode();
            }
            current=current.children[index];
        }
        current.isEnd=true;
    }

    public boolean search(String word) {
        TrieNode current=root;
        return dfs(word.toCharArray(),0,current);
    }
    private boolean dfs(char[] word,int i,TrieNode current){
        if(word.length==i){
            return current.isEnd;
        }
        char c=word[i];
        if(c=='.'){
            for(TrieNode n:current.children){
                if(n!=null && dfs(word,i+1,n)){
                    return true;
                }
            }
            return false;
        }
        else{
            int index=c-'a';
            if(current.children[index]==null){
                return false;
            }
            current=current.children[index];
            return dfs(word,i+1,current);
        }
    }
}
