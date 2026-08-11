class Solution {
    public String reverseWords(String s) {
        String[] words = s.split(" ");
        StringBuilder reverseString = new StringBuilder();

        for (int i = words.length-1; i>=0; i--) {
            if (!words[i].equals("")) reverseString.append(words[i]).append(" ");
        }
        return reverseString.toString().trim();
    }
}