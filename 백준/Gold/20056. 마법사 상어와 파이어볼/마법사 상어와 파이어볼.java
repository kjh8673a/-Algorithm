import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static class Node implements Comparable<Node> {
        int r;
        int c;
        int m;
        int s;
        int d;

        public Node(int r, int c, int m, int s, int d) {
            this.r = r;
            this.c = c;
            this.m = m;
            this.s = s;
            this.d = d;
        }

        @Override
        public int compareTo(Node o) {
            if (this.r != o.r) {
                return this.r - o.r;
            } else {
                return this.c - o.c;
            }
        }
    }

    static int[] dr = { -1, -1, 0, 1, 1, 1, 0, -1 };
    static int[] dc = { 0, 1, 1, 1, 0, -1, -1, -1 };

    static int N, M, K;
    static PriorityQueue<Node> list, tmp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        list = new PriorityQueue<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            list.add(new Node(r, c, m, s, d));
        }

        action(K);

    }

    public static void action(int cnt) {
        if (cnt == 0) {
            int sum = 0;
            while (!list.isEmpty()) {
                sum += list.poll().m;
            }

            System.out.println(sum);
            return;
        }

        tmp = new PriorityQueue<>();

        int len = list.size();
        for (int i = 0; i < len; i++) {
            Node now = list.poll();
            int r = now.r;
            int c = now.c;
            int m = now.m;
            int s = now.s;
            int d = now.d;

            int nr = (r + dr[d] * s) % N;
            int nc = (c + dc[d] * s) % N;
            if (nr <= 0) {
                nr += N;
            }
            if (nc <= 0) {
                nc += N;
            }

            tmp.add(new Node(nr, nc, m, s, d));
        }

        check(cnt);
    }

    public static void check(int cnt) {
        int prev_r = 0;
        int prev_c = 0;
        int prev_m = 0;
        int prev_s = 0;
        int prev_d = 0;

        int sum_cnt = 0;
        int sum_m = 0;
        int sum_s = 0;
        boolean isSame = true;

        if (!tmp.isEmpty()) {
            Node f = tmp.poll();
            prev_r = f.r;
            prev_c = f.c;
            prev_m = f.m;
            prev_s = f.s;
            prev_d = f.d;

            sum_cnt = 1;
            sum_m = f.m;
            sum_s = f.s;
        }

        while (!tmp.isEmpty()) {
            Node now = tmp.poll();

            if (now.r == prev_r && now.c == prev_c) {
                sum_cnt++;
                sum_m += now.m;
                sum_s += now.s;
                if ((prev_d + now.d) % 2 == 1) {
                    isSame = false;
                }
            } else {
                seperate(prev_r, prev_c, prev_m, prev_s, prev_d, sum_cnt, sum_m, sum_s, isSame);
                prev_r = now.r;
                prev_c = now.c;
                prev_m = now.m;
                prev_s = now.s;
                prev_d = now.d;

                sum_cnt = 1;
                sum_m = now.m;
                sum_s = now.s;
                isSame = true;
            }
        }

        seperate(prev_r, prev_c, prev_m, prev_s, prev_d, sum_cnt, sum_m, sum_s, isSame);

        action(cnt - 1);

    }

    public static void seperate(int r, int c, int m, int s, int d, int sum_cnt, int sum_m, int sum_s, boolean isSame) {
        if (sum_cnt == 1) {
            list.add(new Node(r, c, m, s, d));
            return;
        }

        int nm = sum_m / 5;
        if (nm == 0) {
            return;
        }

        int ns = sum_s / sum_cnt;

        if (isSame) {
            list.add(new Node(r, c, nm, ns, 0));
            list.add(new Node(r, c, nm, ns, 2));
            list.add(new Node(r, c, nm, ns, 4));
            list.add(new Node(r, c, nm, ns, 6));
        } else {
            list.add(new Node(r, c, nm, ns, 1));
            list.add(new Node(r, c, nm, ns, 3));
            list.add(new Node(r, c, nm, ns, 5));
            list.add(new Node(r, c, nm, ns, 7));
        }
    }

}