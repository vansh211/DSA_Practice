class Solution {
    class Pair {
        String str;
        int num;

        Pair(String str, int num) {
            this.str = str;
            this.num = num;
        }
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        if (!set.contains(endWord)) return 0;

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(beginWord, 1));

        // Remove beginWord if present noo needd because is coiovert again whi purana word
        set.remove(beginWord);

        while (!q.isEmpty()) {
            Pair p = q.poll();
            String word = p.str;
            int dist = p.num;

            if (word.equals(endWord)) return dist;

            // Try all transformations a to z tk sb try krke dekho
            for (int i = 0; i < word.length(); i++) {
                char[] arr = word.toCharArray();

                for (char ch = 'a'; ch <= 'z'; ch++) {
                    arr[i] = ch;

                    String newWord = new String(arr);

                    if (set.contains(newWord)) {
                        q.add(new Pair(newWord, dist + 1));
                        set.remove(newWord); // mark visited ki ye word ho chuka h wapis ni cahaiye
                    }
                }
            }
        }
        return 0;
    }
}