import java.util.*;
import java.io.*;

public class Main {
    static class Guest {
        int sr;
        int sc;
        int er;
        int ec;

        public Guest(int sr, int sc, int er, int ec) {
            this.sr = sr;
            this.sc = sc;
            this.er = er;
            this.ec = ec;
        }
    }

    static class Taxi {
        int r;
        int c;
        int move;

        public Taxi(int r, int c, int move) {
            this.r = r;
            this.c = c;
            this.move = move;
        }
    }

    static int[][] vector = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
    static int n, m, fuel;
    static int[][] board;
    static Guest[] list;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        fuel = Integer.parseInt(st.nextToken());
        board = new int[n + 1][n + 1];
        for (int i = 1; i < n + 1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < n + 1; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        int sr = Integer.parseInt(st.nextToken());
        int sc = Integer.parseInt(st.nextToken());

        list = new Guest[m + 1];
        for (int i = 1; i < m + 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            board[a][b] = -i;
            list[i] = new Guest(a, b, c, d);
        }

        findGuest(sr, sc);

        if (m > 0) {
            fuel = -1;
        }

        System.out.println(fuel);
    }

    private static void findGuest(int sr, int sc) {
        Queue<Taxi> queue = new LinkedList<>();
        queue.add(new Taxi(sr, sc, 0));

        boolean[][] visit = new boolean[n + 1][n + 1];
        visit[sr][sc] = true;

        List<Guest> tmp = new LinkedList<>();
        int dist = Integer.MAX_VALUE;
        while (!queue.isEmpty()) {
            Taxi t = queue.poll();

            if (dist < t.move) {
                continue;
            }

            if (board[t.r][t.c] < 0) {
                int idx = -board[t.r][t.c];
                if (dist > t.move) {
                    dist = t.move;
                    tmp.clear();
                    tmp.add(list[idx]);
                } else if (dist == t.move) {
                    tmp.add(list[idx]);
                }
            }

            for (int i = 0; i < 4; i++) {
                int nr = t.r + vector[i][0];
                int nc = t.c + vector[i][1];

                if (nr <= 0 || nc <= 0 || nr > n || nc > n || board[nr][nc] == 1 || visit[nr][nc]) {
                    continue;
                }

                visit[nr][nc] = true;
                queue.add(new Taxi(nr, nc, t.move + 1));
            }
        }

        Collections.sort(tmp, new Comparator<Guest>() {
            @Override
            public int compare(Guest o1, Guest o2) {
                if (o1.sr == o2.sr) {
                    return o1.sc - o2.sc;
                }
                return o1.sr - o2.sr;
            }
        });

        if (!tmp.isEmpty()) {
            if (fuel - dist < 0) {
                fuel = -1;
                return;
            }
            Guest g = tmp.get(0);
            board[g.sr][g.sc] = 0;
            fuel -= dist;
            goDestination(g);
        }
    }

    private static void goDestination(Guest g) {
        Queue<Taxi> queue = new LinkedList<>();
        queue.add(new Taxi(g.sr, g.sc, 0));

        boolean[][] visit = new boolean[n + 1][n + 1];
        visit[g.sr][g.sc] = true;

        while (!queue.isEmpty()) {
            Taxi t = queue.poll();

            if (t.r == g.er && t.c == g.ec) {
                if (fuel - t.move < 0) {
                    fuel = -1;
                    return;
                }
                fuel += t.move;
                m--;
                if (m > 0) {
                    findGuest(t.r, t.c);
                }
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nr = t.r + vector[i][0];
                int nc = t.c + vector[i][1];

                if (nr <= 0 || nc <= 0 || nr > n || nc > n || board[nr][nc] == 1 || visit[nr][nc]) {
                    continue;
                }

                visit[nr][nc] = true;
                queue.add(new Taxi(nr, nc, t.move + 1));
            }
        }

    }

}