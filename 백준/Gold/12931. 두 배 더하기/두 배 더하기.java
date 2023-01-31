import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int tmp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        int ans = 0;
        tmp = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if (arr[i] > 0) {
                ans = Math.max(ans, cal(arr[i]));
            }
        }

        System.out.println(ans + tmp);

    }

    public static int cal(int num) {
        int val = 0;

        while (num > 0) {
            if (num % 2 == 0) {
                val++;
                num /= 2;
            } else {
                tmp++;
                num--;
            }
        }

        return val;
    }

}