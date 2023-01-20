import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        int prev = 0;
        int tmp = 0;
        int idx = 0;
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (num == 1) {
                if (prev == 0) {
                    prev = num;
                    tmp += 1;
                } else if (prev == num) {
                    tmp += 1;
                } else {
                    arr[idx++] = tmp;
                    tmp = 0;
                    prev = num;
                    tmp += 1;
                }
            } else {
                if (prev == 0) {
                    prev = -1;
                    tmp -= 1;
                } else if (prev == -1) {
                    tmp -= 1;
                } else {
                    arr[idx++] = tmp;
                    tmp = 0;
                    prev = -1;
                    tmp -= 1;
                }
            }

            if (i == N - 1) {
                arr[idx++] = tmp;
            }
        }

        int ans = 0;

        for (int i = 0; i < idx; i++) {
            int sum = 0;
            for (int j = i; j >= 0; j--) {
                sum += arr[j];
                ans = Math.max(ans, Math.abs(sum));
            }
        }

        System.out.println(ans);

    }

}
