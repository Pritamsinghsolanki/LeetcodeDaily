class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> mp = new HashMap<>();
        for (int p1 : nums1) {
            for (int p2 : nums2) {
                mp.put(p1 + p2, mp.getOrDefault(p1 + p2, 0) + 1);
            }
        }
        int count = 0;
        for (int p1 : nums3) {
            for (int p2 : nums4) {
                count += mp.getOrDefault(-(p1 + p2), 0);
            }
        }
        return count;
    }
}