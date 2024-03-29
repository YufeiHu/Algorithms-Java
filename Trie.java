class TrieNode {
    public Map<Character, TrieNode> children;
    public boolean isEnd;
    
    public TrieNode() {
        this.children = new HashMap<>();
        this.isEnd = false;
    }
}

class WordDictionary {
    private TrieNode trie;

    public WordDictionary() {
        this.trie = new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode node = this.trie;
        for (int i = 0; i < word.length(); i++) {
            Character c = word.charAt(i);
            node.children.putIfAbsent(c, new TrieNode());
            node = node.children.get(c);
        }
        node.isEnd = true;
    }
    
    private boolean searchHelp(String word, int i, TrieNode node) {
        if (i >= word.length()) {
            return node.isEnd;
        }
        
        Character c = word.charAt(i);
        if (!node.children.containsKey(c)) {
            return false;
        } else {
            return searchHelp(word, i + 1, node.children.get(c));
        }
    }
    
    public boolean search(String word) {
        return searchHelp(word, 0, this.trie);
    }
}
