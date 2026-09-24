class Solution {
  public:
    int minCost(vector<int>& arr) {
        // code here
        priority_queue<int, vector<int>, greater<int>> pq;
        int sum = 0;
        for(int i : arr) {
            pq.push(i);
        }
        while(pq.size() > 1) {
            int a = pq.top();
            pq.pop();
            int b = pq.top();
            pq.pop();
            sum += a + b;
            pq.push(a + b);
        }
        return sum;
    }
};