class Solution:
    def minAddToMakeValid(self, s: str) -> int:
        l = 0
        ans = 0
        for i in s:
            if i == '(':
                l += 1
            else:
                l -= 1
            if l < 0:
                ans += 1
                l = 0
        return l + ans

        