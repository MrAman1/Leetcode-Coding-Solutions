class Solution {
    public String multiply(String a, String b) {
        if(a.equals("0") || b.equals("0")) return "0";

        int[] r = new int[a.length() + b.length()];

        for(int i=a.length()-1;i>=0;i--)
            for(int j=b.length()-1;j>=0;j--)
                r[i+j+1] += (a.charAt(i)-'0') * (b.charAt(j)-'0');

        for(int i=r.length-1;i>0;i--) {
            r[i-1] += r[i]/10;
            r[i] %= 10;
        }

        String s="";
        for(int x:r)
            if(s.length()>0 || x!=0) s += x;

        return s;
    }
}