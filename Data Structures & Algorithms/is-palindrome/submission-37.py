class Solution:
    def isPalindrome(self, s: str) -> bool:
        start: int = 0
        end: int = len(s) - 1
        
        while end > start:
            while end > start and not s[start].isalnum() :  start += 1
            while end > start and not s[end].isalnum(): end -= 1
            # if end < start: break
            if s[start].lower() != s[end].lower(): return False
            else:
                start += 1
                end -= 1
        
        return True