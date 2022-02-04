class Solution {
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0)
            return 0;
        int n = heights.length;
        int[] lessfromleft = new int[n];
        int[] lessfromright = new int[n];
        lessfromleft[0] = -1;
        lessfromright[n - 1] = n;
        for (int i = 1; i < n; i++) {
            int p = i - 1;
            while (p >= 0 && heights[p] >= heights[i]) {
                p = lessfromleft[p];
            }
            lessfromleft[i] = p;
        }
        for (int i = n - 2; i >= 0; i--) {
            int p = i + 1;
            while (p < n && heights[i] <= heights[p]) {
                p = lessfromright[p];
            }
            lessfromright[i] = p;
        }
        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            maxArea = Math.max(maxArea, heights[i] * (lessfromright[i] - lessfromleft[i] - 1));
        }
        return maxArea;
    }
}