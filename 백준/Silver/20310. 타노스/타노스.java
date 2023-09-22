import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] str = br.readLine().toCharArray();

        int countOne = 0;
        for (int i = 0; i < str.length; i++) {
            countOne += str[i] - '0';
        }

        int countZero = str.length - countOne;
        int cnt = countZero / 2;
        for (int i = str.length - 1; i >= 0 && cnt > 0; i--) {
            if (str[i] == '0') {
                cnt--;
                str[i] = '2';
            }
        }

        cnt = countOne / 2;
        for (int i = 0; i < str.length && cnt > 0; i++) {
            if (str[i] == '1') {
                cnt--;
                str[i] = '2';
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length; i++) {
            if (str[i] != '2') {
                sb.append(str[i]);
            }
        }

        System.out.println(sb);
    }

}
