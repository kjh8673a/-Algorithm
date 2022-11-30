import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] result;
    static long[] arr;
    static long min;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        arr = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(arr);

        result = new int[3];
        min = Long.MAX_VALUE;
        for (int i = 0; i < N - 2; i++) {
            solve(i, i + 1, N - 1);
        }

        Arrays.sort(result);

        System.out.println(arr[result[0]] + " " + arr[result[1]] + " " + arr[result[2]]);

    }

    public static void solve(int a, int b, int c) {
        int left = b;
        int right = c;
        while (left < right) {
            long sum = arr[a] + arr[left] + arr[right];

            if (Math.abs(sum) < min) {
                min = Math.abs(sum);
                result[0] = a;
                result[1] = left;
                result[2] = right;
            }

            if (sum < 0) {
                left++;
            } else {
                right--;
            }
        }
    }

}