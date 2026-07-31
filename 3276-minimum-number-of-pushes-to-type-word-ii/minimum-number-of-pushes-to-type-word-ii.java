class Solution {
    public int minimumPushes(String word) {
        int[] arr = new int[26];
        for (int i = 0; i < word.length(); i++) {
            arr[word.charAt(i) - 'a']++;
        }

        Arrays.sort(arr);

        int push = 0;
        int count = 0;

        for (int i = 25; i >= 0; i--) {
            if (arr[i] == 0)
                break;

            int m = (count / 8) + 1;
            push += arr[i] * m;
            count++;
        }

        return push;
    }
}