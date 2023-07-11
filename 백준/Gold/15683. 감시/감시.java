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

    static int N, M, zero, ans;
    static int[][] room, tmp;
    static List<Node> list;
    static int[] direction;

    static int[][] vector = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        room = new int[N][M];
        zero = 0;
        list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                room[i][j] = Integer.parseInt(st.nextToken());
                if (room[i][j] == 0) {
                    zero++;
                } else if (room[i][j] < 6) {
                    list.add(new Node(i, j));
                }
            }
        }

        ans = Integer.MAX_VALUE;
        direction = new int[list.size()];
        makeDirection(0);

        System.out.println(ans);
    }

    private static void makeDirection(int idx) {
        if (idx == list.size()) {
            check();
            return;
        }

        Node node = list.get(idx);

        direction[idx] = 0;
        makeDirection(idx + 1);

        if (room[node.r][node.c] != 5) {
            direction[idx] = 1;
            makeDirection(idx + 1);
        }

        if (room[node.r][node.c] != 2 && room[node.r][node.c] != 5) {
            direction[idx] = 2;
            makeDirection(idx + 1);
            direction[idx] = 3;
            makeDirection(idx + 1);
        }
    }

    private static void check() {
        tmp = new int[N][M];
        for (int i = 0; i < N; i++) {
            tmp[i] = room[i].clone();
        }

        int cnt = 0;
        for (int i = 0; i < list.size(); i++) {
            Node node = list.get(i);
            int num = room[node.r][node.c];
            int dir = direction[i];

            switch (num) {
                case 1:
                    cnt += cctv(dir, node.r, node.c);
                    break;
                case 2:
                    cnt += cctv(dir, node.r, node.c);
                    cnt += cctv(dir + 2, node.r, node.c);
                    break;
                case 3:
                    cnt += cctv(dir, node.r, node.c);
                    cnt += cctv((dir + 1) % 4, node.r, node.c);
                    break;
                case 4:
                    cnt += cctv(dir, node.r, node.c);
                    cnt += cctv((dir + 1) % 4, node.r, node.c);
                    cnt += cctv((dir + 2) % 4, node.r, node.c);
                    break;
                case 5:
                    cnt += cctv(dir, node.r, node.c);
                    cnt += cctv(dir + 1, node.r, node.c);
                    cnt += cctv(dir + 2, node.r, node.c);
                    cnt += cctv(dir + 3, node.r, node.c);
                    break;
            }
        }

        ans = Math.min(ans, zero - cnt);
    }

    private static int cctv(int type, int r, int c) {
        int result = 0;

        int nr = r;
        int nc = c;
        while (true) {
            nr += vector[type][0];
            nc += vector[type][1];

            if (nr < 0 || nc < 0 || nr >= N || nc >= M || tmp[nr][nc] == 6) {
                break;
            }
            if (tmp[nr][nc] == 0 && tmp[nr][nc] != -1) {
                result++;
                tmp[nr][nc] = -1;
            }
        }

        return result;
    }
}
