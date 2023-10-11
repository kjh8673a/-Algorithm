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

        long ans = 0;
        boolean[] visit = new boolean[100001];
        int end = 0;
        for (int start = 0; start < N; start++) {
            while (end < N && !visit[arr[end]]) {
                visit[arr[end]] = true;
                end++;
            }
            ans += end - start;
            visit[arr[start]] = false;
        }

        System.out.println(ans);
    }

}
