import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            String input = br.readLine();
            sb.append(input.substring(0, 1)).append(input.substring(input.length() - 1)).append("\n");
        }

        System.out.println(sb);
    }

}