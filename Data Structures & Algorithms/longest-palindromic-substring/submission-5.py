class Solution:
    def longestPalindrome(self, s: str) -> str:
        # empty case
        if not s:
            return ""

        # Transform string => even to odd
        # "abba" -> "#a#b#b#a#"
        t = "#" + "#".join(s) + "#"

        p = [0] * len(t)   # palindrome radius at each center
        center = 0
        right = 0

        max_len = 0
        max_center = 0

        for i in range(len(t)):
            mirror = (2 * center) - i

            # case 1: If i is inside the current known palindrome,
            # use mirror information
            if i < right:
                p[i] = min(right - i, p[mirror])

            # case 2: Try to expand around i
            left = i - p[i] - 1
            r = i + p[i] + 1

            while left >= 0 and r < len(t) and t[left] == t[r]:
                p[i] += 1
                left -= 1
                r += 1

            # If palindrome around i goes beyond right,
            # update center and right
            if i + p[i] > right:
                center = i
                right = i + p[i]

            # Track longest palindrome
            if p[i] > max_len:
                max_len = p[i]
                max_center = i

        # Convert back to original string index
        start = (max_center - max_len) // 2
        return s[start:start + max_len]
