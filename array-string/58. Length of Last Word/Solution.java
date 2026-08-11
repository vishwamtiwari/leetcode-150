class Solution {
    public int lengthOfLastWord(String s) {
        s = s.trim();
        int i = s.length() - 1;
        int len = 0;

        while (true) {
            if (i >= 0 && s.charAt(i) != ' ') {
                len++;
                i--;
            } else break;
        }
        return len;
    }
}