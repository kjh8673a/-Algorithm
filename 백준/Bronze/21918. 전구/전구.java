import java.io.*;
import java.util.*;

public class Main {
    static int[] bulbs;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        bulbs = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            bulbs[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (a == 1) {
                changeSingleBulb(b - 1, c);
            } else if (a == 2) {
                chageGroupBulbs(b - 1, c - 1);
            } else if (a == 3) {
                offGroupBulbs(b - 1, c - 1);
            } else {
                onGroupBulbs(b - 1, c - 1);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(bulbs[i] + " ");
        }

        System.out.println(sb.toString());
    }

    private static void onGroupBulbs(int l, int r) {
        for (int i = l; i <= r; i++) {
            bulbs[i] = 1;
        }
    }

    private static void offGroupBulbs(int l, int r) {
        for (int i = l; i <= r; i++) {
            bulbs[i] = 0;
        }
    }

    private static void chageGroupBulbs(int l, int r) {
        for (int i = l; i <= r; i++) {
            bulbs[i] = Math.abs(bulbs[i] - 1);
        }
    }

    private static void changeSingleBulb(int i, int x) {
        bulbs[i] = x;
    }

}