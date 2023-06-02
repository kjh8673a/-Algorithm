import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int ans = 0;
        for (int i = 1; i < (1 << N); i++) {
            int len = 0;
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            int sum = 0;

            for (int j = 0; j < N; j++) {
                if ((i & (1 << j)) != 0) {
                    len++;
                    max = Math.max(arr[j], max);
                    min = Math.min(arr[j], min);
                    sum += arr[j];
                }
            }

            if (len == 1) { // 문제는 두 문제 이상이어야 한다
                continue;
            }
            if (sum < L || sum > R) { // 문제 난이도의 합은 L보다 크거나 같고, R보다 작거나 같아야 한다
                continue;
            }
            if (max - min < X) { // 가장 어려운 문제와 가장 쉬운 문제의 난이도 차이는 X보다 크거나 같아야 한다
                continue;
            }

            ans++;

        }

        System.out.println(ans);

    }

}