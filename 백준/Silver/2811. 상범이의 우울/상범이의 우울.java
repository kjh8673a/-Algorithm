import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n + 1];
        int max = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i < n + 1; i++) {
            int a = Integer.parseInt(st.nextToken());
            if (a < 0) {
                arr[i] += arr[i - 1] + 1;
                max = Math.max(arr[i], max);
            }
        }

        int answer = 0;
        boolean[] flower = new boolean[n + 1];
        int len = 0;
        for (int i = n; i >= 1; i--) {
            if (len == 0 && arr[i] > 0) {
                len = arr[i];
            }

            if (arr[i] == 1) {
                for (int j = i - 1; j >= i - 2 * len; j--) {
                    if (j < 1 || flower[j]) {
                        continue;
                    }
                    flower[j] = true;
                    answer++;
                }
                len = 0;
            }
        }

        int add = 0;
        for (int i = n; i >= 1; i--) {
            if (arr[i] == max) {
                int tmp = 0;
                for (int j = i - max; j >= i - max - 3 * max + 1; j--) {
                    if (j < 1 || flower[j]) {
                        continue;
                    }
                    tmp++;
                }
                add = Math.max(tmp, add);
            }
        }

        System.out.println(answer + add);
    }

}