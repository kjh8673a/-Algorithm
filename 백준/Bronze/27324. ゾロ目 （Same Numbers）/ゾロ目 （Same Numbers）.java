import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String num = br.readLine();
        if (num.charAt(0) == num.charAt(1)) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }

}
