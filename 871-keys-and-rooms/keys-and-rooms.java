class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        boolean[] vis = new boolean[rooms.size()];

        while(!q.isEmpty()) {
            int curr = q.remove();
            if(!vis[curr]) {
                vis[curr] = true;
                
                for(int i = 0; i < rooms.get(curr).size(); i++) {
                    int next = rooms.get(curr).get(i);
                    if(!vis[next]) {
                        q.add(next);
                    }
                }
            }
        }

        for(boolean v: vis) if(!v) return false;
        return true;
    }
}