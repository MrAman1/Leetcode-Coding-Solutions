class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {

        int n = nums.length;

        int[][] a = new int[n][2];

        for (int i = 0; i < n; i++) {
            a[i][0] = nums[i];
            a[i][1] = i;
        }

        Arrays.sort(a, (x, y) -> Integer.compare(x[0], y[0]));

        int[] ans = new int[n];

        int i = 0;

        while (i < n) {

            int j = i;

            while (j + 1 < n &&
                   (long)a[j + 1][0] - a[j][0] <= limit) {
                j++;
            }

            ArrayList<Integer> values = new ArrayList<>();
            ArrayList<Integer> indexes = new ArrayList<>();

            for (int k = i; k <= j; k++) {
                values.add(a[k][0]);
                indexes.add(a[k][1]);
            }

            Collections.sort(indexes);

            for (int k = 0; k < values.size(); k++) {
                ans[indexes.get(k)] = values.get(k);
            }

            i = j + 1;
        }

        return ans;
    }
}