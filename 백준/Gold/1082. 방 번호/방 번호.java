import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        int minIdx = -1;
        int min = 50;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if (min >= arr[i]) {
                min = arr[i];
                minIdx = i;
            }
        }

        int M = Integer.parseInt(br.readLine());

        int len = M / min;

        int sum = min * len;

        int[] ans = new int[len];
        for (int i = 0; i < len; i++) {
            ans[i] = minIdx;
        }

        int start = 0;
        for (int i = 0; i < len; i++) {
            for (int j = arr.length - 1; j >= minIdx; j--) {
                if (sum + arr[j] - min <= M) {
                    sum -= min;
                    sum += arr[j];
                    ans[i] = j;
                    break;
                }
            }
            if (ans[start] == 0) {
                start++;
                sum -= min;
            }
        }

        String res = "";
        boolean ansStart = false;
        for (int i = 0; i < len; i++) {
            if (!ansStart && ans[i] != 0) {
                ansStart = true;
            }
            if (ansStart || i == len - 1) {
                res += String.valueOf(ans[i]);
            }
        }

        System.out.println(res);

    }

}