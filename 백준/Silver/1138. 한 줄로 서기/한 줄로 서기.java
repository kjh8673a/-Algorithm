import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] ans = new int[N];
        for (int i = 0; i < N; i++) {
            int cnt = arr[i];
            for (int j = 0; j < N; j++) {
                if (ans[j] != 0) {
                    continue;
                }
                if (cnt == 0) {
                    ans[j] = i + 1;
                    break;
                }
                cnt--;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(ans[i] + " ");
        }

        System.out.println(sb);
    }

}
