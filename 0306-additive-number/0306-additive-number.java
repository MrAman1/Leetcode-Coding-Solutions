
import java.math.BigInteger;

class Solution {
    public boolean isAdditiveNumber(String num) {
        int n = num.length();

        for (int i = 1; i <= n / 2; i++) {
            for (int j = i + 1; j < n; j++) {
                String x = num.substring(0, i);
                String y = num.substring(i, j);

                if (x.length() > 1 && x.startsWith("0")) break;
                if (y.length() > 1 && y.startsWith("0")) break;

                int k = j;
                BigInteger a = new BigInteger(x), b = new BigInteger(y);

                while (k < n) {
                    String sum = a.add(b).toString();
                    if (!num.startsWith(sum, k)) break;
                    k += sum.length();
                    a = b;
                    b = new BigInteger(sum);
                }

                if (k == n && j < n) return true;
            }
        }
        return false;
    }
}
