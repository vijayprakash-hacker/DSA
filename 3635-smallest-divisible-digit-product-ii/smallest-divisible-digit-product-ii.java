class Solution {
    private static final int[][] DIGIT_FACTORS = {
        {0, 0, 0, 0}, // 0
        {0, 0, 0, 0}, // 1
        {1, 0, 0, 0}, // 2
        {0, 1, 0, 0}, // 3
        {2, 0, 0, 0}, // 4
        {0, 0, 1, 0}, // 5
        {1, 1, 0, 0}, // 6
        {0, 0, 0, 1}, // 7
        {3, 0, 0, 0}, // 8
        {0, 2, 0, 0}  // 9
    };

    public String smallestNumber(String num, long t) {
        // Step 1: Factorize t into prime factors 2, 3, 5, 7
        long[] targetPrime = new long[4];
        int[] primes = {2, 3, 5, 7};
        long tempT = t;
        
        for (int i = 0; i < 4; i++) {
            while (tempT % primes[i] == 0) {
                tempT /= primes[i];
                targetPrime[i]++;
            }
        }

        if (tempT > 1) return "-1";

        int n = num.length();
        int firstZero = num.indexOf('0');

        // Step 2: Check if num itself is valid (no zeros & product divisible by t)
        if (firstZero == -1) {
            long[] numFactors = new long[4];
            for (int i = 0; i < n; i++) {
                int d = num.charAt(i) - '0';
                for (int k = 0; k < 4; k++) {
                    numFactors[k] += DIGIT_FACTORS[d][k];
                }
            }
            if (isSatisfied(targetPrime, numFactors)) {
                return num;
            }
        }

        // Step 3: Precompute prefix prime factors up to the first '0'
        int maxI = (firstZero == -1) ? n - 1 : firstZero;
        long[][] prefixFactors = new long[n + 1][4];
        for (int i = 0; i < maxI; i++) {
            int d = num.charAt(i) - '0';
            for (int k = 0; k < 4; k++) {
                prefixFactors[i + 1][k] = prefixFactors[i][k] + DIGIT_FACTORS[d][k];
            }
        }

        // Step 4: Backward search for the longest valid prefix
        for (int i = maxI; i >= 0; i--) {
            int currentDigit = num.charAt(i) - '0';
            
            for (int d = currentDigit + 1; d <= 9; d++) {
                long[] rem = new long[4];
                for (int k = 0; k < 4; k++) {
                    long supplied = prefixFactors[i][k] + DIGIT_FACTORS[d][k];
                    rem[k] = Math.max(0, targetPrime[k] - supplied);
                }

                int needed = getMinDigits(rem[0], rem[1], rem[2], rem[3]);
                int avail = n - 1 - i;

                if (needed <= avail) {
                    String prefix = num.substring(0, i) + d;
                    String suffix = buildSuffix(rem[0], rem[1], rem[2], rem[3], avail);
                    return prefix + suffix;
                }
            }
        }

        // Step 5: Length expansion if no same-length prefix works
        int reqLen = Math.max(n + 1, (int) getMinDigits(targetPrime[0], targetPrime[1], targetPrime[2], targetPrime[3]));
        return buildSuffix(targetPrime[0], targetPrime[1], targetPrime[2], targetPrime[3], reqLen);
    }

    private boolean isSatisfied(long[] target, long[] actual) {
        for (int i = 0; i < 4; i++) {
            if (actual[i] < target[i]) return false;
        }
        return true;
    }

    private int getMinDigits(long c2, long c3, long c5, long c7) {
        int count = 0;
        count += c3 / 2; c3 %= 2;
        count += c2 / 3; c2 %= 3;
        count += c5 + c7;

        if (c2 == 2 && c3 == 1) count += 2;     
        else if (c2 == 1 && c3 == 1) count += 1; 
        else if (c2 > 0 || c3 > 0) count += 1;   

        return count;
    }

    private String buildSuffix(long c2, long c3, long c5, long c7, int targetLen) {
        StringBuilder sb = new StringBuilder();

        while (c3 >= 2) { sb.append('9'); c3 -= 2; }
        while (c2 >= 3) { sb.append('8'); c2 -= 3; }
        while (c7 >= 1) { sb.append('7'); c7 -= 1; }
        while (c5 >= 1) { sb.append('5'); c5 -= 1; }

        if (c2 == 2 && c3 == 1) {
            sb.append('2').append('6');
        } else if (c2 == 1 && c3 == 1) {
            sb.append('6');
        } else if (c2 == 2) {
            sb.append('4');
        } else if (c2 == 1) {
            sb.append('2');
        } else if (c3 == 1) {
            sb.append('3');
        }

        while (sb.length() < targetLen) {
            sb.append('1');
        }

        char[] chars = sb.toString().toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}