class Solution:
    def getSum(self, a: int, b: int) -> int:
        mask = 0xFFFFFFFF  # 32 bits of 1s

        while b != 0:
            carry = ((a & b) << 1) & mask  # keep within 32 bits
            a     = (a ^ b)        & mask  # keep within 32 bits
            b     = carry

        # If a is a negative number (bit 31 is set)
        # convert from 32-bit back to Python negative int
        if a > 0x7FFFFFFF:
            a = ~(a ^ mask)

        return a