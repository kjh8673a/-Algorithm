import java.util.*;
import java.io.*;

public class Main {
    static class Point {
        int r;
        int c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static class Coins {
        Point a;
        Point b;
        int cnt;

        public Coins(Point a, Point b, int cnt) {
            this.a = a;
            this.b = b;
            this.cnt = cnt;
        }
    }

    static int[][] vector = { { 0, -1 }, { 0, 1 }, { -1, 0 }, { 1, 0 } };
    static int n, m;
    static char[][] board;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new char[n][m];

        Point[] arr = new Point[2];
        int idx = 0;
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                board[i][j] = s.charAt(j);
                if (board[i][j] == 'o') {
                    arr[idx++] = new Point(i, j);
                    board[i][j] = '.';
                }
            }
        }

        System.out.println(bfs(arr));
    }

    private static int bfs(Point[] arr) {
        Queue<Coins> queue = new LinkedList<>();
        queue.add(new Coins(arr[0], arr[1], 0));

        int ans = Integer.MAX_VALUE;
        while (!queue.isEmpty()) {
            Coins curr = queue.poll();
            Point a = curr.a;
            Point b = curr.b;

            if (curr.cnt >= 10) {
                continue;
            }

            for (int i = 0; i < 4; i++) {
                int anr = a.r + vector[i][0];
                int anc = a.c + vector[i][1];
                int bnr = b.r + vector[i][0];
                int bnc = b.c + vector[i][1];

                boolean aCheck = inBound(anr, anc);
                boolean bCheck = inBound(bnr, bnc);

                if (!aCheck && !bCheck) {
                    continue;
                } else if (!aCheck || !bCheck) {
                    ans = Math.min(ans, curr.cnt + 1);
                } else {
                    if (board[anr][anc] == '#') {
                        anr = a.r;
                        anc = a.c;
                    }
                    if (board[bnr][bnc] == '#') {
                        bnr = b.r;
                        bnc = b.c;
                    }
                    queue.add(new Coins(new Point(anr, anc), new Point(bnr, bnc), curr.cnt + 1));
                }
            }
        }

        if (ans == Integer.MAX_VALUE) {
            ans = -1;
        }
        return ans;
    }

    private static boolean inBound(int r, int c) {
        if (r < 0 || c < 0 || r >= n || c >= m) {
            return false;
        }
        return true;
    }

}