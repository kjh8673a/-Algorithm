import java.util.*;
import java.io.*;

public class Main {

    static int N, K, ans;
    static String[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new String[N];
        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine();
        }

        int check = 0;
        check += 1 << ('a' - 97);
        check += 1 << ('n' - 97);
        check += 1 << ('t' - 97);
        check += 1 << ('i' - 97);
        check += 1 << ('c' - 97);

        ans = 0;
        if (K == 26) {
            ans = N;
        } else if (K >= 5) {
            combi(check, 0);
        }

        System.out.println(ans);
    }

    private static void combi(int check, int idx) {
        if (Integer.bitCount(check) == K) {
            countReadable(check);
            return;
        }

        for (int i = idx; i < 26; i++) {
            if ((check & (1 << i)) == 0) {
                combi(check + (1 << i), i + 1);
            }
        }
    }

    private static void countReadable(int check) {
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            boolean flag = true;
            for (int j = 4; j < arr[i].length() - 4; j++) {
                if ((check & (1 << arr[i].charAt(j) - 97)) == 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                cnt++;
            }
        }

        ans = Math.max(ans, cnt);
    }
}