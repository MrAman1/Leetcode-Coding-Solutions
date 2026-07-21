class Solution {
    public List<String> commonChars(String[] words) {

        List<String> ans = new ArrayList<>();

        for (char c = 'a'; c <= 'z'; c++) {

            int min = 100;

            for (String word : words) {

                int count = 0;

                for (char ch : word.toCharArray()) {
                    if (ch == c)
                        count++;
                }

                min = Math.min(min, count);
            }

            while (min-- > 0) {
                ans.add(c + "");
            }
        }

        return ans;
    }
}