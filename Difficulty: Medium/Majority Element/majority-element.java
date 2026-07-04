class Solution {
    int majorityElement(int arr[]) {
        // code here
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int n = arr.length;

        for(int key : map.keySet()) {
            if(map.get(key) > n / 2)
                return key;
        }

        return -1;
    }
}