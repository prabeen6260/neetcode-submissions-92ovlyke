class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        freq = defaultdict(list)
        for num in nums:
            freq[num]=freq.get(num,0)+1
        sortedByValues=sorted(freq.items(),key=lambda x:x[1], reverse=True)
        ans =[0]*k
        for i in range(k):
            ans[i]=sortedByValues[i][0]
        return ans
