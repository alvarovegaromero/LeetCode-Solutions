//https://leetcode.com/problems/design-add-and-search-words-data-structure

class TrieNode {
    public HashMap<Character, TrieNode> children;
    public boolean isWord = false;

    public TrieNode() {
        children = new HashMap<>();
    }
}

class WordDictionary {
    private TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode currentNode = root;

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            currentNode = currentNode.children.computeIfAbsent(c, k -> new TrieNode());
        }
        currentNode.isWord = true; 
    }
    
    public boolean search(String word) {
        return searchHelper(word, 0, root);
    }

    private boolean searchHelper(String word, int index, TrieNode node) {
        if (index == word.length())
            return node.isWord;
        
        char c = word.charAt(index);
        if (c == '.') {
            for (TrieNode child : node.children.values()) {
                if (searchHelper(word, index + 1, child)) {
                    return true;
                }
            }
            return false;
        } else {
            TrieNode next = node.children.get(c);
            if (next == null)
                return false;
        
            return searchHelper(word, index + 1, next);
        }
    }
}