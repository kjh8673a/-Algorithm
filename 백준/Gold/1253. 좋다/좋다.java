import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int ans = 0;
        for (int i = 0; i < N; i++) {
            if (binary(0, N - 1, i)) {
                ans++;
            }
        }

        System.out.println(ans);

    }

    public static boolean binary(int a, int b, int c) {
        int left = a;
        int right = b;
        int key = arr[c];
        while (left < right) {
            if (arr[left] + arr[right] < key) {
                left++;
            } else if (arr[left] + arr[right] > key) {
                right--;
            } else {
                if (left == c) {
                    left++;
                } else if (right == c) {
                    right--;
                } else {
                    return true;
                }
            }
        }

        return false;

    }

}