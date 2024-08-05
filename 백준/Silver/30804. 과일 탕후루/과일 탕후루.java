import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] count = new int[10];
        int answer = 0;
        int s = 0;
        int e = 0;
        int cnt = 0;
        while (e < n) {
            if (cnt <= 2) {
                if (count[arr[e]] == 0) {
                    cnt++;
                }
                count[arr[e++]]++;
            }
            while (cnt > 2) {
                if (count[arr[s]] == 1) {
                    cnt--;
                }
                count[arr[s++]]--;
            }

            answer = Math.max(answer, e - s);
        }

        System.out.println(answer);
    }

}