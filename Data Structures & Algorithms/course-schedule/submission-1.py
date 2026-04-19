class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        preMap: dict[int, List[int]] = {}
        visited: set[int] = set()

        for i in range(numCourses):
            preMap[i] = []
        
        for course, pre_req in prerequisites:
            preMap[course].append(pre_req)
        # [0: [1, 2]]


        def dfs(course: int) -> bool:
            if course in visited: return False
            if len(preMap[course]) == 0: return True

            visited.add(course)
            for preq in preMap[course]:
                if not dfs(preq): return False
            
            preMap[course] = []
            visited.remove(course)
            return True
        
        for each_course in range(numCourses):
            if not dfs(each_course): return False
        
        return True