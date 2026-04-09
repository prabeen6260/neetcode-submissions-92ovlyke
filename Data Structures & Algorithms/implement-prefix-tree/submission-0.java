class PrefixTree {
    class TrieNode{
        TrieNode[] children;
        boolean isEndOfWord;
        TrieNode(){
            children = new TrieNode[26];
            isEndOfWord=false;
        }
    }
    TrieNode root;
    public PrefixTree() {
         root=new TrieNode();
    }

    public void insert(String word) {
        TrieNode current=root;
        for(char c: word.toCharArray()){
            int index =c-'a';
            if(current.children[index]==null){
                current.children[index]=new TrieNode();
            }
            current=current.children[index];
        }
        current.isEndOfWord=true;
    }

    public boolean search(String word) {
        TrieNode node = endWord(word);
        return node.isEndOfWord;

    }

    public boolean startsWith(String prefix) {
        TrieNode node = endWord(prefix);
        return node!=null;

    }
    private TrieNode endWord(String word){
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
