class WordDictionary {
    class TrieNode{
        TrieNode[] children;
        boolean isEndOfWord;
        TrieNode(){
            children=new TrieNode[26];
            isEndOfWord=false;
        }
    }
    TrieNode root;
    public WordDictionary() {
        root=new TrieNode();
    }

    public void addWord(String word) {
        TrieNode current =root;
        for(char c:word.toCharArray()){
            int index=c-'a';
            if(current.children[index]==null){
                current.children[index]=new TrieNode();
            }
            current=current.children[index];
        }
        current.isEndOfWord=true;
    }

    public boolean search(String word) {
        TrieNode current=root;
        return dfs(word,0,current);
    }
    private boolean dfs(String word,int index, TrieNode current){
        if(index==word.length()){
            return current.isEndOfWord;
        }
        char c=word.charAt(index);
        if(c=='.'){
            for(TrieNode child:current.children){
                if(child!=null){
                    if(dfs(word,index+1,child)){
                        return true;
                        }
                }
            }
            return false;
        }
        else{
            int i=c-'a';
            if(current.children[i]==null){
                return false;
            }
            return dfs(word,index+1,current.children[i]);
        }
    }
}
