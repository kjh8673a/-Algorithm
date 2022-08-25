import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int cnt = 0;
        boolean check = false;
        for (int i = n - 1; i > 0; --i) {
            int target = i, max = arr[i];
            for (int j = i - 1; j >= 0; --j) {
                if (max < arr[j]) {
                    max = arr[j];
                    target = j;
                }
            }
            if (target != i) {
                int tmp = arr[i];
                arr[i] = arr[target];
                arr[target] = tmp;
                ++cnt;
                if (cnt == k) {
                    System.out.println(tmp + " " + arr[i]);
                    check = true;
                    break;
                }
            }
        }
        if (!check) {
            System.out.println(-1);
        }

    }

}