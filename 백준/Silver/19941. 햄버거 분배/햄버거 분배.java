import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        char[] arr = br.readLine().toCharArray();
        boolean[] visit = new boolean[N];

        int ans = 0;
        for (int i = 0; i < N; i++) {
            if (arr[i] == 'P') {
                for (int j = Math.max(0, i - K); j < Math.min(i + K + 1, N); j++) {
                    if (arr[j] == 'H' && !visit[j]) {
                        visit[j] = true;
                        ans++;
                        break;
                    }
                }
            }
        }

        System.out.println(ans);
    }

}
