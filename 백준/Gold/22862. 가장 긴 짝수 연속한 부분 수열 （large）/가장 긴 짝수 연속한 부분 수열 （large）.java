import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int answer = 0;

        int s = 0;
        int e = 0;
        int len = 0;
        int odd = 0;
        while (s <= e && e < n) {
            if (arr[e] % 2 == 0) {
                len++;
                e++;
            } else {
                if (odd == k) {
                    while (odd == k) {
                        if (arr[s] % 2 == 0) {
                            s++;
                            len--;
                        } else {
                            s++;
                            odd--;
                        }
                    }
                } else {
                    odd++;
                    e++;
                }
            }

            answer = Math.max(answer, len);
        }

        System.out.println(answer);
    }

}