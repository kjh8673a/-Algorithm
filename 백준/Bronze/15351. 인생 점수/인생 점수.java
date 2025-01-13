import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            String str = br.readLine().replace(" ", "");

            int score = calculate(str);
            if (score == 100) {
                sb.append("PERFECT LIFE").append("\n");
            } else {
                sb.append(score).append("\n");
            }

        }

        System.out.println(sb.toString());
    }

    private static int calculate(String str) {
        int sum = 0;
        for (int i = 0; i < str.length(); i++) {
            sum += str.charAt(i) - 64;
        }

        return sum;
    }

}