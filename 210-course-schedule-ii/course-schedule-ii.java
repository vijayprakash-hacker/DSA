class Solution {
    static class Edge {
        int src;
        int dest;
        
        public Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<Edge>[] graph = new ArrayList[numCourses];
        int[] indeg = new int[numCourses];
        Queue<Integer> q = new LinkedList<>();
        int[] result = new int[numCourses];

        for(int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < prerequisites.length; i++) {
            int src = prerequisites[i][1];
            int dest = prerequisites[i][0];
            
            graph[src].add(new Edge(src, dest));

            indeg[dest]++;
        }

        for(int i = 0; i < indeg.length; i++) {
            if(indeg[i] == 0) {
                q.add(i);
            }
        }

        int start = 0;
        while(!q.isEmpty()) {
            int curr = q.remove();

            result[start++] = curr;

            for(int i = 0; i < graph[curr].size(); i++) {
                Edge e = graph[curr].get(i);
                indeg[e.dest]--;
                if(indeg[e.dest] == 0) {
                    q.add(e.dest);
                }
            }
        }

        if (start != numCourses) {
            return new int[0];
        }

        return result;
    }
}