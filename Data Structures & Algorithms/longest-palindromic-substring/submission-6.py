class Solution:
    def longestPalindrome(self, s: str) -> str:
        # If the string is empty, there is no palindrome.
        if not s:
            return ""

        # STEP 1: TRANSFORM THE STRING
        # We insert '#' between every character to handle even-length palindromes.
        # Example: s = "abba"
        # The join() makes it "a#b#b#a", and we add '#' to the ends.
        # t = "#a#b#b#a#"
        # Indices:  0 1 2 3 4 5 6 7 8
        # Chars:    # a # b # b # a #
        t = "#" + "#".join(s) + "#"

        # STEP 2: SETUP VARIABLES
        # p is an array to store the palindrome radius at each index.
        # For "abba", len(t) is 9. So p = [0, 0, 0, 0, 0, 0, 0, 0, 0] initially.
        p = [0] * len(t)   
        
        center = 0 # The center index of the right-most palindrome we've found so far
        right = 0  # The right-most boundary of that same palindrome

        max_len = 0    # Tracks the length of the longest palindrome found
        max_center = 0 # Tracks the center index of the longest palindrome found

        # STEP 3: LOOP THROUGH THE TRANSFORMED STRING
        for i in range(len(t)):
            # Find the mirror image of our current index 'i' relative to 'center'.
            # Math: mirror is exactly the same distance to the left of center as i is to the right.
            mirror = (2 * center) - i

            # -- THE MAGIC O(n) MIRROR CHECK --
            # If our current index 'i' is inside the right boundary of our known palindrome:
            if i < right:
                # We can copy the radius from our mirror!
                # However, we can't let the copied radius expand past our known 'right' boundary, 
                # so we take the minimum of the mirror's value and the distance to 'right'.
                p[i] = min(right - i, p[mirror])

            # -- EXPAND AROUND i --
            # Now we try to grow the palindrome outwards from i.
            # 'left' is the character to the left of our current known radius.
            # 'r' (right) is the character to the right of our current known radius.
            left = i - p[i] - 1
            r = i + p[i] + 1

            # While left and right are within the string bounds, and the characters match:
            # (Example: At i=4 (the middle '#'), we compare left(3)='b' and r(5)='b'. They match!)
            while left >= 0 and r < len(t) and t[left] == t[r]:
                p[i] += 1  # Increase the radius
                left -= 1  # Move left pointer further left
                r += 1     # Move right pointer further right

            # -- UPDATE THE RIGHT-MOST BOUNDARY --
            # If the palindrome we just found centered at 'i' stretches further right 
            # than our previous champion, we must update 'center' and 'right'.
            if i + p[i] > right:
                center = i
                right = i + p[i]

            # -- TRACK THE OVERALL WINNER --
            # Keep track of the longest palindrome overall to return at the end.
            if p[i] > max_len:
                max_len = p[i]
                max_center = i

        # STEP 4: EXTRACT THE RESULT
        # max_len for "abba" will be 4. max_center will be 4 (the middle '#').
        # We need to map this back to the original string index.
        # Math: (4 - 4) // 2 = 0. So the start index in the original string is 0.
        start = (max_center - max_len) // 2
        
        # s[0 : 0 + 4] -> s[0:4] -> "abba"
        return s[start:start + max_len]