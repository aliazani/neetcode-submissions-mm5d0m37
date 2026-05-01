class Solution:
    def countSubstrings(self, s: str) -> int:
        # ── Step 1: Transform ───────────────────────────────────────────
        # Insert '#' between every character (and at both ends)
        # "abc" → "#a#b#c#"  (length 2n+1)
        # Now every palindrome is odd-length, so one pass handles all cases.
        T = "#" + "#".join(s) + "#"
        n = len(T)
        P = [0] * n          # P[i] = palindrome radius at center i
        c = r = 0            # center and right boundary of rightmost palindrome

        # ── Step 2: Fill P using the Manacher recurrence ────────────────
        for i in range(n):

            # Case 1: i is inside the rightmost palindrome
            # Its mirror is at 2*c - i, and already has a known radius.
            if i < r:
                mirror = 2 * c - i

                # Sub-case A: mirror palindrome fits entirely inside → copy it P[mirror]
                # Sub-case B: mirror palindrome touches/crosses boundary → cap at r - i
                # In both sub-cases: P[i] = min(r - i, P[mirror])
                P[i] = min(r - i, P[mirror])

            # Case 2: i is outside (or at) the boundary → start from 0
            # (P[i] is already 0, nothing to do)

            # ── Expand around center i ──────────────────────────────────
            # Try to grow the palindrome as far as possible.
            # This while loop runs O(1) amortized because every character
            # we match here extends r, and r only moves right.
            while (i + P[i] + 1 < n and
                   i - P[i] - 1 >= 0 and
                   T[i + P[i] + 1] == T[i - P[i] - 1]):
                P[i] += 1

            # ── Update the rightmost boundary ───────────────────────────
            if i + P[i] > r:
                c = i
                r = i + P[i]

        # ── Step 3: Count palindromes ────────────────────────────────────
        # In the transformed string, a radius P[i] at center i corresponds
        # to (P[i] + 1) // 2 palindromes in the original string.
        #
        # Why? A radius of k covers palindromes of size 1, 3, 5, ... up to k
        # in the transformed string — that's ceil((k+1)/2) original palindromes.
        #
        # Example: P[i]=3 → radii 0,1,2,3 → palindromes of size 1,3,5,7 in T
        #          → original sizes: single char, 1-char, 2-char, 3-char → 2 real palindromes
        #          (3+1)//2 = 2 ✓
        return sum((p + 1) // 2 for p in P)