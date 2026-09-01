class Solution {
    public int findTheWinner(int n, int k) {
        Queue<Integer> q = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            q.add(i);
        }

        int j = 1;
        while (q.size() != 1) {
            int a = q.remove();

            if (j % k != 0) q.add(a);
            else j = 0;

            j++;
        }

        return q.peek();
    }
}