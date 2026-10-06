class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (s == null || words == null || words.length == 0) return result;

        int n = words.length;
        int wordSize = words[0].length();
        int totalLen = n * wordSize;
        int sLen = s.length();

        if (sLen < totalLen) return result;

        // 1. Build immutable target frequency map
        Map<String, Integer> wordsMap = new HashMap<>();
        for (String word : words) {
            wordsMap.put(word, wordsMap.getOrDefault(word, 0) + 1);
        }

        // 2. Loop through all possible offset tracks
        for (int offset = 0; offset < wordSize; offset++) {
            int left = offset;
            int right = offset;
            Map<String, Integer> windowMap = new HashMap<>();
            int count = 0; // Number of valid words currently in window

            // Slide right boundary word-by-word
            while (right + wordSize <= sLen) {
                String word = s.substring(right, right + wordSize);
                right += wordSize;

                if (wordsMap.containsKey(word)) {
                    windowMap.put(word, windowMap.getOrDefault(word, 0) + 1);
                    count++;

                    // If we have more occurrences of 'word' than needed,
                    // shrink window from left until the count matches
                    while (windowMap.get(word) > wordsMap.get(word)) {
                        String leftWord = s.substring(left, left + wordSize);
                        windowMap.put(leftWord, windowMap.get(leftWord) - 1);
                        count--;
                        left += wordSize;
                    }

                    // Exactly n valid words matched
                    if (count == n) {
                        result.add(left);
                        // Slide left forward by 1 word to continue searching
                        String leftWord = s.substring(left, left + wordSize);
                        windowMap.put(leftWord, windowMap.get(leftWord) - 1);
                        count--;
                        left += wordSize;
                    }
                } else {
                    // Invalid word encountered: flush window and reset
                    windowMap.clear();
                    count = 0;
                    left = right;
                }
            }
        }

        return result;
    }
}