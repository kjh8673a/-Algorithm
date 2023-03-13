import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int len = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int a = Integer.parseInt(st.nextToken());
            arr[i] = a;
            len += a;
        }

        int ans = 0;
        int left = 0;
        int right = n - 1;
        for (int i = 0; i < n - 1; i++) {
            if (arr[left] < arr[right]) {
                len -= arr[left];
                ans += arr[left] * len;
                left++;
            } else {
                len -= arr[right];
                ans += arr[right] * len;
                right--;
            }
        }

        System.out.println(ans);

    }
}