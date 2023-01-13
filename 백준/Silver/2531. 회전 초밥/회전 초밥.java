import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        int[] visit = new int[d + 1];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int cnt = 0;
        for (int i = 0; i < k; i++) {
            if (visit[arr[i]] == 0) {
                cnt++;
            }
            visit[arr[i]]++;
        }

        int ans = cnt;

        for (int i = 0; i < N; i++) {
            if (ans <= cnt) {
                if (visit[c] == 0) {
                    ans = cnt + 1;
                } else {
                    ans = cnt;
                }
            }

            if (visit[arr[i]] == 1) {
                cnt--;
            }
            visit[arr[i]]--;

            if (visit[arr[(i + k) % N]] == 0) {
                cnt++;
            }
            visit[arr[(i + k) % N]]++;
        }

        System.out.println(ans);

    }

}