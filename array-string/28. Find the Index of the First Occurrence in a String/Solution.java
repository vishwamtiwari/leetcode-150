class Solution {
    public int strStr(String haystack, String needle) {
        int i = 0;
        String temp = haystack;

        while (i <= haystack.length() - needle.length()) {
            if (temp.startsWith(needle)) {
                return i;
            }
            i++;
            if (i > haystack.length() - needle.length()) return -1;
            temp = haystack.substring(i, haystack.length());
        }

        return -1;
    }
}