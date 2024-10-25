import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] sample;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        sample = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            sample[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());

        int[][] testCases = new int[m][n];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                testCases[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int count = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            if (checkForward(testCases[i]) || checkReverse(testCases[i])) {
                for (int j = 0; j < n; j++) {
                    sb.append(testCases[i][j] + " ");
                }
                sb.append("\n");
                count++;
            }
        }

        System.out.println(count);
        System.out.println(sb.toString());
    }

    private static boolean checkReverse(int[] arr) {
        int[] tmp = new int[n];
        int idx = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (arr[i] == 1) {
                tmp[idx++] = 3;
            } else if (arr[i] == 2) {
                tmp[idx++] = 4;
            } else if (arr[i] == 3) {
                tmp[idx++] = 1;
            } else {
                tmp[idx++] = 2;
            }
        }

        if (checkForward(tmp)) {
            return true;
        }

        return false;
    }

    private static boolean checkForward(int[] arr) {
        loop: for (int i = 0; i < n; i++) {
            if (arr[i] == sample[0]) {
                int idx = 1;
                for (int j = i + 1; j < n; j++) {
                    if (arr[j] != sample[idx++]) {
                        continue loop;
                    }
                }
                for (int j = 0; j < i; j++) {
                    if (arr[j] != sample[idx++]) {
                        continue loop;
                    }
                }

                if (idx == n) {
                    return true;
                }
            }
        }

        return false;
    }

}