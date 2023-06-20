import java.io.*;
import java.util.*;

public class Main {
    static int[][] arr;
    static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int C = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int tc = 0; tc < C; tc++) {
            arr = new int[11][11];

            StringTokenizer st;
            for (int i = 0; i < 11; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 11; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            ans = 0;
            makeTeam(0, 0, 0);

            sb.append(ans).append("\n");
        }

        System.out.println(sb);
    }

    private static void makeTeam(int idx, int sum, int check) {
        if (idx == 11) {
            ans = Math.max(sum, ans);
            return;
        }

        for (int i = 0; i < 11; i++) {
            if (arr[idx][i] != 0 && (check & (1 << i)) == 0) {
                makeTeam(idx + 1, sum + arr[idx][i], check + (1 << i));
            }
        }
    }

}
