import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        long[] arr = new long[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < n + 1; i++) {
            arr[i] = Long.parseLong(st.nextToken()) + arr[i - 1];
        }

        StringBuilder sb = new StringBuilder();
        int diff = 0;
        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken());

            switch (type) {
                case 1:
                    int k1 = Integer.parseInt(st.nextToken());
                    diff = (diff + n - k1) % n;
                    break;
                case 2:
                    int k2 = Integer.parseInt(st.nextToken());
                    diff = (diff + k2) % n;
                    break;
                case 3:
                    int a = Integer.parseInt(st.nextToken());
                    int b = Integer.parseInt(st.nextToken());
                    a = (a + diff) % n;
                    b = (b + diff) % n;
                    if (a == 0) {
                        a += n;
                    }
                    if (b == 0) {
                        b += n;
                    }

                    long result = 0;
                    if (a <= b) {
                        result = arr[b] - arr[a - 1];
                    } else {
                        result += arr[n] - arr[a - 1];
                        result += arr[b];
                    }

                    sb.append(result).append("\n");
                    break;
            }
        }

        System.out.println(sb);
    }

}