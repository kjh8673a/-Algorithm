import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int a = Integer.parseInt(br.readLine());
            sb.append(a + " " + a).append("\n");
        }

        System.out.println(sb);
    }

}