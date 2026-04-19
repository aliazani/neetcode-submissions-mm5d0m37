class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int[] pre : prerequisites) {
            graph.get(pre[0]).add(pre[1]);
        }

        Set<Integer> visiting = new HashSet<>();
        Set<Integer> visited = new HashSet<>();

        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i, graph, visiting, visited)) {
                return false;
            }
        }

        return true;
    }

    private boolean dfs(int course, Map<Integer, List<Integer>> graph,
                        Set<Integer> visiting, Set<Integer> visited) {
        if (visited.contains(course)) return true;
        if (visiting.contains(course)) return false;

        visiting.add(course);

        for (int prereq : graph.get(course)) {
            if (!dfs(prereq, graph, visiting, visited)) {
                return false;
            }
        }

        visiting.remove(course);
        visited.add(course);
        return true;
    }
}