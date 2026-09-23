class Solution {
public:
    int findKthLargest(vector<int>& arr, int k) {
        priority_queue<int, vector<int>, greater<int>> pq;
        for(int i = 0; i < arr.size(); i++) {
            pq.push(arr[i]);
        }
        int s = 0;
        while(s < arr.size() - k) {
            pq.pop();
            s++;
        }
        return pq.top();
    }
};