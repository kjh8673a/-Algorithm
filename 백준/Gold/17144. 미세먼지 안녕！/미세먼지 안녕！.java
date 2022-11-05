import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class Node {
        int r, c;
        int sum;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static int[] dr = { -1, 1, 0, 0 };
    static int[] dc = { 0, 0, -1, 1 };
    static int R, C, T, upR, downR;
    static int[][] board;
    static Queue<Node> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        board = new int[R][C];
        upR = -1;
        downR = -1;
        queue = new LinkedList<>();
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] == -1) {
                    if (upR == -1) {
                        upR = i;
                    } else {
                        downR = i;
                    }
                } else if (board[i][j] != 0) {
                    queue.add(new Node(i, j));
                }
            }
        }

        while (T-- > 0) {
            spread();
            upAir();
            downAir();

            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    if (board[i][j] > 0) {
                        queue.add(new Node(i, j));
                    }
                }
            }

        }

        int ans = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (board[i][j] != -1) {
                    ans += board[i][j];
                }
            }
        }

        System.out.println(ans);

    }

    public static void spread() {
        int[][] tmp = new int[R][C];
        while (!queue.isEmpty()) {
            Node node = queue.poll();

            int r = node.r;
            int c = node.c;
            int size = board[r][c];

            for (int k = 0; k < 4; k++) {
                int nr = r + dr[k];
                int nc = c + dc[k];

                if (nr < 0 || nc < 0 || nr >= R || nc >= C) {
                    continue;
                }

                if (board[nr][nc] == -1) {
                    continue;
                }

                tmp[nr][nc] += size / 5;
                tmp[r][c] -= size / 5;
            }
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (board[i][j] != -1) {
                    board[i][j] += tmp[i][j];
                }
            }
        }

    }

    public static void upAir() {
        // R : upR -> 0
        for (int i = upR - 2; i >= 0; i--) {
            board[i + 1][0] = board[i][0];
        }

        // C : 0 -> C-1
        for (int i = 1; i < C; i++) {
            board[0][i - 1] = board[0][i];
        }

        // R : 0 -> upR
        for (int i = 1; i <= upR; i++) {
            board[i - 1][C - 1] = board[i][C - 1];
        }

        // C : C-1 -> 0
        for (int i = C - 2; i > 0; i--) {
            board[upR][i + 1] = board[upR][i];
        }

        board[upR][1] = 0;
    }

    public static void downAir() {
        // R : downR -> R-1
        for (int i = downR + 2; i < R; i++) {
            board[i - 1][0] = board[i][0];
        }

        // C : 0 -> C-1
        for (int i = 1; i < C; i++) {
            board[R - 1][i - 1] = board[R - 1][i];
        }

        // R : R-1 -> downR
        for (int i = R - 2; i >= downR; i--) {
            board[i + 1][C - 1] = board[i][C - 1];
        }

        // C : C-1 -> 0
        for (int i = C - 2; i > 0; i--) {
            board[downR][i + 1] = board[downR][i];
        }

        board[downR][1] = 0;

    }

}