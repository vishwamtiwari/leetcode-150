class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> freqMap = new HashMap<>();

        for (String s: strs) {
            char[] freq = new char[26];
            for (char c: s.toCharArray()) {
                freq[c - 'a']++;
            }

            String key = new String(freq);
            if (!freqMap.containsKey(key)) freqMap.put(key, new ArrayList<>());
            freqMap.get(key).add(s);
        }

        return new ArrayList<>(freqMap.values());
    }
}