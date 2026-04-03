class Solution:
    def characterReplacement(self, s: str, k: int) -> int:
        chars_dict = {}
        res: int = 0
        # iterate over unique chars
        max_freq: int = 0
        left: int = 0

        # starting from right
        for right in range(len(s)):
            # if the right pointer is having the same char: count + 1
            chars_dict[s[right]] = chars_dict.get(s[right], 0) + 1
            max_freq = max(max_freq, chars_dict[s[right]])

            # we have chars in between that are not the same and greater than k to be replaced
            # invalid window
            while right-left+1 - max_freq > k:
                chars_dict[s[left]] -= 1
                left += 1
            
            res = max(res, right-left + 1)

        return res