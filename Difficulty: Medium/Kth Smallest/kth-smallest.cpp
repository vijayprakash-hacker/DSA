class Solution {
  public:
    int kthSmallest(vector<int> &arr, int k) {
        // code here
        priority_queue<int> pq;
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