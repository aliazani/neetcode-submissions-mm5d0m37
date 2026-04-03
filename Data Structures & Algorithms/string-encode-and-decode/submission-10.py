class Solution:

    def encode(self, strs: List[str]) -> str:
        enc: str = ""
        for s in strs:
            enc += str(len(s)) + "#" + s
        return enc

    def decode(self, s: str) -> List[str]:
        i: int = 0
        res: List[str] = []

        while i < len(s):
            j = i
            while(s[j] != "#"): j +=1
            w_len = int(s[i:j])
            res.append(s[j+1: j+1+w_len])

            i = j+1+w_len
        
        return res
