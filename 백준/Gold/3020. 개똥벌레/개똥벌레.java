import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        int[] arr = new int[H + 1];
        for (int i = 0; i < N; i++) {
            int a = Integer.parseInt(br.readLine());
            if (i % 2 == 0) {
                arr[a]++;
            } else {
                arr[H - a]--;
                arr[H]++;
            }
        }

        for (int i = H - 1; i > 0; i--) {
            arr[i] += arr[i + 1];
        }

        Arrays.sort(arr);

        int min = arr[1];
        int cnt = 0;

        int idx = 1;
        while (arr[idx++] == min) {
            cnt++;
        }

        System.out.println(min + " " + cnt);
    }

}