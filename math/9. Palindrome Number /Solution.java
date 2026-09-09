class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;

        int originalNum = x;
        int reverseNum = 0;

        while (originalNum > 0) {
            reverseNum = (reverseNum * 10) + (originalNum % 10);
            originalNum /= 10;
        }

        return reverseNum == x;
    }
}