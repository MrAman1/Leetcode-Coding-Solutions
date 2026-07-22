class Solution {
    public int lengthOfLastWord(String s) {
        // s= s.trim();
        String [] arr = s.trim().split("\\s+");
        return arr[arr.length -1].length();
    }
}