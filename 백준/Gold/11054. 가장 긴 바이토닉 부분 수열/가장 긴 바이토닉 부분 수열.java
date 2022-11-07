import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[] arr, dpUp, dpDown;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        arr = new int[n];
        dpUp = new int[n];
        dpDown = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 왼쪽에서 오른쪽으로 가는 DP
        for (int i = 0; i < n; i++) {
            dodpUp(i);
        }
        // 오른쪽에서 왼쪽으로 가는 DP
        for (int i = n - 1; i >= 0; i--) {
            dodpDown(i);
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            // 왼쪽에서 오는 dp, 오른쪽에서 오는 dp의 값을 더한다
            int max1 = dpUp[0];
            for (int j = 0; j <= i; j++) {
                max1 = Math.max(max1, dpUp[j]);
            }

            int max2 = dpDown[n - 1];
            for (int j = n - 1; j >= i; j--) {
                max2 = Math.max(max2, dpDown[j]);
            }

            ans = Math.max(ans, max1 + max2 - 1);
            
        }

        System.out.println(ans);

    }

    public static int dodpUp(int idx) {

        if (dpUp[idx] == 0) {
            dpUp[idx] = 1;

            for (int i = idx - 1; i >= 0; i--) {
                if (arr[i] < arr[idx]) {
                    dpUp[idx] = Math.max(dpUp[idx], dodpUp(i) + 1);
                }
            }

        }

        return dpUp[idx];

    }

    public static int dodpDown(int idx) {

        if (dpDown[idx] == 0) {
            dpDown[idx] = 1;

            for (int i = idx; i < n; i++) {
                if (arr[i] < arr[idx]) {
                    dpDown[idx] = Math.max(dpDown[idx], dodpDown(i) + 1);
                }
            }

        }

        return dpDown[idx];

    }
}