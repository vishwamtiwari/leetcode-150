class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.trim().split(" ");
        if (words.length != pattern.length()) return false;
        HashMap<Character, String> wordMap = new HashMap<>();
        Set<String> values = new HashSet<>();

        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            String word = words[i];

            String existng = wordMap.get(c);
            if (wordMap.containsKey(c)) {
                if (!existng.equals(word)) return false;
            }
            else {
                if (values.contains(word)) return false;
                values.add(word);
                wordMap.put(c, word);
            }
        }
        return true;
    }
}