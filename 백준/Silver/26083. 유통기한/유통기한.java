import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int y = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            boolean abc = isValid(a, b, c);
            boolean cab = isValid(c, a, b);
            boolean cba = isValid(c, b, a);

            if (!abc && !cab && !cba) {
                sb.append("invalid").append("\n");
            } else {
                boolean flag = true;
                if (abc) {
                    if (!isSafe(y, m, d, a, b, c)) {
                        flag = false;
                    }
                }
                if (cab) {
                    if (!isSafe(y, m, d, c, a, b)) {
                        flag = false;
                    }
                }
                if (cba) {
                    if (!isSafe(y, m, d, c, b, a)) {
                        flag = false;
                    }
                }

                if (flag) {
                    sb.append("safe").append("\n");
                } else {
                    sb.append("unsafe").append("\n");
                }
            }
        }

        System.out.println(sb);
    }

    private static boolean isSafe(int y, int m, int d, int a, int b, int c) {
        int today = 10000 * y + 100 * m + d;
        int expire = 10000 * a + 100 * b + c;

        return today <= expire;
    }

    private static boolean isValid(int year, int month, int day) {
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                if (day <= 31 && day > 0) {
                    return true;
                }
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                if (day <= 30 && day > 0) {
                    return true;
                }
                break;
            case 2:
                if (year % 4 == 0) {
                    if (day <= 29 && day > 0) {
                        return true;
                    }
                } else {
                    if (day <= 28 && day > 0) {
                        return true;
                    }
                }
        }

        return false;
    }

}