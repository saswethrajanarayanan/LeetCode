class Solution:
    def permuteUnique(self, nums: List[int]) -> List[List[int]]:
        tracker = collections.defaultdict(int)
        for item in nums:
            tracker[item] += 1
        N = len(nums)
        result = []
        
        def btrack(N, sub_res):
            if N == 0:
                result.append(sub_res[:])
                return
            
            for item in tracker.keys():
                if tracker[item] > 0:
                    print(tracker, sub_res[:])
                    tracker[item] -= 1
                    btrack(N-1, sub_res + [item])
                    tracker[item] += 1
        btrack(N, [])
        return result
            
