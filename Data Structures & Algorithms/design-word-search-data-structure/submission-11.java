class TrieNode {
    Map<Character, TrieNode> children;
    private boolean isEndOfWord;

    public TrieNode() {
        children = new HashMap();
        isEndOfWord = false;
    }
}

class WordDictionary {
    private TrieNode root;


    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode current = root;

        for (char c : word.toCharArray()) {
            if (!current.children.containsKey(c))
                current.children.put(c, new TrieNode());
            current = current.children.get(c);
        }

        current.isEndOfWord = true;
    }

    public boolean search(String word) {
        return dfs(root, 0, word);
    }

    private boolean dfs(TrieNode node, int index, String word) {
        TrieNode current = node;

        for (int i=index; i < word.length(); i++) {
            char c = word.charAt(i);

            if (c == '.') {
                for (TrieNode child: current.children.values()) {
                    if (dfs(child, i+1, word)) return true;
                }
                return false;
            }
            else {
                if (!current.children.containsKey(c)) return false;
                current = current.children.get(c);
            }

        }
        return current.isEndOfWord;
    }
}
