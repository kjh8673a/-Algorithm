import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String line = br.readLine();
            if (line.equals("END")) {
                break;
            }

            StringBuilder code = new StringBuilder(line);
            sb.append(code.reverse()).append("\n");
        }

        System.out.println(sb);
    }

}