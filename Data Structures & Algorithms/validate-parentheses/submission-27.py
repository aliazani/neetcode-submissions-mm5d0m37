class Solution:
    def isValid(self, s: str) -> bool:
        map: Dict = {')': '(', ']': '[', '}': '{'}
        stack: List = []

        for c in s:
            if c in map:
                if not stack: return False

                elif stack[-1] == map[c]: stack.pop()

                else: return False
            else:
                stack.append(c)
        
        return len(stack) == 0