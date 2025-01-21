import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        int max = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(arr[i], max);
        }

        boolean[] prime = new boolean[max + 1];
        prime[0] = true;
        prime[1] = true;
        for (int i = 2; i <= Math.sqrt(max); i++) {
            if (prime[i]) {
                continue;
            }

            for (int j = i * i; j < max + 1; j += i) {
                prime[j] = true;
            }
        }

        int answer = 0;
        for (int i = 0; i < n; i++) {
            if (!prime[arr[i]]) {
                answer++;
            }
        }

        System.out.println(answer);
    }

}