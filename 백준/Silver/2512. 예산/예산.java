import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[N];
        int sum = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sum += arr[i];
        }

        M = Integer.parseInt(br.readLine());

        Arrays.sort(arr);

        if (M >= sum) {
            System.out.println(arr[N - 1]);
        } else {
            System.out.println(find(0, sum));
        }

    }

    private static int find(int a, int b) {
        int left = a;
        int right = b;

        int mid = 0;
        while (left < right) {
            mid = (left + right) / 2;
            if (left == mid || left == right) {
                break;
            }

            int sum = cal(mid);
            if (sum == M) {
                break;
            } else if (sum < M) {
                left = mid;
            } else {
                right = mid;
            }
        }

        return mid;
    }

    private static int cal(int mid) {
        int sum = 0;

        for (int i = 0; i < N; i++) {
            if (arr[i] >= mid) {
                sum += mid;
            } else {
                sum += arr[i];
            }
        }

        return sum;
    }

}
