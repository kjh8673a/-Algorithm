import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int start = 0;
        int end = 1_000_000_001;
        int answer = 0;

        while (start <= end) {
            int mid = (start + end) / 2;
            long tmp = 0;
            for (int level : arr) {
                if (mid > level) {
                    tmp += mid - level;
                }
            }

            if (K >= tmp) {
                answer = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        System.out.println(answer);
    }

}