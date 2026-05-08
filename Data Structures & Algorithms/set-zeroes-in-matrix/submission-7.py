class Solution:
    def setZeroes(self, matrix: List[List[int]]) -> None:
        rows: int = len(matrix)
        cols: int = len(matrix[0])
        
        col0: bool = False

        # step 1 checking the rows and cols
        for r in range(rows):
            if matrix[r][0] == 0: col0 = True
            for c in range(1, cols):
                if matrix[r][c] == 0:
                    matrix[r][0] = 0
                    matrix[0][c] = 0

        # filling out zeros
        for r in range(rows-1, 0, -1):
            for c in range(cols-1, 0, -1):
                if matrix[r][0] == 0 or matrix[0][c] == 0:
                    matrix[r][c] = 0
        
        # checking the first row
        if matrix[0][0] == 0:
            for c in range(cols):
                matrix[0][c] = 0
        
        # checking the first col
        if col0:
            for r in range(rows):
                matrix[r][0] = 0
        

        


            

