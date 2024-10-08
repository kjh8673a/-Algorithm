import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            double a = Double.parseDouble(br.readLine()) * 0.8;
            sb.append("$" + String.format("%.2f", a)).append("\n");
        }

        System.out.println(sb);
    }

}
