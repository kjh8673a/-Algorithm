import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] count = new int[5];

        String s = br.readLine();
        for (int i = 0; i < N; i++) {
            char ch = s.charAt(i);

            switch (ch) {
                case 'H':
                    count[0]++;
                    break;
                case 'I':
                    count[1]++;
                    break;
                case 'A':
                    count[2]++;
                    break;
                case 'R':
                    count[3]++;
                    break;
                case 'C':
                    count[4]++;
                    break;
            }
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 5; i++) {
            min = Math.min(min, count[i]);
        }

        System.out.println(min);
    }

}