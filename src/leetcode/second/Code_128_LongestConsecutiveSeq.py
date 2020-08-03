class Solution:
    def longestConsecutive(self , nums ):
        if len(nums) == 0:
            return 0
        s = set()
        for n in nums:
            s.add(n)
        res = 1
        while len(s) != 0:
            l = 1
            n = s.pop()
            tmp = n - 1
            while tmp in s:
                s.remove(tmp)
                tmp -= 1
                l += 1
            tmp = n + 1
            while tmp in s:
                s.remove(tmp)
                tmp += 1
                l += 1
            res = max(l, res)
        return res