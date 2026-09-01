import java.util.*;

class Solution {
    public int minMoves(String[] classroom, int energy) {

       int m = classroom.length;
int n = classroom[0].length();

        int sr = 0, sc = 0;
        int litter = 0;

        int[][] id = new int[m][n];

        for (int[] row : id)
            Arrays.fill(row, -1);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (classroom[i].charAt(j) == 'S') {
                    sr = i;
                    sc = j;
                }

                if (classroom[i].charAt(j) == 'L') {
                    id[i][j] = litter++;
                }
            }
        }

        int target = (1 << litter) - 1;

        Queue<int[]> q = new LinkedList<>();

        q.add(new int[]{sr, sc, energy, 0, 0});

        boolean[][][][] visited =
            new boolean[m][n][energy + 1][1 << litter];

        visited[sr][sc][energy][0] = true;

        int[][] dir = {
            {1,0}, {-1,0}, {0,1}, {0,-1}
        };

        while (!q.isEmpty()) {

            int[] cur = q.poll();

            int r = cur[0];
            int c = cur[1];
            int e = cur[2];
            int mask = cur[3];
            int moves = cur[4];

            if (mask == target)
                return moves;

            for (int[] d : dir) {

                int nr = r + d[0];
                int nc = c + d[1];

                if (nr < 0 || nr >= m || nc < 0 || nc >= n)
                    continue;

                if (classroom[nr].charAt(nc) == 'X')
                    continue;

                if (e == 0)
                    continue;

                int ne = e - 1;
                int nm = mask;

                char ch = classroom[nr].charAt(nc);

                if (ch == 'L') {
                    nm = nm | (1 << id[nr][nc]);
                }

                if (ch == 'R') {
                    ne = energy;
                }

                if (!visited[nr][nc][ne][nm]) {

                    visited[nr][nc][ne][nm] = true;

                    q.add(new int[]{
                        nr, nc, ne, nm, moves + 1
                    });
                }
            }
        }

        return -1;
    }
}