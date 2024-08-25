import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] cross = new int[n];
        for (int i = 0; i < n; i++) {
            cross[i] = Integer.parseInt(st.nextToken());
        }

        long[] left = new long[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < n; i++) {
            left[i] = left[i - 1] + Long.parseLong(st.nextToken());
        }

        long[] right = new long[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < n; i++) {
            right[i] = right[i - 1] + Long.parseLong(st.nextToken());
        }

        int answerCross = 0;
        long answerDist = Long.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            long tmp = left[i] + cross[i] + right[n - 1] - right[i];
            if (answerDist > tmp) {
                answerCross = i + 1;
                answerDist = tmp;
            }
        }

        System.out.println(answerCross + " " + answerDist);
    }

}
