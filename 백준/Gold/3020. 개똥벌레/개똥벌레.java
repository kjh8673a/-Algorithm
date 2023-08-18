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

        int min = Integer.MAX_VALUE;
        int cnt = 0;
        for (int i = 1; i < H + 1; i++) {
            if (arr[i] < min) {
                min = arr[i];
                cnt = 1;
            } else if (arr[i] == min) {
                cnt++;
            }
        }

        System.out.println(min + " " + cnt);
    }

}