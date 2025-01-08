import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < 10; i++) {
            sb.append(n + " * " + i + " = " + (n * i)).append("\n");
        }

        System.out.println(sb.toString());
    }
}