class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        # m rows x n columns
        row = [1] * n  # creating a row

        # iterating through all rows
        for i in range(m-1):
            new_row = [1] * n
            # iterating through cols[n-2] till the first col
            for j in range(n-2, -1, -1):
                new_row[j] = new_row[j+1] + row[j]
            row = new_row

        return row[0]