class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList<>();
        boolean[] arr = new boolean[nums.length];

        for (int num : nums) {
            arr[num - 1] = true;
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == false) list.add(i + 1);
        }

        return list;
    }
}