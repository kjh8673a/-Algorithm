import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());

            int[] arr = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr);

            int[] tmp = new int[N];

            if (N % 2 != 0) {
                int mid = N / 2;
                int len = 1;
                int start = N - 1;
                int idx = 1;

                tmp[mid] = arr[start];
                int cnt = 1;
                while (cnt < N) {
                    tmp[mid + len] = arr[start - idx];
                    idx++;
                    cnt++;

                    tmp[mid - len] = arr[start - idx];
                    idx++;
                    cnt++;

                    len++;
                }
            } else {
                int mid1 = N / 2 - 1;
                int mid2 = N / 2;

                int len = 1;
                int start = N - 1;
                int idx = 2;

                tmp[mid2] = arr[start];
                tmp[mid1] = arr[start - 1];

                int cnt = 2;
                while (cnt < N) {
                    tmp[mid2 + len] = arr[start - idx];
                    idx++;
                    cnt++;
                    tmp[mid1 - len] = arr[start - idx];
                    idx++;
                    cnt++;

                    len++;
                }
            }

            int ans = Math.abs(tmp[N-1] - tmp[0]);

            for(int i = 1; i < N; i++) {
                ans = Math.max(ans, Math.abs(tmp[i] - tmp[i-1]));
            }

            sb.append(ans).append("\n");
        }

        System.out.println(sb);
    }

}