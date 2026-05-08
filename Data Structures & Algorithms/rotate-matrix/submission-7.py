class Solution:
    def rotate(self, matrix: List[List[int]]) -> None:
        left: int = 0
        right: int = len(matrix) - 1

        while left <= right:
            # because we have square matrix
            top: int = left
            bottom: int = right
            for i in range(right - left):
                # save top left value
                top_left: int = matrix[top][left+i]

                # replace top left with bottom left => which will be updated by bottom - 1
                matrix[top][left+i] = matrix[bottom-i][left]
                
                # replace bottom left with bottom right => right will be update by right - 1
                matrix[bottom-i][left] = matrix[bottom][right-i]
        
                # repalce matrix bottom right with top left
                matrix[bottom][right-i] = matrix[top+i][right]

                # replace matrix top right with top left
                matrix[top+i][right] = top_left
            left += 1
            right -= 1