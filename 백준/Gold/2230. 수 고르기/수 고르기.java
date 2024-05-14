import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        int start = 0;
        int end = 0;
        int answer = Integer.MAX_VALUE;
        while (start <= end && end < n) {
            int dist = arr[end] - arr[start];

            if (dist < m) {
                end++;
            } else {
                answer = Math.min(answer, dist);
                start++;
            }
        }

        System.out.println(answer);
    }

}