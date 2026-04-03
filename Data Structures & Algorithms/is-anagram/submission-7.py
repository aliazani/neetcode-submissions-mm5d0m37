class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        if len(s) != len(t): return False

        return collections.Counter(s) == collections.Counter(t)

        # letters_count : {str: int} = {}

        # for l in s:
        #     if l not in letters_count:
        #         letters_count[l] = 1
        #     else:
        #         letters_count[l] = letters_count[l] + 1
        
        # for l in t:
        #     if l not in letters_count:
        #         return False
        #     else:
        #         letters_count[l] = letters_count[l] - 1
        
        # for i in letters_count.values():
        #     if i != 0: return False

        # return True