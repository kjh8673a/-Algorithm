import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        String input = "";
        while ((input = br.readLine()) != null && !input.isEmpty()) {
            StringTokenizer st = new StringTokenizer(input);
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            sb.append(validRoomCount(a, b)).append("\n");
        }

        System.out.println(sb);
    }

    private static int validRoomCount(int a, int b) {
        int count = 0;
        for (int i = a; i <= b; i++) {
            count += isValidRoomNumber(i) ? 1 : 0;
        }
        return count;
    }

    private static boolean isValidRoomNumber(int num) {
        boolean[] count = new boolean[10];
        while (num > 0) {
            if (count[num % 10]) {
                return false;
            }
            count[num % 10] = true;
            num /= 10;
        }
        return true;
    }
}