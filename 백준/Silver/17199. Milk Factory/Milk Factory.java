import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N + 1][N + 1];
        StringTokenizer st;
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a][b] = 1;
        }

        for (int k = 1; k < N + 1; k++) {
            for (int i = 1; i < N + 1; i++) {
                for (int j = 1; j < N + 1; j++) {
                    if (arr[i][k] == 1 && arr[k][j] == 1) {
                        arr[i][j] = 1;
                    }
                }
            }
        }

        int ans = Integer.MAX_VALUE;
        loop: for (int i = 1; i < N + 1; i++) {
            arr[i][i] = 1;
            for (int j = 1; j < N + 1; j++) {
                if (arr[j][i] != 1) {
                    continue loop;
                }
            }
            ans = i;
            break;
        }

        System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
    }

}
