import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] arr = new long[N];
        long sum = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
            sum += arr[i]; // 처음부터 끝까지 한바퀴는 돌아야함
        }

        long value = Math.max(arr[0], 0); // 인덱스별로 구한 부분합
        long[] forward = new long[N]; // 최종적으로 값을 담을 dp배열
        forward[0] = Math.max(arr[0], 0);
        for (int i = 1; i < N; i++) {
            value = Math.max(value + arr[i], arr[i]); // 현재 인덱스의 값과 이전까지의 최대값을 더해서 비교 -> 현재까지의 최대값
            forward[i] = Math.max(forward[i - 1], value); // dp배열에 이전 dp배열의 값과 현재 value값을 비교해서 넣어줌
        }

        value = Math.max(arr[N - 1], 0);
        long[] reverse = new long[N]; // 뒤에서부터 앞으로 더하며 값을 담을 dp배열
        reverse[N - 1] = Math.max(arr[N - 1], 0);
        for (int i = N - 2; i >= 0; i--) {
            value = Math.max(value + arr[i], arr[i]);
            reverse[i] = Math.max(reverse[i + 1], value);
        }

        long max = 0;
        for (int i = 0; i < N - 1; i++) { // [0 ~ i], [i + 1 ~ N - 1] 두 구간으로 나누어 forward와 reverse의 합의 최대값을 구한다
            max = Math.max(forward[i] + reverse[i + 1], max);
        }

        long ans = sum + max;
        System.out.println(ans);
    }

}