class Solution {
    int count = 0;
    boolean[] vis;

    public int findCircleNum(int[][] isConnected) {
        List<List<Integer>> mainList = new ArrayList<>();

        for(int i = 0; i < isConnected.length; i++) {
            List<Integer> list = new ArrayList<>();
            for(int j = 0; j < isConnected[0].length; j++) {
                if(isConnected[i][j] == 1) list.add(j);
            }

            mainList.add(list);
        }

        vis = new boolean[mainList.size()];
        for(int i = 0; i < mainList.size(); i++) {
            if(!vis[i]) {
                count++;
                bfs(mainList, i);
            }
        }

        return count;
    }

    public void bfs(List<List<Integer>> adj, int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);

        while(!q.isEmpty()) {
            int curr = q.remove();
            if(!vis[curr]) {
                vis[curr] = true;
                
                for(int i = 0; i < adj.get(curr).size(); i++) {
                    int next = adj.get(curr).get(i);
                    if(!vis[next]) {
                        q.add(next);
                    }
                }
            }
        }
    }
}