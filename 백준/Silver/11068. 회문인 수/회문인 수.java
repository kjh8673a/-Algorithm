import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine() + " ");
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());

        for (int tc = 0; tc < n; tc++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());

            boolean isNot = true;
            for (int i = 2; i <= 64; i++) {
                String strNum = toN(num, i);

                boolean check = true;
                for (int j = 0; j < strNum.length() / 2; j++) {
                    if (strNum.charAt(j) != strNum.charAt(strNum.length() - 1 - j)) {
                        check = false;
                        break;
                    }
                }

                if (check) {
                    sb.append("1\n");
                    isNot = false;
                    break;
                }
            }

            if (isNot) {
                sb.append("0\n");
            }

        }

        System.out.println(sb.toString());

    }

    public static String toN(int num, int n) {
        String result = "";
        if (num == 0) {
            return "0";
        }

        while (num > 0) {
            int shere = num / n;
            int remainder = num % n;
            if (remainder > 9) {
                result = (char) (remainder + 55) + result;
            } else {
                result = remainder + result;
            }
            num = shere;
        }
        return result;
    }

}
