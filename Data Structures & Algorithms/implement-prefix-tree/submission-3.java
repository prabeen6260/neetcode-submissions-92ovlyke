class PrefixTree {
    class Trie{
        boolean isEndOfWord;
        Trie[] trieNode;
        Trie(){
            isEndOfWord=false;
            trieNode = new Trie[26];
        }
    }
    Trie root;
    public PrefixTree() {
         root=new Trie();
    }

    public void insert(String word) {
        Trie curr=root;
        for(char c:word.toCharArray()){
            int index=c-'a';
            if(curr.trieNode[index]==null){
                curr.trieNode[index]=new Trie();
            }
            curr=curr.trieNode[index];
        }
        curr.isEndOfWord=true;
    }

    public boolean search(String word) {
        Trie s=check(word);
        return s==null?false:s.isEndOfWord;
    }

    public boolean startsWith(String prefix) {
        Trie s=check(prefix);
        if(s==null)return false;
        return true;
    }
    private Trie check(String word){
        Trie curr=root;
        for(char c:word.toCharArray()){
            int index=c-'a';
            if(curr.trieNode[index]!=null){
                curr=curr.trieNode[index];
            }
            else return null;
        }
        return curr;
    }
}
