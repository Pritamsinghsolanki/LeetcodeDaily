class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ans1 = new ArrayList<>();
        solve(nums, 0, ans, ans1);
        return ans;
    }

    public static void solve(int[] nums, int idx, List<List<Integer>> ans, List<Integer> ans1) {
        if (idx == nums.length) {
            ans.add(new ArrayList(ans1));
            return;
        }
        ans1.add(nums[idx]);
        solve(nums, idx + 1, ans, ans1);
        ans1.remove(ans1.size() - 1);
        solve(nums, idx + 1, ans, ans1);
    }
}