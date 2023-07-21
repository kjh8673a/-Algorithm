import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int r;
        int c;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static char[][] board;
    static int ans;

    static int[][] vector = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        board = new char[12][6];
        for (int i = 0; i < 12; i++) {
            board[i] = br.readLine().toCharArray();
        }

        ans = 0;
        playGame();

        System.out.println(ans);
    }

    private static void playGame() {
        boolean isFinished = true;
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 6; j++) {
                if (board[i][j] != '.') {
                    if (bfs(i, j, board[i][j])) {
                        isFinished = false;
                    }
                }
            }
        }

        if (!isFinished) {
            ans++;
            drop();
            playGame();
        }
    }

    private static void drop() {
        for (int i = 0; i < 6; i++) {
            Stack<Character> stack = new Stack<>();
            for (int j = 0; j < 12; j++) {
                if (board[j][i] != '.') {
                    stack.add(board[j][i]);
                }
            }

            int idx = 11;
            while (!stack.isEmpty()) {
                board[idx--][i] = stack.pop();
            }
            for (int j = idx; j >= 0; j--) {
                board[j][i] = '.';
            }
        }
    }

    private static boolean bfs(int r, int c, char color) {
        Queue<Node> queue = new LinkedList<>();
        boolean[][] visit = new boolean[12][6];
        queue.add(new Node(r, c));
        visit[r][c] = true;

        ArrayList<Node> list = new ArrayList<>();
        list.add(new Node(r, c));

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nr = node.r + vector[i][0];
                int nc = node.c + vector[i][1];

                if (nr < 0 || nc < 0 || nr >= 12 || nc >= 6 || visit[nr][nc]) {
                    continue;
                }

                if (board[nr][nc] == color) {
                    queue.add(new Node(nr, nc));
                    list.add(new Node(nr, nc));
                    visit[nr][nc] = true;
                }
            }
        }

        if (list.size() < 4) {
            return false;
        }

        for (Node node : list) {
            board[node.r][node.c] = '.';
        }
        return true;
    }

}
