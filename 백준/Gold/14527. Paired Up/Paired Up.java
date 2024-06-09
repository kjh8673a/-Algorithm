import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] cow = new int[n][2];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            cow[i][0] = Integer.parseInt(st.nextToken());
            cow[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(cow, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        int left = 0;
        int right = n - 1;
        int answer = 0;
        while (left <= right) {
            int a = cow[left][1];
            int b = cow[right][1];
            answer = Math.max(a + b, answer);

            cow[left][0]--;
            cow[right][0]--;
            if (cow[left][0] == 0) {
                left++;
            }
            if (cow[right][0] == 0) {
                right--;
            }
        }

        System.out.println(answer);
    }

}