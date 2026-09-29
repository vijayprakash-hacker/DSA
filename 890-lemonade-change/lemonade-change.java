class Solution {
    public boolean lemonadeChange(int[] bills) {
        int changefive = 0;
        int changeten = 0;

        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 5) {
                changefive++;
            } else if (bills[i] == 10 && changefive >= 1) {
                changefive--;
                changeten++;
            } else if (bills[i] == 20 && changefive >= 1 && changeten >= 1) {
                changeten--;
                changefive--;
            } else if (bills[i] == 20 && changefive >= 3) {
                changefive -= 3;
            } else
                return false;
        }

        return true;
    }
}