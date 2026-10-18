class Solution {
    public String minWindow(String s, String t) {
        int n = s.length();

        if (t.length() > n)
            return "";

        Map<Character, Integer> map = new HashMap<>();

        //storing freq for every char in t
        for (char c: t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int requiredCount = t.length();
        int i = 0, j = 0;

        int minWindowSize = Integer.MAX_VALUE;
        int start_i = 0;

        while (j < n) {
            char c = s.charAt(j);

            if (map.containsKey(c) && map.get(c) > 0)
                requiredCount--;

            map.put(c, map.getOrDefault(c, 0) - 1);

            while (requiredCount == 0) {
                //start shrinking the window

                int currWindowSize = j-i+1;

                if (minWindowSize> currWindowSize) {
                    minWindowSize = currWindowSize;
                    start_i = i;
                }

                map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);

                if (map.get(s.charAt(i)) > 0) {
                    requiredCount++;
                }

                i++;
            }

            j++;
        }

        return minWindowSize == Integer.MAX_VALUE ? "" : s.substring(start_i, start_i + minWindowSize);
    }
}