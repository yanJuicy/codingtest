
def solution(nums):
    return min(len(set(nums)), len(nums) // 2)

# def solution(nums):
#     answer = 0
#     pickNums = len(nums) // 2
#     s = set(nums)
#     answer = min(len(s), pickNums)
#     return answer