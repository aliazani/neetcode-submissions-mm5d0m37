class Solution:
    def foreignDictionary(self, words: List[str]) -> str:
        adj: dict[str, set[str]] = { c: set() for w in words for c in w }

        for i in range(len(words) - 1):
            word1: str = words[i]
            word2: str = words[i+1]

            minLen: int = min(len(word1), len(word2))

            if len(word1) > len(word2) and word1[: minLen] == word2[:minLen]: return ""

            for j in range(minLen):
                if word1[j] != word2[j]:
                    adj[word1[j]].add(word2[j])
                    break
        
        visited: dict[str, bool] = {}
        res: list[str] = []

        def dfs(ch: str) -> bool:
            if ch in visited: return visited[ch]

            visited[ch] = True;
            for neigh in adj[ch]:
                if dfs(neigh): return True

            visited[ch] = False;
            res.append(ch)

        for ch in adj:
            if dfs(ch): return ""
        
        res.reverse()

        return "".join(res)

