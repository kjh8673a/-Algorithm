import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        int answer = 1;
        int idx = 0;
        for (int i = 0; i < s.length(); i++) {
            int now = s.charAt(i) - 'a';
            if (idx > now) {
                answer++;
            }
            idx = now + 1;
        }

        System.out.println(answer);
    }
}