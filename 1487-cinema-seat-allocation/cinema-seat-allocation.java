class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Map<Integer, int[]> map = new HashMap<>();

        for(int i = 0; i < reservedSeats.length; i++) {
            int row = reservedSeats[i][0];
            int seat = reservedSeats[i][1];
            if(!map.containsKey(row)) {
                map.put(row, new int[10]);
            } 
            int[] arr = map.get(row);
            arr[seat - 1] = -1;
        }

        int count = 0;
        count += 2 * (n - map.size());

        for(int[] cinema : map.values()) {
            int a2 = cinema[1];
            int a3 = cinema[2];
            int a4 = cinema[3];
            int a5 = cinema[4];
            int a6 = cinema[5];
            int a7 = cinema[6];
            int a8 = cinema[7];
            int a9 = cinema[8];

            if (a2 != -1 && a3 != -1 && a4 != -1 && a5 != -1
                    && a6 != -1 && a7 != -1 && a8 != -1 && a9 != -1) {
                count += 2;
            } else if (a2 != -1 && a3 != -1 && a4 != -1 && a5 != -1) {
                count++;
            } else if (a6 != -1 && a7 != -1 && a8 != -1 && a9 != -1) {
                count++;
            } else if (a4 != -1 && a5 != -1
                    && a6 != -1 && a7 != -1) {
                count++;
            }
        }

        return count;
    }
}