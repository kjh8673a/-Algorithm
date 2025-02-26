import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        System.out.println(coef(n, k));
    }

    private static int coef(int n, int k) {
        if (k == 0 || n == k) {
            return 1;
        }

        return coef(n - 1, k) + coef(n - 1, k - 1);
    }

}