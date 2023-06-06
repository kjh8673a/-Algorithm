import java.io.*;
import java.util.*;

public class Main {
    static int N, K;
    static int[][] table;
    static int[] kyunghee, minho, jiwoo, win, idx;
    static boolean[] visit;
    static boolean flag;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        table = new int[N + 1][N + 1];
        for (int i = 1; i < N + 1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < N + 1; j++) {
                table[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        kyunghee = new int[20];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 20; i++) {
            kyunghee[i] = Integer.parseInt(st.nextToken());
        }

        minho = new int[20];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 20; i++) {
            minho[i] = Integer.parseInt(st.nextToken());
        }

        flag = false;
        jiwoo = new int[N + 1];
        visit = new boolean[N + 1];
        makeJiwoo(0);

        System.out.println(flag ? 1 : 0);

    }

    private static void makeJiwoo(int cnt) {
        if (flag) {
            return;
        }
        if (cnt == N) {
            win = new int[3];
            idx = new int[3];
            game(0, 1);
            return;
        }
        for (int i = 1; i < N + 1; i++) {
            if (visit[i]) {
                continue;
            }
            visit[i] = true;
            jiwoo[cnt] = i;
            makeJiwoo(cnt + 1);
            visit[i] = false;
        }
    }

    private static void game(int a, int b) {
        if (win[0] >= K) {
            flag = true;
            return;
        }

        if (idx[0] >= N || win[1] >= K || win[2] >= K) {
            return;
        }

        int nextPlayer = 0;
        for (int i = 0; i < 3; i++) {
            if (a != i && b != i) {
                nextPlayer = i;
                break;
            }
        }
        int p1 = 0;
        switch (a) {
            case 0:
                p1 = jiwoo[idx[0]++];
                break;
            case 1:
                p1 = kyunghee[idx[1]++];
                break;
            case 2:
                p1 = minho[idx[2]++];
        }

        int p2 = 0;
        switch (b) {
            case 0:
                p2 = jiwoo[idx[0]++];
                break;
            case 1:
                p2 = kyunghee[idx[1]++];
                break;
            case 2:
                p2 = minho[idx[2]++];
        }

        int result = table[p1][p2];

        if (result == 2) {
            win[a]++;
            game(a, nextPlayer);
        } else if (result == 0) {
            win[b]++;
            game(nextPlayer, b);
        } else {
            if (a > b) {
                win[a]++;
                game(a, nextPlayer);
            } else {
                win[b]++;
                game(nextPlayer, b);
            }
        }

    }
}
