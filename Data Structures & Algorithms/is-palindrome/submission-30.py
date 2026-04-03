class Solution:
    def isPalindrome(self, s: str) -> bool:
        start: int = 0
        end: int = len(s) - 1
        
        while(end > start):
            while start < len(s) and not s[start].isalnum() :  start += 1
            while end >= 0 and not s[end].isalnum(): end -= 1
            # print(f'start: {start} is {s[start].lower()} - end: {end} is {s[end].lower()}')
            if (end < start): break
            if s[start].lower() != s[end].lower(): return False
            else:
                start += 1
                end -= 1
        
        return True