class Solution {
    public int[] arrayRankTransform(int[] arr) {
        if(arr.length == 0) return arr;
        
        int[] num = new int[arr.length];

        for(int i = 0; i < arr.length; i++) {
            num[i] = arr[i];
        }

        Arrays.sort(arr);

        Map<Integer, Integer> map = new HashMap<>();
        int rank = 0;
        
        map.put(arr[0], ++rank);

        for(int i = 1; i < arr.length; i++) {
            if(!map.containsKey(arr[i])) {
                map.put(arr[i], ++rank);
            }
        }

        for(int i = 0; i < arr.length; i++) {
            num[i] = map.get(num[i]);
        }

        return num;
    }
}