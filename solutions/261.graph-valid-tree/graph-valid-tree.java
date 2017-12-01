class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n-1) return false;
        Map<Integer, List<Integer>> tree = new HashMap(); // tree[parent node] : children node list
        for (int i = 0; i < n; i++) {
            tree.put(i, new ArrayList<Integer>());
        }
        for (int[] edge : edges) {
            tree.get(edge[0]).add(edge[1]);
            tree.get(edge[1]).add(edge[0]);
        }
        Queue<Integer> q = new LinkedList();
        q.add(0);

        while (!q.isEmpty()) {
            int node = q.poll();
            if (tree.containsKey(node)) {
                for (int succ : tree.get(node)){
                    q.offer(succ);
                }
                tree.remove(node);
            }
        }

        return tree.size() == 0;
    }
}