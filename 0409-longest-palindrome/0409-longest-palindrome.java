
class Solution {
    public int longestPalindrome(String s) {
        int[] count = new int[128];
        int length = 0;

        for (char c : s.toCharArray()) {
            count[c]++;
        }

        for (int c : count) {
            length += (c / 2) * 2;
        }

        if (length < s.length()) {
            length++;
        }

        return length;
    }
}
