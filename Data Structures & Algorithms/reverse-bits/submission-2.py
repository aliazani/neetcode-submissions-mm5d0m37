class Solution:
    def reverseBits(self, n: int) -> int:
        res: int = 0

        for i in range(32):
            bit: int = (n>>i) & 1

            res = res | bit<<(31-i)

        return res