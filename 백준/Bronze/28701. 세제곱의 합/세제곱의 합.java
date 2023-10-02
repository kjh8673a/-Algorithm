import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long a = 0;
        long c = 0;
        for (int i = 1; i <= N; i++) {
            a += i;
            c += Math.pow(i, 3);
        }

        System.out.println(a);
        System.out.println(a * a);
        System.out.println(c);
    }

}
