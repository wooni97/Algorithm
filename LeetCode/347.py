
class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:

        def lower_idx(target, n, nums) :
            st = 0 
            en = n

            while st < en :
                mid = (st + en) // 2
                if nums[mid] >= target :
                    en = mid
                else :
                    st = mid + 1
            return st

        def upper_idx(target, n, nums) :
            st = 0
            en = n

            while st < en :
                mid = (st + en) // 2
                if nums[mid] > target :
                    en = mid
                else :
                    st = mid + 1
            return st

        
        nums.sort()
        nums_set = list(set(nums))

        count_dict = {}

        for num in nums_set :
            count = upper_idx(num, len(nums), nums) - lower_idx(num, len(nums), nums)

            count_dict[num] = count
        
        sorted_count_dict = sorted(count_dict, key=count_dict.get, reverse = True)

        answer = sorted_count_dict[:k]

        return answer