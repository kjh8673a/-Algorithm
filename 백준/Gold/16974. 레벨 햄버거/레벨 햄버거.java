import java.io.*;
import java.util.*;

public class Main {
    static long[] len, patty;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        long x = Long.parseLong(st.nextToken());

        len = new long[n + 1];
        len[0] = 1;

        patty = new long[n + 1];
        patty[0] = 1;

        for (int i = 1; i < n + 1; i++) {
            len[i] = (len[i - 1] * 2) + 3;
            patty[i] = (patty[i - 1] * 2) + 1;
        }

        long answer = eatBurger(n, x);
        System.out.println(answer);
    }

    private static long eatBurger(int level, long x) {
        if (level == 0) {
            return 1;
        }

        if (x == 1) {
            return 0;
        }

        long mid = len[level] / 2 + 1;
        if (x == len[level]) {
            return patty[level];
        } else if (x < mid) {
            return eatBurger(level - 1, x - 1);
        } else if (x == mid) {
            return patty[level] / 2 + 1;
        } else {
            return patty[level - 1] + 1 + eatBurger(level - 1, x - mid);
        }
    }

}