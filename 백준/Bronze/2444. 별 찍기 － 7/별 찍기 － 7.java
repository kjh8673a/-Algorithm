import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int len = 2 * N - 1;

        StringBuilder sb = new StringBuilder();
        for (int i = N - 1; i >= 0; i--) {
            for (int j = 0; j < len; j++) {
                if (j < i) {
                    sb.append(" ");
                } else if (j >= i && j < len - i) {
                    sb.append("*");
                } else {
                    break;
                }
            }
            sb.append("\n");
        }

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < len; j++) {
                if (j < i) {
                    sb.append(" ");
                } else if (j >= i && j < len - i) {
                    sb.append("*");
                } else {
                    break;
                }
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());

    }

}