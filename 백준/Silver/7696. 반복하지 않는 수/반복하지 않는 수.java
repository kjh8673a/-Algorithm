import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[1000001];
        int[] count = new int[10];
        int num = 1;
        int idx = 1;
        while (idx <= 1000000) {
            for (int i = 0; i < 10; i++) {
                count[i] = 0;
            }
            int now = num;
            while (now > 0) {
                if (count[now % 10] > 0) {
                    break;
                }
                count[now % 10]++;
                now /= 10;
            }
            if (now == 0) {
                arr[idx++] = num++;
            } else {
                num++;
            }
        }

        StringBuilder sb = new StringBuilder();
        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) {
                break;
            }
            sb.append(arr[n]).append("\n");
        }

        System.out.println(sb);
    }

}
