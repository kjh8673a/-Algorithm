import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int number;
    static int count;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String n = br.readLine();

        isThree(n, 0);

        sb.append(count).append("\n");

        if (number % 3 == 0)
            sb.append("YES");
        else
            sb.append("NO");

        System.out.println(sb.toString());

    }

    public static void isThree(String str, int cnt) {
        
        int sum = 0;

        if(str.length() == 1) {
            count = cnt;
            number = Integer.parseInt(str);
            return;
        }else {
            for(int i = 0; i < str.length(); i++) {
                sum += Integer.parseInt(String.valueOf(str.charAt(i)));
            }
            isThree(Integer.toString(sum), cnt+1);
        }
    
    }

}
