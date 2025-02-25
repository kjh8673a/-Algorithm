import java.io.*;

public class Main {
    static final int MOD = 1234567891;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int l = Integer.parseInt(br.readLine());
        String s = br.readLine();

        long answer = 0;
        long pow = 1;
        for (int i = 0; i < l; i++) {
            long a = s.charAt(i) - 'a' + 1;
            answer += a * pow % MOD;
            pow = (pow * 31) % MOD;
        }

        System.out.println(answer % MOD);
    }

}