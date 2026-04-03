class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        letters_count_s : {str: int} = {}
        letters_count_t : {str: int} = {}


        for l in s:
            if l not in letters_count_s:
                letters_count_s[l] = 1
            else:
                letters_count_s[l] = letters_count_s[l] + 1
        
        for l in t:
            if l not in letters_count_t:
                letters_count_t[l] = 1
            else:
                letters_count_t[l] = letters_count_t[l] + 1
        
        return letters_count_t == letters_count_s
