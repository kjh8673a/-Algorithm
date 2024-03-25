import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean[][] alpha = new boolean[26][26];
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            char a = line.charAt(0);
            char b = line.charAt(line.length() - 1);
            alpha[a - 97][b - 97] = true;
        }

        for (int k = 0; k < 26; k++) {
            for (int i = 0; i < 26; i++) {
                for (int j = 0; j < 26; j++) {
                    if (alpha[i][k] && alpha[k][j]) {
                        alpha[i][j] = true;
                    }
                }
            }
        }

        int m = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            String line = br.readLine();
            char a = line.charAt(0);
            char b = line.charAt(line.length() - 1);
            if (alpha[a - 97][b - 97]) {
                sb.append("T").append("\n");
            } else {
                sb.append("F").append("\n");
            }
        }

        System.out.println(sb);
    }

}