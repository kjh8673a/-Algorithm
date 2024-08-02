import java.io.*;
import java.util.*;

public class Main {
    static int n, answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int answer = 0;
        int s = 0;
        int e = 0;
        int oddCount = 0;
        int len = 0;
        while (e < n) {
            if (arr[e] % 2 == 0) {
                len++;
                e++;
            } else {
                while (oddCount >= k) {
                    if (arr[s] % 2 != 0) {
                        oddCount--;
                        s++;
                    } else {
                        len--;
                        s++;
                    }
                }
                oddCount++;
                e++;
            }

            answer = Math.max(len, answer);
        }

        System.out.println(answer);
    }

}