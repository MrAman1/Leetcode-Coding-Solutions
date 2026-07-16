class Solution {
    public String reverseVowels(String s) {

        char[] arr = s.toCharArray();

        for (int i = 0, j = arr.length - 1; i < j;) {

            if (!"aeiouAEIOU".contains(arr[i] + ""))
                i++;
            else if (!"aeiouAEIOU".contains(arr[j] + ""))
                j--;
            else {
                char temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }

        return new String(arr);
    }
}