class Solution {
    public boolean isPalindrome(int x) {
          if(x <0) return false;

        long res =0, digit =x;
        while(x>0){
            res = res * 10 + x %10;
            x /= 10;
        }
        return res == digit;
    }
}