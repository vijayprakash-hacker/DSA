class Solution {
    public int getDigitSum(int n) {
        int sum = 0;

        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }

    public int minSwaps(int[] nums) {
        int n = nums.length;
        int[][] arr = new int[n][3];

        for (int i = 0; i < nums.length; i++) {
            arr[i][0] = nums[i];
            arr[i][1] = getDigitSum(nums[i]);
            arr[i][2] = i;
        }

        Arrays.sort(arr,
                (a, b) -> a[1] == b[1] ? Integer.compare(a[0], b[0]) : Integer.compare(a[1], b[1]));

        boolean[] visited = new boolean[n];
        int swaps = 0;

        for (int i = 0; i < n; i++) {
            if (visited[i] || arr[i][2] == i)
                continue;

            int cycleLength = 0;
            int j = i;

            while (!visited[j]) {
                visited[j] = true;
                j = arr[j][2];
                cycleLength++;
            }

            swaps += cycleLength - 1;
        }

        return swaps;
    }
}