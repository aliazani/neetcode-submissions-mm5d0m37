class Solution:
    def minWindow(self, s: str, t: str) -> str:
        # edge case
        if t == "": return ""

        t_map: Dict[str, int] = {}
        s_map: Dict[str, int] = {}

        for c in t: t_map[c] = t_map.get(c, 0) + 1

        meet: int = 0
        have: int = len(t_map)
        # sliding window
        left: int = 0

        # result
        res: List = []
        res_len = float('inf')
        for right in range(len(s)):
            # adding the char to the list
            s_map[s[right]] = s_map.get(s[right], 0) + 1

            if(s[right] in t_map and s_map[s[right]] == t_map[s[right]]): meet += 1

            while meet == have:
                if (right-left+1 < res_len):
                    res = [left, right]
                    res_len = right-left + 1

                # pop the item from the dict
                s_map[s[left]] -= 1

                # if 
                if(s[left] in t_map and s_map[s[left]] < t_map[s[left]]): meet -= 1


                left += 1

        return s[res[0]: res[1]+1] if res_len != float("infinity") else ""



        