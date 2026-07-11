class Solution {

    static class Edge {
        int src;
        int dest;

        Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }

    public int countCompleteComponents(int n, int[][] edges) {
        ArrayList<Edge>[] graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];

            graph[u].add(new Edge(u, v));
            graph[v].add(new Edge(v, u));
        }

        boolean[] vis = new boolean[n];
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                Queue<Integer> q = new LinkedList<>();
                q.add(i);

                int vertices = 0;
                int totalEdges = 0;

                while (!q.isEmpty()) {
                    int curr = q.remove();

                    if (!vis[curr]) {
                        vis[curr] = true;
                        vertices++;

                        totalEdges += graph[curr].size();

                        for (Edge e : graph[curr]) {
                            if (!vis[e.dest]) {
                            q.add(e.dest);
                            }
                        }
                    }
                }

                totalEdges /= 2;

                int requiredEdges = vertices * (vertices - 1) / 2;

                if (totalEdges == requiredEdges) {
                    count++;
                }
            }
        }

        return count;
    }
}