class TrieNode:
    def __init__(self) -> None:
        self.children = {}
        self.endOfWord = False

class WordDictionary:
    # a dsa
    # o(n) time
    # o(t + n) space
    def __init__(self):
        self.root = TrieNode()
        

    def addWord(self, word: str) -> None:
        current = self.root

        for c in word:
            if c not in current.children:
                current.children[c] = TrieNode()
            
            current = current.children[c]
        
        current.endOfWord = True

    def search(self, word: str) -> bool:
    
        def dfs(node, index):
            current = node
            for i in range(index, len(word)):
                char = word[i]
                if char == ".":
                    for child in current.children.values():
                        if dfs(child, i+1): return True
                    return False

                else:
                    if char not in current.children:
                        return False
                    current = current.children[char]

            return current.endOfWord
        return dfs(self.root, 0);
