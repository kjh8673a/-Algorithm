import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        int[] count = new int[10];
        for(int i = 1; i <= n; i++) {
            int num = i;

            while(num > 0) {
                count[num%10]++;
                num /= 10;
            }
        }

        System.out.println(count[d]);
    }

}
