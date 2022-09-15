import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        // ^ : 정규표현식 시작
        // ? : 0개 또는 1개
        // + : 하나 또는 그 이상
        // $ : 정규표현식 종료
        String regExp = "^[A-F]?A+F+C+[A-F]?$";

        for(int i = 0; i < t; i++) {
            String str = br.readLine();
            if(str.matches(regExp)) {
                sb.append("Infected!").append("\n");
            }else {
                sb.append("Good").append("\n");
            }
        }

        System.out.println(sb.toString());

    }

}