import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            String quiz = br.readLine();
            sb.append(getScore(quiz)).append("\n");
        }

        System.out.println(sb.toString());
    }

    private static int getScore(String quiz) {
        int result = 0;

        int serial = 0;
        for (int i = 0; i < quiz.length(); i++) {
            if (quiz.charAt(i) == 'O') {
                result += ++serial;
            } else {
                serial = 0;
            }
        }

        return result;
    }

}