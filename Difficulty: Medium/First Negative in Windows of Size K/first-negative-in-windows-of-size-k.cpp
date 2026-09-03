class Solution {
	public:
	vector<int> firstNegInt(vector<int>& arr, int k) {
		int n = arr.size();
		vector<int> ans;
		queue<pair<int, int>> q;

		for (int i = 0; i < k; i++) {
			if (arr[i] < 0) {
				q.push({arr[i], i});
			}
		}

		for (int i = k - 1; i < n; i++) {
			if (arr[i] < 0) {
				q.push({arr[i], i});
			}
			while (!q.empty() && q.front().second <= i - k) {
				q.pop();
			}
			if (!q.empty()) {
				ans.push_back(q.front().first);
			} else {
				ans.push_back(0);
			}
		}

		return ans;
	}
};