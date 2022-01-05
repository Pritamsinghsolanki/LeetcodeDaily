class Solution {
    public static boolean ispalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }

    public List<List<String>> partition(String s) {

        List<List<String>> ans = new ArrayList<>();
        List<String> res = new ArrayList<>();
        getanswer(s, ans, res, 0);
        return ans;
    }

    public static void getanswer(String s, List<List<String>> res, List<String> ans, int idx) {
        if (idx == s.length()) {
            res.add(new ArrayList<>(ans));
            return;
        }
        for (int i = idx; i < s.length(); i++) {
            if (ispalindrome(s, idx, i)) {
                ans.add(s.substring(idx, i + 1));
                getanswer(s, res, ans, i + 1);
                ans.remove(ans.size() - 1);
            }
        }
    }
}