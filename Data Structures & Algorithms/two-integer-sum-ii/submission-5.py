class Solution:
    def twoSum(self, numbers: List[int], target: int) -> List[int]:
        left: int = 0
        right: int = len(numbers) - 1

        while left < right:
            cal: int = numbers[left] + numbers[right]

            if cal < target: left += 1
            elif cal > target: right -= 1
            else: return [left + 1, right + 1]
        
        return []