class Solution:
    def kthSmallest(self, matrix: List[List[int]], k: int) -> int:
        result = [number for item in matrix for number in item]
        result.sort()
        return result[k - 1]
