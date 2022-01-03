
class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] degree = new int[n + 1];
        int m = trust.length;
        for (int i = 0; i < m; i++) {
            int a = trust[i][0];
            int b = trust[i][1];
            degree[a]--;
            degree[b]++;
        }

        for (int i = 1; i <= n; i++) {
            if (degree[i] == n - 1) {
                return i;
            }
        }
        return -1;
    }
}