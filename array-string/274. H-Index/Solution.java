class Solution {
    public int hIndex(int[] citations) {
        int result = 0;
        int len = citations.length;
        Arrays.sort(citations);

        for (int i = len - 1; i >= 0; i--) {
            if (citations[i] >= len - i) result = len - i;
        }
        return result;
    }
}