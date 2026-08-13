class Solution {
    private TreeMap<Integer, Integer> intervals = new TreeMap<>();
    private TreeMap<Integer, Integer> lengths = new TreeMap<>();
    private char[] chars;

    public int[] longestRepeating(String s, String queryCharacters, int[] queryIndices) {
        int n = s.length();
        this.chars = s.toCharArray();
        int k = queryIndices.length;
        int[] result = new int[k];

        int start = 0;
        for (int i = 1; i <= n; i++) {
            if (i == n || chars[i] != chars[start]) {
                addInterval(start, i - 1);
                start = i;
            }
        }

        for (int i = 0; i < k; i++) {
            int idx = queryIndices[i];
            char c = queryCharacters.charAt(i);

            if (chars[idx] != c) {
                removeAround(idx);
                chars[idx] = c;
                addAround(idx);
            }

            result[i] = lengths.lastKey();
        }

        return result;
    }

    private void addInterval(int start, int end) {
        intervals.put(start, end);
        int len = end - start + 1;
        lengths.put(len, lengths.getOrDefault(len, 0) + 1);
    }

    private void removeInterval(int start, int end) {
        intervals.remove(start);
        int len = end - start + 1;
        int count = lengths.get(len);
        if (count == 1) {
            lengths.remove(len);
        } else {
            lengths.put(len, count - 1);
        }
    }

    private void removeAround(int idx) {
        int start = intervals.floorKey(idx);
        int end = intervals.get(start);
        removeInterval(start, end);

        if (start < idx) {
            addInterval(start, idx - 1);
        }
        if (idx < end) {
            addInterval(idx + 1, end);
        }
    }

    private void addAround(int idx) {
        int start = idx;
        int end = idx;

        if (idx > 0 && chars[idx - 1] == chars[idx]) {
            int leftStart = intervals.floorKey(idx - 1);
            int leftEnd = intervals.get(leftStart);
            removeInterval(leftStart, leftEnd);
            start = leftStart;
        }

        if (idx < chars.length - 1 && chars[idx + 1] == chars[idx]) {
            int rightStart = idx + 1;
            int rightEnd = intervals.get(rightStart);
            removeInterval(rightStart, rightEnd);
            end = rightEnd;
        }

        addInterval(start, end);
    }
}