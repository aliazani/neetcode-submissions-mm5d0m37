class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        set_chars: set[str] = set()
        left: int = 0
        longest: int = 0

        for right in range(len(s)):
            while s[right] in set_chars:
                set_chars.remove(s[left])
                left += 1
            
            set_chars.add(s[right])
            longest = max(longest, right-left+1)

        return longest
