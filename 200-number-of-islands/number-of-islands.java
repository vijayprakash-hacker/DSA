class Solution {
    public int numIslands(char[][] grid) {
        int ans = 0;
        int n = grid.length, m = grid[0].length;
        Queue<int[]> queue = new ArrayDeque<>();
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if (grid[i][j] == '1') {
                    ans++;
                    queue.add(new int[]{i, j});
                    
                    while (!queue.isEmpty()) {
                        int[] curr = queue.poll();
                        int x = curr[0], y = curr[1];
                        grid[x][y] = '0';
                        
                        for (int[] dir : directions) {
                            int nx = x + dir[0];
                            int ny = y + dir[1];
                            if (nx >= 0 && nx < n && ny >= 0 && ny < m && grid[nx][ny] == '1') {
                                queue.add(new int[]{nx, ny});
                                grid[nx][ny] = '0';
                            }
                        }
                    }
                }
            }
        }

        return ans;
    }
}

