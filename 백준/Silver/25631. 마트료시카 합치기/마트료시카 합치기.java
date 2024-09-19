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
        Arrays.sort(arr);

        int answer = 1;
        int count = 1;
        int prev = arr[0];
        for (int i = 1; i < n; i++) {
            if (arr[i] == prev) {
                count++;
                answer = Math.max(answer, count);
            } else {
                count = 1;
                prev = arr[i];
            }
        }

        System.out.println(answer);
    }

}