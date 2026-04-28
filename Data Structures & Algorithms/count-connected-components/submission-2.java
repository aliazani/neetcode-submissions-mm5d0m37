class Solution {
    public int countComponents(int n, int[][] edges) {
        List<Integer> parent = new ArrayList<>();
        List<Integer> rank = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            parent.add(i);
            rank.add(1);
        }

        int res = n;

        for (int[] edge : edges) {
            int n1 = edge[0];
            int n2 = edge[1];

            res -= union(n1, n2, parent, rank);
        }

        return res;
    }

    private int find(int node, List<Integer> parent) {
        int res = node;

        while (res != parent.get(res)) {
            parent.set(res, parent.get(parent.get(res))); // path compression
            res = parent.get(res);
        }

        return res;
    }

    private int union(int node1, int node2, List<Integer> parent, List<Integer> rank) {
        int p1 = find(node1, parent);
        int p2 = find(node2, parent);

        if (p1 == p2) {
            return 0;
        }

        if (rank.get(p1) > rank.get(p2)) {
            parent.set(p2, p1);
            rank.set(p1, rank.get(p1) + 1);
        } else {
            parent.set(p1, p2);
            rank.set(p2, rank.get(p2) + 1);
        }

        return 1;
    }
}