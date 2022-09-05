import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++) {
            String str = br.readLine();
            String tmp = "";
            for(int j = 0; j < str.length(); j++) {
                if(str.charAt(j) == ' ') {
                    StringBuilder sbr = new StringBuilder(tmp);
                    sb.append(sbr.reverse().toString()).append(" ");
                    tmp = "";
                    continue;
                }
                if(j == str.length()-1) {
                    tmp += str.charAt(j);
                    StringBuilder sbr = new StringBuilder(tmp);
                    sb.append(sbr.reverse().toString()).append("\n");
                }
                tmp += str.charAt(j);
            }
        }

        System.out.println(sb.toString());

    }

}
