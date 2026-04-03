class Solution:
    def characterReplacement(self, s: str, k: int) -> int:
        # s: Only upper case chars
        # k: up to k chars and replace them with one char
        # length longest substring contains only one distinct char
        # which chars should I replace?
    
        res: int = 0
        char_set = set(s);

        for c in char_set:
            count: int = 0
            left: int = 0

            for right in range(len(s)):
                if s[right] == c:
                    count += 1
                
                while (right-left+1) - count > k:
                    if s[left] == c: count -= 1
                    left += 1
                
                res = max(res, right-left + 1)

        return res