class PrefixTree {
    class TrieNode{
        boolean isEndOfWord;
        TrieNode[] children;
        TrieNode(){
            isEndOfWord=false;
            children = new TrieNode[26];
        }
    }
    TrieNode root;
    public PrefixTree() {
        root=new TrieNode();
    }

    public void insert(String word) {
        TrieNode current = root;
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
        TrieNode node = traverse(word);
        return node.isEndOfWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode node = traverse(prefix);
        if(node==null)return false;
        return true;
    }
    private TrieNode traverse(String word){
        TrieNode current=root;
        for(char c:word.toCharArray()){
            int index=c-'a';
            if(current.children[index]==null){
                return null;
            }
            current=current.children[index];
        }
        return current;
    }
}
