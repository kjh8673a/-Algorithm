import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());

        int[] numbers = new int[k];
        int idx = 0;
        for (int i = 0; i < k; i++) {
            int number = Integer.parseInt(br.readLine());

            if (number == 0) {
                numbers[--idx] = 0;
            } else {
                numbers[idx++] = number;
            }
        }

        int answer = 0;
        for (int i = 0; i < idx; i++) {
            answer += numbers[i];
        }

        System.out.println(answer);
    }

}