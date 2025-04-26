import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arrA = new int[n];
        for (int i = 0; i < n; i++) {
            arrA[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int[] arrB = new int[n];
        for (int i = 0; i < n; i++) {
            arrB[i] = Integer.parseInt(st.nextToken());
        }

        int answer = 0;
        if (checkSame(arrA, arrB)) {
            answer = 1;
        }

        for (int i = n; i > 1 && answer == 0; i--) {
            int max = 0;
            int maxIdx = 0;
            for (int j = 0; j < i; j++) {
                if (arrA[j] > max) {
                    max = arrA[j];
                    maxIdx = j;
                }
            }

            int tmp = arrA[i - 1];
            arrA[i - 1] = max;
            arrA[maxIdx] = tmp;

            if (checkSame(arrA, arrB)) {
                answer = 1;
            }
        }

        System.out.println(answer);
    }

    private static boolean checkSame(int[] a, int[] b) {
        boolean isSame = true;
        for (int j = 0; j < a.length; j++) {
            if (a[j] != b[j]) {
                isSame = false;
            }
        }

        return isSame;
    }
}