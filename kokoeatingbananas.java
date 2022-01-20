class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < piles.length; i++)
            max = Math.max(max, piles[i]);
        int r = max;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (canFinish(mid, piles, h)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    public static boolean canFinish(int k, int[] piles, int h) {
        for (int pil : piles) {
            if (pil <= k) {
                h--;
            } else {
                h -= pil / k + (pil % k == 0 ? 0 : 1);
            }
            if (h < 0)
                break;
        }
        return h >= 0;
    }
}