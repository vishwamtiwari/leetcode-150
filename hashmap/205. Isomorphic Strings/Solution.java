class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;

        HashMap<Character, Character> map = new HashMap<>();
        HashSet<Character> set = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);

            Character existing = map.get(sChar);
            if (map.containsKey(sChar)) {
                if (existing != tChar) return false;
            }
            else {
                if (set.contains(tChar)) return false;
                set.add(tChar);
                map.put(sChar, tChar);
            }
        }
        return true;
    }
}