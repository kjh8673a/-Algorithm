import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        boolean[] check = new boolean[1000001];
        int max = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            check[arr[i]] = true;
            max = Math.max(max, arr[i]);
        }

        int[] ans = new int[1000001];
        for (int i = 0; i < N; i++) {
            for (int j = arr[i] + arr[i]; j <= max; j += arr[i]) {
                if (check[j]) {
                    ans[arr[i]]++;
                    ans[j]--;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(ans[arr[i]] + " ");
        }
        System.out.println(sb);

    }
}
