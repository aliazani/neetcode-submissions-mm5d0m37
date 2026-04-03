class Solution:
    def characterReplacement(self, s: str, k: int) -> int:
        # s: Only upper case chars
        # k: up to k chars and replace them with one char
        # length longest substring contains only one distinct char
        # which chars should I replace?
    
        res: int = 0
        char_set = set(s);

        # iterate over unique chars
        for c in char_set:
            count: int = 0
            left: int = 0

            # starting from right
            for right in range(len(s)):
                # if the right pointer is having the same char: count + 1
                if s[right] == c: count += 1
                
                # we have chars in between that are not the same and greater than k to be replaced
                # invalid window
                if right-left+1 - count > k:
                    if s[left] == c: count -= 1
                    left += 1
                
                res = max(res, right-left + 1)

        return res