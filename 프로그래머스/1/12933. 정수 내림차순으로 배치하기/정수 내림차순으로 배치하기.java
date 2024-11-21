class Solution {
    public long solution(long n) {
        int[] nums = new int[10];
        
        while (n > 0) {
            nums[(int) (n % 10)]++;
            n /= 10;
        }
        
        long result = 0;
        for (int i = 9; i >= 0; i--) {
            while (nums[i] > 0) {
                result = result * 10 + i;
                nums[i]--;
            }
        }
        
        return result;
    }
}