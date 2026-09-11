class Solution {
    public int totalNumbers(int[] digits) {
        int[] arr = new int[10];

        for(int digit : digits) {
            arr[digit]++;
        }

        int count = 0;
        for(int i = 1; i <= 9; i++) {
            if(arr[i] < 1) continue;
            arr[i]--;
            for(int j = 0; j <= 9; j++) {
                if(arr[j] < 1) continue;
                arr[j]--;
                for(int k = 0; k <= 9; k += 2) {
                    if(arr[k] > 0) count++; 
                }
                arr[j]++;
            }
            arr[i]++;
        }

        return count;
    }
}