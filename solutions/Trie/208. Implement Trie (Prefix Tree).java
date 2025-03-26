//https://leetcode.com/problems/implement-trie-prefix-tree

// First approach - Use HashMap
// Time complexity: O(n) - Space complexity: O(n)
class Trie {
    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode currentNode = root;

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            currentNode = currentNode.children.computeIfAbsent(c, k -> new TrieNode());
        }
        currentNode.isWord = true;
    }
    
    public boolean search(String word) {
        TrieNode node = findNode(word);
        return node != null && node.isWord;
    }
    
    public boolean startsWith(String prefix) {
        return findNode(prefix) != null;
    }

    private TrieNode findNode(String prefix) {
        TrieNode currentNode = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            currentNode = currentNode.children.get(c);
            if (currentNode == null) {
                return null;
            }
        }
        return currentNode;
    }
}

class TrieNode {
    public HashMap<Character, TrieNode> children;
    public boolean isWord = false;

    public TrieNode() {
        children = new HashMap<>();
    }
}

// Second approach - Use array instead of HashMap as we have lowercase letters
// Time complexity: O(n) for insert, search and startsWith
// Space complexity: O(n)
class Trie {
    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode currentNode = root;

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int index = c - 'a';
            if (currentNode.children[index] == null)
                currentNode.children[index] = new TrieNode();
            
            currentNode = currentNode.children[index];
        }
        currentNode.isWord = true;
    }
    
    public boolean search(String word) {
        TrieNode node = findNode(word);
        return node != null && node.isWord;
    }
    
    public boolean startsWith(String prefix) {
        return findNode(prefix) != null;
    }

    private TrieNode findNode(String prefix) {
        TrieNode currentNode = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            int index = c - 'a'; 
            currentNode = currentNode.children[index];

            if (currentNode == null) 
                return null;
        }
        return currentNode;
    }
}

class TrieNode {
    public TrieNode[] children= new TrieNode[26];
    public boolean isWord = false;
}