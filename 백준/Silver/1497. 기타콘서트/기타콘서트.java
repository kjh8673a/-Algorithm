import java.util.*;
import java.io.*;

public class Main {

    static int N, M, max, ans;
    static boolean[][] guitar;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        guitar = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String song = st.nextToken();

            for (int j = 0; j < M; j++) {
                if (song.charAt(j) == 'Y') {
                    guitar[i][j] = true;
                }
            }
        }

        max = 0;
        ans = -1;

        combi();

        System.out.println(ans);
    }

    private static void combi() {
        for (int i = 1; i < (1 << N); i++) {
            int sel = 0;
            for (int j = 0; j < N; j++) {
                if ((i & (1 << j)) != 0) {
                    sel |= (1 << j);
                }
            }

            countSong(sel);
        }
    }

    private static void countSong(int sel) {
        boolean[] tmp = new boolean[M];
        for (int i = 0; i < N; i++) {
            if ((sel & (1 << i)) != 0) {
                for (int j = 0; j < M; j++) {
                    if (guitar[i][j]) {
                        tmp[j] = true;
                    }
                }
            }
        }

        int cnt = 0;
        for (int i = 0; i < M; i++) {
            if (tmp[i]) {
                cnt++;
            }
        }

        if (cnt == max) {
            ans = Math.min(ans, Integer.bitCount(sel));
        } else if (cnt > max) {
            max = cnt;
            ans = Integer.bitCount(sel);
        }
    }

}