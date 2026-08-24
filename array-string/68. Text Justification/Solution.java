class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        int n = words.length;
        List<String> result = new ArrayList<>();
        int i = 0;

        while (i < n) {
            int lettersCount = words[i].length();
            int j = i + 1;
            int spaceSlots = 0;

            while (j < n && words[j].length() + spaceSlots + lettersCount  + 1 <= maxWidth) {
                lettersCount += words[j].length();
                spaceSlots += 1;
                j++;
            }

            int remainingSlots = maxWidth - lettersCount;

            int eachWordSpace = spaceSlots == 0 ? 0 : remainingSlots / spaceSlots;
            int extraSpace = spaceSlots == 0 ? 0 : remainingSlots % spaceSlots;

            if (j == n) { //Last line - left justified
                eachWordSpace = 1;
                extraSpace = 0;
            }

            result.add(getFinalWord(i, j, eachWordSpace, extraSpace, words, maxWidth));
            i = j;
        }
        return result;
    }

    private String getFinalWord(int i, int j, int eachWordSpace, int extraSpace, String[] words, int maxWidth) {
        StringBuilder s = new StringBuilder();

        for (int k = i; k < j; k++) {
            s.append(words[k]);

            if (k == j - 1)
                continue;

            for (int space = 1; space <= eachWordSpace; space++)
                s.append(" ");

            if (extraSpace > 0) {
                s.append(" ");
                extraSpace--;
            }
        }

        while (s.length() < maxWidth) {
            s.append(" ");
        }

        return s.toString();
    }
}