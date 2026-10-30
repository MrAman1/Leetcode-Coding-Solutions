
class Solution {
    public boolean buddyStrings(String s, String goal) {

        if (s.length() != goal.length())
            return false;

        if (s.equals(goal)) {
            for (int i = 0; i < s.length(); i++) {
                for (int j = i + 1; j < s.length(); j++) {
                    if (s.charAt(i) == s.charAt(j))
                        return true;
                }
            }
            return false;
        }

        int count = 0;
        int a = -1, b = -1;

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) != goal.charAt(i)) {
                count++;

                if (count == 1) a = i;
                if (count == 2) b = i;
                if (count > 2) return false;
            }
        }

        return count == 2 &&
               s.charAt(a) == goal.charAt(b) &&
               s.charAt(b) == goal.charAt(a);
    }
}
