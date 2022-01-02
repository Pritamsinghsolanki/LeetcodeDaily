package January;

class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int n = time.length;
        int x = 0;
        int y = 0;
        int i = 0;
        int[] arr = new int[61];
        int ans = 0;
        while (i != n) {
            x = (time[i] % 60);
            y = (60 - x) % 60;
            ans += arr[y];
            ++arr[x];
            i++;
        }
        return ans;
    }
}