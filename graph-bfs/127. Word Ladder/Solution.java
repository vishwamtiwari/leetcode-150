class Solution {
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {

        Set<String> validWords = new HashSet<>(wordList);

        if (!validWords.contains(endWord))
            return 0;

        char[] letters = new char[] {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q',
                'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};


        Queue<String> queue = new ArrayDeque<>();

        queue.offer(beginWord);

        int count = 1;

        while (!queue.isEmpty()) {
            int n = queue.size();

            while (n > 0) {
                String current = queue.poll();

                if (current.equals(endWord))
                    return count;

                char[] chars = current.toCharArray();
                for (int i = 0; i < chars.length; i++) {
                    char original = chars[i];

                    for (char ch: letters) {
                        if (ch == original)
                            continue;

                        chars[i] = ch;

                        String nextValid = String.valueOf(chars);

                        if (validWords.contains(nextValid)) {
                            validWords.remove(nextValid);
                            queue.offer(nextValid);
                        }
                    }

                    chars[i] = original;
                }

                n--;
            }

            count++;
        }

        return 0;
    }
}