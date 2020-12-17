class Solution:
    def majorityElement(self, nums: List[int]) -> int:
        finder = collections.defaultdict(int)
        n = len(nums) / 2
        for item in nums:
            finder[item] += 1
        for item in finder.keys():
            if finder[item] > n:
                ret = item
            else:
                continue
        return ret
