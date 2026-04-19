class Solution {
    public boolean validTree(int n, int[][] edges) {
        Map<Integer, List<Integer>> adj = new HashMap();
        Set<Integer> visited = new HashSet();

        for (int i =0; i < n; i++) {
            adj.put(i, new ArrayList());
        }

        for(int[] edge: edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        return dfs(0, -1, visited, adj) && visited.size() == n;
    }

    private boolean dfs(int current, int prev, Set<Integer> visited, Map<Integer, List<Integer>> adj) {
        if (visited.contains(current)) return false;

        visited.add(current);

        for (int neigh: adj.get(current)) {
            if (neigh == prev) continue;
            if (!dfs(neigh, current, visited, adj)) return false;
        }
        return true;

    }
}
