class TrieNode:
    def __init__(self) -> None:
        self.children: dict[str, TrieNode] = {}
        self.isEnd: bool = False;

    def add_word(self, word: str) -> None:
        cur: TrieNode = self

        for c in word:
            if c not in cur.children:
                cur.children[c] = TrieNode()
            
            cur = cur.children[c]
        
        cur.isEnd = True

class Solution:
    def findWords(self, board: List[List[str]], words: List[str]) -> List[str]:
        root: TrieNode = TrieNode()
        for word in words: root.add_word(word)
        ROWS: int = len(board)
        COLS: int = len(board[0])
        visited: set[tuple[int, int]] = set()
        res: list[str] = []
        def dfs(row: int, col: int, node: TrieNode, word: str) -> None:
            if row < 0 or col < 0 \
            or row >= ROWS or col >= COLS \
            or (row, col) in visited or board[row][col] not in node.children: return

            ch: str = board[row][col]
            node = node.children[ch]
            visited.add((row, col))
            word += ch
            if node.isEnd: 
                res.append(word)
                node.isEnd = False

            dfs(row+1, col, node, word)
            dfs(row-1, col, node, word)
            dfs(row, col+1, node, word)
            dfs(row, col-1, node, word)

            visited.remove((row, col))


        for r in range(ROWS):
            for c in range(COLS):
                dfs(r, c, root, "");
        
        return res
