import java.io.*;
import java.util.*;

public class Main {
    static int n, mp, mf, ms, mv, cost;
    static int[][] table;
    static boolean[] selected;
    static TreeSet<String> group;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        mp = Integer.parseInt(st.nextToken());
        mf = Integer.parseInt(st.nextToken());
        ms = Integer.parseInt(st.nextToken());
        mv = Integer.parseInt(st.nextToken());

        table = new int[n + 1][5];
        for (int i = 1; i < n + 1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                table[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        selected = new boolean[n + 1];
        cost = Integer.MAX_VALUE;
        group = new TreeSet<>();

        makeSet(1);

        if (group.size() > 0) {
            System.out.println(cost);
            System.out.println(group.first());
        } else {
            System.out.println(-1);
        }
    }

    private static void makeSet(int idx) {
        if (idx == n + 1) {
            calculate();
            return;
        }

        selected[idx] = true;
        makeSet(idx + 1);
        selected[idx] = false;
        makeSet(idx + 1);
    }

    private static void calculate() {
        int p = 0;
        int f = 0;
        int s = 0;
        int v = 0;
        int total = 0;

        for (int i = 1; i < n + 1; i++) {
            if (selected[i]) {
                p += table[i][0];
                f += table[i][1];
                s += table[i][2];
                v += table[i][3];
                total += table[i][4];
            }
        }

        if (p >= mp && f >= mf && s >= ms && v >= mv) {
            StringBuilder sb = new StringBuilder();
            for (int i = 1; i < n + 1; i++) {
                if (selected[i]) {
                    sb.append(i + " ");
                }
            }
            if (cost > total) {
                cost = total;
                group = new TreeSet<>();
                group.add(sb.toString());
            } else if (cost == total) {
                group.add(sb.toString());
            }
        }
    }

}