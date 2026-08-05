class Solution {
    static class Edge {
        int src;
        int dest;

        public Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }

    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        ArrayList<Edge>[] graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < invocations.length; i++) {
            int src = invocations[i][0];
            int dest = invocations[i][1];

            Edge e = new Edge(src, dest);
            graph[src].add(e);
        }

        boolean[] vis = new boolean[graph.length];
        dfs(graph, k, vis);

        boolean suspicious = false;

        for (int i = 0; i < invocations.length; i++) {
            if (!vis[invocations[i][0]] && vis[invocations[i][1]]) {
                suspicious = true;
                break;
            }
        }

        List<Integer> list = new ArrayList<>();

        if (suspicious) {
            for (int i = 0; i < n; i++) {
                list.add(i);
            }
        } else {
            for (int i = 0; i < n; i++) {
                if (!vis[i]) {
                    list.add(i);
                }
            }
        }

        return list;
    }

    private void dfs(ArrayList<Edge>[] graph, int curr, boolean[] vis) {
        vis[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!vis[e.dest]) {
                dfs(graph, e.dest, vis);
            }
        }
    }
}