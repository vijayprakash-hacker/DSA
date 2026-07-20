class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int n = grid.length, m = grid[0].length;
        k %= n * m;
        List<List<Integer>> mainList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            ArrayList<Integer> list = new ArrayList<>();

            for (int j = 0; j < m; j++) {
                int currPos = i * m + j;
                int prevPos = (currPos - k + n * m) % (n * m);

                int r = prevPos / m;
                int c = prevPos % m;

                list.add(grid[r][c]);
            }

            mainList.add(list);
        }

        return mainList;
    }
}