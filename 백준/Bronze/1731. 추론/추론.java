import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] numbers = new int[N];
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(br.readLine());
        }

        if (numbers[1] - numbers[0] == numbers[N - 1] - numbers[N - 2]) {
            System.out.println(numbers[N - 1] + numbers[1] - numbers[0]);
        } else {
            System.out.println(numbers[N - 1] * (numbers[1] / numbers[0]));
        }
    }
}
