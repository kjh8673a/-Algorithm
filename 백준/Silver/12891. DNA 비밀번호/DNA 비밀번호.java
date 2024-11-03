import java.io.*;
import java.util.*;

public class Main {
    static int p, a, c, g, t;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        p = Integer.parseInt(st.nextToken());

        char[] arr = br.readLine().toCharArray();

        st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        g = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());

        int[] count = new int[4];
        for (int i = 0; i < p; i++) {
            switch (arr[i]) {
                case 'A':
                    count[0]++;
                    break;
                case 'C':
                    count[1]++;
                    break;
                case 'G':
                    count[2]++;
                    break;
                case 'T':
                    count[3]++;
                    break;
            }
        }

        int answer = 0;
        if (check(count)) {
            answer++;
        }

        int left = 0;
        for (int i = p; i < s; i++) {
            switch (arr[left++]) {
                case 'A':
                    count[0]--;
                    break;
                case 'C':
                    count[1]--;
                    break;
                case 'G':
                    count[2]--;
                    break;
                case 'T':
                    count[3]--;
                    break;
            }

            switch (arr[i]) {
                case 'A':
                    count[0]++;
                    break;
                case 'C':
                    count[1]++;
                    break;
                case 'G':
                    count[2]++;
                    break;
                case 'T':
                    count[3]++;
                    break;
            }

            if (check(count)) {
                answer++;
            }
        }

        System.out.println(answer);
    }

    private static boolean check(int[] count) {
        int sum = count[0] + count[1] + count[2] + count[3];
        if (sum == p) {
            if (count[0] >= a && count[1] >= c && count[2] >= g && count[3] >= t) {
                return true;
            }
        }

        return false;
    }

}