import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            }
            return o2[0] - o1[0];
        });

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 2; i++) {
            sb.append(arr[i][0] + " " + arr[i][1] + " ");
        }
        sb.append("\n");

        Arrays.sort(arr, (o1, o2) -> {
            if (o1[1] == o2[1]) {
                return o2[0] - o1[0];
            }
            return o1[1] - o2[1];
        });

        for (int i = 0; i < 2; i++) {
            sb.append(arr[i][0] + " " + arr[i][1] + " ");
        }
        sb.append("\n");

        System.out.println(sb);
    }

}