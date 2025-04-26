import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] tmp = new int[r - l + 1];
        for (int i = l - 1; i < r; i++) {
            tmp[i - (l - 1)] = arr[i];
        }
        Arrays.sort(tmp);

        for (int i = l - 1; i < r; i++) {
            arr[i] = tmp[i - (l - 1)];
        }

        boolean flag = true;
        int prev = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] >= prev) {
                prev = arr[i];
            } else {
                flag = false;
                break;
            }
        }

        System.out.println(flag ? 1 : 0);
    }

}