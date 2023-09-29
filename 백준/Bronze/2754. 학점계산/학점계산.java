import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String grade = br.readLine();

        double ans = 0;
        switch (grade.charAt(0)) {
            case 'A':
                ans += 4;
                break;
            case 'B':
                ans += 3;
                break;
            case 'C':
                ans += 2;
                break;
            case 'D':
                ans += 1;
                break;
        }

        if (ans > 0) {
            switch (grade.charAt(1)) {
                case '+':
                    ans += 0.3;
                    break;
                case '-':
                    ans -= 0.3;
            }
        }

        System.out.println(ans);
    }

}
