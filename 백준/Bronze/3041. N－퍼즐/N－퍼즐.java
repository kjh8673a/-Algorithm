import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int answer = 0;
        for (int i = 0; i < 4; i++) {
            String line = br.readLine();
            for (int j = 0; j < 4; j++) {
                char c = line.charAt(j);
                if (c != '.') {
                    answer += Math.abs((c - 'A') / 4 - i) + Math.abs((c - 'A') % 4 - j);
                }
            }
        }

        System.out.println(answer);
    }

}
