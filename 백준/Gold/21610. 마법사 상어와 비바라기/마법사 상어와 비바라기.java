import java.io.*;
import java.util.*;

public class Main {
    static class Cloud {
        int r;
        int c;

        public Cloud(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static int n, m, sum;
    static int[][] board;
    static ArrayList<Cloud> cloudList;
    static boolean[][] visited;

    static int[][] vector = { { 0, -1 }, { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, 1 }, { 1, 1 }, { 1, 0 }, { 1, -1 } };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new int[n][n];
        sum = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                sum += board[i][j];
            }
        }

        cloudList = new ArrayList<>();
        cloudList.add(new Cloud(n - 1, 0));
        cloudList.add(new Cloud(n - 1, 1));
        cloudList.add(new Cloud(n - 2, 0));
        cloudList.add(new Cloud(n - 2, 1));

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int dir = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());

            magic(dir, dist);
        }

        System.out.println(sum);
    }

    private static void magic(int dir, int dist) {
        visited = moveCloud(dir, dist);
        watrtCopy(dir, dist);
        cloudList = makeCloud();
    }

    private static ArrayList<Cloud> makeCloud() {
        ArrayList<Cloud> tmp = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j]) {
                    continue;
                }

                if (board[i][j] >= 2) {
                    tmp.add(new Cloud(i, j));
                    board[i][j] -= 2;
                    sum -= 2;
                }
            }
        }

        return tmp;
    }

    private static void watrtCopy(int dir, int dist) {
        for (Cloud cloud : cloudList) {
            int nr = (cloud.r + n + vector[dir - 1][0] * (dist % n)) % n;
            int nc = (cloud.c + n + vector[dir - 1][1] * (dist % n)) % n;

            int count = 0;
            for (int k = 1; k < 8; k += 2) {
                int dr = nr + vector[k][0];
                int dc = nc + vector[k][1];

                if (dr < 0 || dc < 0 || dr >= n || dc >= n) {
                    continue;
                }

                if (board[dr][dc] > 0) {
                    count++;
                }
            }

            board[nr][nc] += count;
            sum += count;
        }
    }

    private static boolean[][] moveCloud(int dir, int dist) {
        boolean[][] tmp = new boolean[n][n];
        for (Cloud cloud : cloudList) {
            int nr = (cloud.r + n + vector[dir - 1][0] * (dist % n)) % n;
            int nc = (cloud.c + n + vector[dir - 1][1] * (dist % n)) % n;

            board[nr][nc]++;
            sum++;
            tmp[nr][nc] = true;
        }

        return tmp;
    }

}