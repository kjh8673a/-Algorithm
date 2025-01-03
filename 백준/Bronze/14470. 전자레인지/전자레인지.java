import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());
        int d = Integer.parseInt(br.readLine());
        int r = Integer.parseInt(br.readLine());

        int answer = 0;
        if (a < 0) {
            answer += (0 - a) * c;
            answer += d;
        }
        answer += Math.min(b - a, b - 0) * r;

        System.out.println(answer);
    }
}