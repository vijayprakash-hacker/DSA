class Solution {
public:typedef pair<int, int> pair;
    vector<int> findClosestElements(vector<int>& arr, int k, int x) {
        priority_queue<pair> pq; // maxheap

        for(int ele : arr) {
            int diff = abs(ele - x);
            pq.push({diff, ele});
            if(pq.size() > k) pq.pop();
        }

        vector<int> ans;
        while(pq.size() > 0) {
            ans.push_back((pq.top()).second);
            pq.pop();
        }
        sort(ans.begin(), ans.end());
        return ans;
    }
};