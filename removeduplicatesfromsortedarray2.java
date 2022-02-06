class Solution {
    public int removeDuplicates(int[] nums) {
        return solve(nums, 2);
    }

    public static int solve(int[] nums, int k) {
        int i = 0;
        for (int n : nums) {
            if (i < k || n > nums[i - k])
                nums[i++] = n;
        }
        return i;
    }
}