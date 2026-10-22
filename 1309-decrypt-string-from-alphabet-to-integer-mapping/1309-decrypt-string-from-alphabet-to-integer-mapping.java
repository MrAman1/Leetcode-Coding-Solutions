
class Solution {
    public String freqAlphabets(String s) {
        String ans = "";

        for (int i = 0; i < s.length();) {
            if (i + 2 < s.length() && s.charAt(i + 2) == '#') {
                int num = Integer.parseInt(s.substring(i, i + 2));
                ans += (char) ('a' + num - 1);
                i += 3;
            } else {
                int num = s.charAt(i) - '0';
                ans += (char) ('a' + num - 1);
                i++;
            }
        }

        return ans;
    }
}
