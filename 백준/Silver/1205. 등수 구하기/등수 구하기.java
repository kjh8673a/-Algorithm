import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int score = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        Integer[] arr = new Integer[n];
        if (n != 0) {
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr, Collections.reverseOrder());
        }

        int rank = 1;
        if (n == p && score <= arr[n - 1]) {
            rank = -1;
        } else {
            for (int i = 0; i < n; i++) {
                if (score < arr[i]) {
                    rank++;
                } else {
                    break;
                }
            }
        }

        System.out.println(rank);
    }

}
