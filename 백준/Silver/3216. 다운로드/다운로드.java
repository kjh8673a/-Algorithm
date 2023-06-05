import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] table = new int[N][2];
        int len = 0;
        int time = 0;
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            table[i][0] = Integer.parseInt(st.nextToken());
            table[i][1] = Integer.parseInt(st.nextToken());
            if (i != N - 1) {
                len += table[i][0];
            }
            time += table[i][1];
        }

        int ans = 0;
        for (int i = N - 1; i >= 0; i--) {
            ans = Math.max(time - len, ans);
            if(i > 0) {
                time -= table[i][1];
                len -= table[i - 1][0];
            }
        }

        System.out.println(ans);

    }
}
