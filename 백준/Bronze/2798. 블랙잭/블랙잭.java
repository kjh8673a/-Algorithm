import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int answer = 0;
        loop: for (int i = 0; i < n - 2; i++) {
            if (arr[i] > m) {
                continue;
            }
            for (int j = i + 1; j < n - 1; j++) {
                if (arr[i] + arr[j] > m) {
                    continue;
                }
                for (int k = j + 1; k < n; k++) {
                    int sum = arr[i] + arr[j] + arr[k];
                    if (sum <= m) {
                        answer = Math.max(answer, sum);
                    }

                    if (answer == m) {
                        break loop;
                    }
                }
            }
        }

        System.out.println(answer);
    }

}