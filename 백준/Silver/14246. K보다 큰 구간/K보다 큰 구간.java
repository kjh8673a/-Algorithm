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
        int k = Integer.parseInt(br.readLine());

        long answer = 0;
        long sum = 0;
        int s = 0;
        int e = 0;
        while (true) {
            if (sum > k) {
                answer += (n - e + 1);
                sum -= arr[s++];
            } else if (e == n) {
                break;
            } else {
                sum += arr[e++];
            }
        }

        System.out.println(answer);
    }

}