import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int answer = 0;
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            if (s.contains("01") || s.contains("OI")) {
                answer++;
            }
        }

        System.out.println(answer);
    }
}