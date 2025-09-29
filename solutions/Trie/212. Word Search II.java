//https://leetcode.com/problems/word-search-ii

// Approach - Backtracking + Trie
// Time complexity: O(m * n * 4^l) where m is number of rows, n is number of columns and l is the max length of words
// Space complexity: O(∑w + l), where ∑w = total chars in all words, l = max word length (recursion stack)
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

class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        Set<String> wordsFound = new HashSet<>();

        Trie trie = new Trie();

        for (String word : words)
            trie.insert(word);

        
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                dfs(board, i, j, trie.root, new StringBuilder(), wordsFound);
            } 
        }

        return new ArrayList<>(wordsFound);
    }

    private void dfs(char[][] board, int i, int j, TrieNode node,
                 StringBuilder path, Set<String> resultSet) {
        
        // if out of bounds, exit
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length)
            return;

        char c = board[i][j];

        // if visited or current word not found in trie, exit
        if (c == '#' || !node.children.containsKey(c))
            return;

        node = node.children.get(c);
        path.append(c);

        if (node.isWord) {
            resultSet.add(path.toString());
            node.isWord = false;
        }

        // mark as visited
        board[i][j] = '#';

        // visit neighbours
        dfs(board, i + 1, j, node, path, resultSet);
        dfs(board, i - 1, j, node, path, resultSet);
        dfs(board, i, j + 1, node, path, resultSet);
        dfs(board, i, j - 1, node, path, resultSet);

        // desmark as visited and go back
        board[i][j] = c;
        path.deleteCharAt(path.length() - 1);
    }
}