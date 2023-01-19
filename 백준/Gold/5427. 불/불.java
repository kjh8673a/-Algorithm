import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class Node {
        int r, c, time;
        char type;

        public Node(int r, int c, int time, char type) {
            this.r = r;
            this.c = c;
            this.time = time;
            this.type = type;
        }
    }

    static int[] dr = { 1, -1, 0, 0 };
    static int[] dc = { 0, 0, 1, -1 };

    static int w, h, ans;
    static char[][] board;
    static Queue<Node> queue;
    static Node person;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            board = new char[h][w];
            queue = new LinkedList<>();
            person = null;

            for (int i = 0; i < h; i++) {
                String line = br.readLine();
                for (int j = 0; j < w; j++) {
                    board[i][j] = line.charAt(j);
                    if (board[i][j] == '@') {
                        person = new Node(i, j, 0, board[i][j]);
                    }
                    if (board[i][j] == '*') {
                        queue.add(new Node(i, j, 0, board[i][j]));
                    }
                }
            }

            ans = 0;
            if (person.r == 0 || person.c == 0 || person.r == h - 1 || person.c == w - 1) {
                ans = 1;
            } else {
                escape();
            }

            if (ans == 0) {
                sb.append("IMPOSSIBLE" + "\n");
            } else {
                sb.append(ans + "\n");
            }

        }

        System.out.println(sb.toString());

    }

    public static void escape() {
        queue.add(person);

        boolean[][] visit = new boolean[h][w];

        visit[person.r][person.c] = true;

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            int r = node.r;
            int c = node.c;
            int time = node.time;
            char type = node.type;


            if (type == '@' && (r == 0 || c == 0 || r == h - 1 || c == w - 1)) {
                ans = time + 1;
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (nr < 0 || nc < 0 || nr >= h || nc >= w) {
                    continue;
                }

                if (!visit[nr][nc] && board[nr][nc] != '#' && board[nr][nc] != '*') {
                    if (type == '*') {
                        board[nr][nc] = '*';
                    }
                    if(type== '@') {
                        visit[nr][nc] = true;
                    }
                    queue.add(new Node(nr, nc, time + 1, type));
                    
                }
            }

        }
    }

}
