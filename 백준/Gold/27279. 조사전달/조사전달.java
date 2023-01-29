import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] soldier = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            soldier[i] = Integer.parseInt(st.nextToken());
        }

        int[] work = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            work[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(soldier);
        Arrays.sort(work);

        int start = 0;
        for (int i = 0; i < N; i++) {
            int now = 0;
            for (int j = start; j < soldier[i]; j++) {
                if (j == soldier[i] - 1) {
                    work[j]--;
                    now = j;
                    break;
                }

                if (work[j] <= 0) {
                    continue;
                } else {
                    work[j]--;
                    now = j;
                    break;
                }
            }
            if(work[now] <= 0) {
                start = now + 1;
            }
        }

        boolean ok = true;
        for (int i = 0; i < M; i++) {
            if (work[i] > 0) {
                ok = false;
                break;
            }
        }

        System.out.println(ok ? "YES" : "NO");

    }

}