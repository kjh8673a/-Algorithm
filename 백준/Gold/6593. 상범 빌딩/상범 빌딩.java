import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class Node {
        int floor;
        int row;
        int col;
        int time;

        public Node(int floor, int row, int col, int time) {
            this.floor = floor;
            this.row = row;
            this.col = col;
            this.time = time;
        }
    }

    static int[] dr = { 0, 0, 1, -1 };
    static int[] dc = { 1, -1, 0, 0 };
    static int[] dl = { 1, -1 };

    static int L, R, C, start_l, start_r, start_c, ans;
    static char[][][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());

            L = Integer.parseInt(st.nextToken()); // 층
            R = Integer.parseInt(st.nextToken()); // 행
            C = Integer.parseInt(st.nextToken()); // 열

            if (L == 0 && R == 0 && C == 0) {
                break;
            }

            board = new char[L][R][C];

            start_l = 0;
            start_r = 0;
            start_c = 0;

            for (int i = 0; i < L; i++) {
                for (int j = 0; j < R; j++) {
                    String s = br.readLine();
                    for (int k = 0; k < C; k++) {
                        board[i][j][k] = s.charAt(k);
                        if (board[i][j][k] == 'S') {
                            start_l = i;
                            start_r = j;
                            start_c = k;
                        }
                    }
                }
                br.readLine();
            }

            ans = 0;
            bfs();

            if (ans == 0) {
                sb.append("Trapped!").append("\n");
            } else {
                sb.append("Escaped in " + ans + " minute(s).").append("\n");
            }
        }

        System.out.println(sb.toString());

    }

    public static void bfs() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(start_l, start_r, start_c, 0));

        boolean[][][] visit = new boolean[L][R][C];
        visit[start_l][start_r][start_c] = true;

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            int l = node.floor;
            int r = node.row;
            int c = node.col;

            if (board[l][r][c] == 'E') {
                ans = node.time;
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (nr < 0 || nc < 0 || nr >= R || nc >= C) {
                    continue;
                }

                if (board[l][nr][nc] != '#' && !visit[l][nr][nc]) {
                    visit[l][nr][nc] = true;
                    queue.add(new Node(l, nr, nc, node.time + 1));
                }
            }

            for (int i = 0; i < 2; i++) {
                int nl = l + dl[i];

                if (nl < 0 || nl >= L) {
                    continue;
                }

                if (board[nl][r][c] != '#' && !visit[nl][r][c]) {
                    visit[nl][r][c] = true;
                    queue.add(new Node(nl, r, c, node.time + 1));
                }
            }
        }
    }

}