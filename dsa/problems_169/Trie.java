class TrieNode {
    private TrieNode[] children;
    private boolean isEndOfWord;

    public TrieNode() {
        this.children = new TrieNode[26];
        this.isEndOfWord = false;
    }

    public boolean containsKey(char ch) {
        return children[ch - 'a'] != null;
    }

    public TrieNode get(char ch) {
        return children[ch - 'a'];
    }

    public void put(char ch, TrieNode node) {
        children[ch - 'a'] = node;
    } 

    public void setEnd() {
        isEndOfWord = true;
    }

    public boolean isEnd() {
        return isEndOfWord;
    }
}

class Trie {

    private TrieNode root;

    public Trie() {
        root = new TrieNode();
        
    }
    
    public void insert(String word) {
        TrieNode node = root;

        for (char ch: word.toCharArray()) {
            if (!node.containsKey(ch)) {
                node.put(ch, new TrieNode());
            }
            node = node.get(ch);
        }
        node.setEnd();
    }
    
    public boolean search(String word) {
        TrieNode node = searchPrefix(word);
        return node != null && node.isEnd();
        
    }

    private TrieNode searchPrefix(String prefix) {
        TrieNode node = root;

        for (char ch: prefix.toCharArray()) {
            if (!node.containsKey(ch)) {
                return null;
            }

            node = node.get(ch);
        }

        return node;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode node = searchPrefix(prefix);
        return node != null;
    }
}