import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int l = Integer.parseInt(br.readLine());
        String s = br.readLine();

        long answer = 0;
        for (int i = 0; i < l; i++) {
            long a = s.charAt(i) - 'a' + 1;
            answer = (long) (answer + a * Math.pow(31, i)) % 1234567891;
        }

        System.out.println(answer);
    }

}