class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        # o(m * 4^n) time and o(n) space
        # m is number of cells
        # n is size of the given word
        # 4 directions

        ROWS, COLS = len(board), len(board[0])
        path = set()

        def dfs(row, column, i):
            if i == len(word): return True

            elif row < 0 or column < 0 \
            or row >= ROWS or column >= COLS or \
            board[row][column] != word[i] or \
            (row, column) in path: return False

            path.add((row, column))
            res = dfs(row+1, column, i+1) or \
                  dfs(row-1, column, i+1) or  \
                  dfs(row, column+1, i+1) or \
                  dfs(row, column-1, i+1)
            
            path.remove((row, column))

            return res

        for r in range(ROWS):
            for c in range(COLS):
                if dfs(r, c, 0): return True

        return False