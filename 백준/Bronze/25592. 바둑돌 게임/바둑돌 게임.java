import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int answer = 0;
        int sum = 0;
        int count = 1;
        boolean myTurn = true;
        while (true) {
            sum += count;
            if (sum > n) {
                if (myTurn) {
                    answer = sum - n;
                }
                break;
            }

            count++;
            myTurn = !myTurn;
        }

        System.out.println(answer);

    }
}