
class TrieNode {
    Map<Character, TrieNode> children;
    boolean isEnd;

    public TrieNode() {
        children = new HashMap<>();
        isEnd = false;
    }

    public void addWord(String word) {
        TrieNode current = this;

        for (char c : word.toCharArray()) {
            if (!current.children.containsKey(c)) {
                current.children.put(c, new TrieNode());
            }
            current = current.children.get(c);
        }

        current.isEnd = true;
    }
}

class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = new TrieNode();
        int ROWS = board.length;
        int COLS = board[0].length;

        for (String word : words) {
            root.addWord(word);
        }

        Set<String> visited = new HashSet<>();
        List<String> res = new ArrayList<>();

        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                dfs(board, "", visited, res, i, j, root, ROWS, COLS);
            }
        }

        return res;
    }

    private void dfs(char[][] board, String word, Set<String> visited,
                     List<String> res, int row, int col,
                     TrieNode node, int ROWS, int COLS) {

        if (row < 0 || col < 0 || row >= ROWS || col >= COLS) {
            return;
        }

        String key = row + "," + col;
        if (visited.contains(key)) {
            return;
        }

        char c = board[row][col];
        if (!node.children.containsKey(c)) {
            return;
        }

        visited.add(key);
        node = node.children.get(c);
        word += c;

        if (node.isEnd) {
            res.add(word);
            node.isEnd = false;
        }

        dfs(board, word, visited, res, row + 1, col, node, ROWS, COLS);
        dfs(board, word, visited, res, row - 1, col, node, ROWS, COLS);
        dfs(board, word, visited, res, row, col + 1, node, ROWS, COLS);
        dfs(board, word, visited, res, row, col - 1, node, ROWS, COLS);

        visited.remove(key);
    }
}