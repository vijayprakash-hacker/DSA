class Solution {
	public ArrayList<ArrayList<Integer>> levelSort(int[] arr) {
		// code here
		ArrayList<ArrayList<Integer>> mainList = new ArrayList<>();
		int c = 1;
		
		for (int i = 0; i < arr.length;) {
			ArrayList<Integer> list = new ArrayList<>();
			
			for (int j = i; j < Math.min(i + c, arr.length) ; j++) {
				list.add(arr[j]);
			}
			
			i += c;
			Collections.sort(list);
			mainList.add(list);
			c *= 2;
		}
		
		return mainList;
	}
}
