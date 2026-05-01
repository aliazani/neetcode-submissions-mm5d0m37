class Solution:
    def numDecodings(self, s: str) -> int:
        prev2: int = 1
        prev1: int = 1 if s[0] != '0' else 0

        for i in range(2, len(s) + 1):
            curr: int = 0
            if s[i-1] != '0':
                curr += prev1
            if 10 <= int(s[i-2:i]) <= 26:
                curr += prev2
            prev2, prev1 = prev1, curr

        return prev1