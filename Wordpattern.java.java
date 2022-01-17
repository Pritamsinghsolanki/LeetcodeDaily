class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] strs = s.split(" ");
        if (pattern.length() != strs.length)
            return false;
        HashMap<Character, String> mp = new HashMap<>();
        int n = pattern.length();
        for (int i = 0; i < n; i++) {
            char c = pattern.charAt(i);
            if (mp.containsKey(c)) {
                if (!mp.get(c).equals(strs[i]))
                    return false;
            } else {
                if (mp.containsValue(strs[i]))
                    return false;
                mp.put(c, strs[i]);
            }
        }
        return true;
    }
}