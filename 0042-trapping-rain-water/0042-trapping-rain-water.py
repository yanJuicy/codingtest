class Solution:
    def trap(self, height: List[int]) -> int:
        left, right = 0, len(height) - 1
        left_max, right_max = height[left], height[right]
        result = 0

        while left < right:
            left_max = max(left_max, height[left])
            right_max = max(right_max, height[right])
            # 더 높은 쪽을 향해 투 포인터 이동
            if left_max <= right_max:
                result += left_max - height[left]
                left += 1
            else:
                result += right_max - height[right]
                right -= 1

        return result

