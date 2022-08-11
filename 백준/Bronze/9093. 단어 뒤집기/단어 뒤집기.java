import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        for(int i = 0; i < t; i ++) {
            String s = br.readLine();

            sb.setLength(0);
            String a = "";
            for(int j = 0; j < s.length(); j++) {
                if(s.charAt(j) == ' ') {
                    for(int k = a.length()-1; k >= 0; k--) {
                        sb.append(a.charAt(k));
                    }
                    sb.append(" ");
                    a = "";
                }else {
                    a += s.charAt(j);
                }

                if(j == s.length()-1) {
                    for(int k = a.length()-1; k >= 0; k--) {
                        sb.append(a.charAt(k));
                    }
                }
            }
            System.out.println(sb.toString());
        }
        
    }

}