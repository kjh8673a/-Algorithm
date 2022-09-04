import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while(true) {
            String num = br.readLine();

            if(num.equals("0")) {
                break;
            }

            StringBuilder sbr = new StringBuilder(num);

            String palin = sbr.reverse().toString();

            if(num.equals(palin)) {
                sb.append("yes").append("\n");
            }else {
                sb.append("no").append("\n");
            }
        }

        System.out.println(sb.toString());
        
    }

}
