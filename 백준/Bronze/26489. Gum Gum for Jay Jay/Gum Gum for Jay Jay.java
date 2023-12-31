import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = "";

        int answer = 0;
        while ((input = br.readLine()) != null && !input.isEmpty()) {
            answer++;
        }

        System.out.println(answer);
    }

}