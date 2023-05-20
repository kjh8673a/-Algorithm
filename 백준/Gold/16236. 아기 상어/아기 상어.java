import java.io.*;
import java.util.*;

public class Main {
    static int N, shark_x, shark_y, shark_size, eat_cnt, answer;
    static int[][] area;
    static boolean[][] visit;
    static int[] dr = { 0, 0, 1, -1 };
    static int[] dc = { -1, 1, 0, 0 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        area = new int[N][N];
        visit = new boolean[N][N];
        shark_x = 0;
        shark_y = 0;
        shark_size = 2;
        eat_cnt = 0;
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                area[i][j] = Integer.parseInt(st.nextToken());
                if (area[i][j] == 9) {
                    shark_x = i;
                    shark_y = j;
                    area[i][j] = 0;
                }
            }
        }

        answer = 0;
        while (true) {
            initVisit();
            boolean flag = bfs(shark_x, shark_y);
            if (!flag) {
                break;
            }
        }
        System.out.println(answer);
    }

    private static void initVisit() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                visit[i][j] = false;
            }
        }
    }

    static class Point implements Comparable<Point> {
        int x;
        int y;
        int dist;

        public Point(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }

        @Override
        public int compareTo(Point o) {
            if (this.dist == o.dist) {
                if (this.x == o.x) {
                    return Integer.compare(this.y, o.y);
                } else {
                    return Integer.compare(this.x, o.x);
                }
            } else {
                return Integer.compare(this.dist, o.dist);
            }
        }
    }

    private static boolean bfs(int x, int y) {
        Queue<Point> queue = new LinkedList<>();
        visit[x][y] = true;
        queue.add(new Point(x, y, 0));

        PriorityQueue<Point> pq = new PriorityQueue<>();
        while (!queue.isEmpty()) {
            Point p = queue.poll();
            int r = p.x;
            int c = p.y;
            int d = p.dist;

            if(!pq.isEmpty() && d > pq.peek().dist) {
                continue;
            }

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (nr < 0 || nc < 0 || nr >= N || nc >= N) {
                    continue;
                }
                if (visit[nr][nc] || area[nr][nc] > shark_size) {
                    continue;
                }

                visit[nr][nc] = true;
                Point np = new Point(nr, nc, d + 1);
                queue.add(np);
                if (area[nr][nc] != 0 && area[nr][nc] < shark_size) {
                    pq.add(np);
                }
            }
        }
        if (pq.isEmpty()) {
            return false;
        } else {
            Point p = pq.poll();
            area[p.x][p.y] = 0;
            shark_x = p.x;
            shark_y = p.y;
            answer += p.dist;
            eat_cnt++;
            if (shark_size == eat_cnt) {
                shark_size++;
                eat_cnt = 0;
            }
            return true;
        }
    }

}