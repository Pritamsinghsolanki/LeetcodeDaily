class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // BFS
        Set<String> dic = new HashSet<>(wordList);
        if (!dic.contains(endWord)) {
            return 0;
        }
        Queue<String> q = new LinkedList<String>();
        int level = 0;
        q.offer(beginWord);

        while (!q.isEmpty()) {
            int size = q.size();
            level++;
            if (q.contains(endWord))
                return level;
            for (int i = 0; i < size; i++) {
                String curr = q.poll();
                StringBuilder sb = new StringBuilder(curr);
                for (int j = 0; j < curr.length(); j++) {
                    for (char k = 'a'; k <= 'z'; k++) {
                        sb.setCharAt(j, k);
                        if (dic.contains(sb.toString())) {
                            q.offer(sb.toString());
                            dic.remove(sb.toString());
                        }
                    }
                    sb.setCharAt(j, curr.charAt(j));
                }
            }
        }
        return 0;
    }
}