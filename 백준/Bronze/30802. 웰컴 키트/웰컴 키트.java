import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        int tshirts = 0;
        for (int i = 0; i < arr.length; i++) {
            tshirts += arr[i] / t;
            if (arr[i] % t > 0) {
                tshirts++;
            }
        }

        System.out.println(tshirts);
        System.out.println(n / p + " " + n % p);
    }

}