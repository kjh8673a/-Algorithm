import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for(int i = n; ; i++) {
            if(isPrime(i) && isPalin(i)) {
                System.out.println(i);
                break;
            }
        }
        
    }

    public static boolean isPrime(int x) {
        if(x == 1) {
            return false;
        }

        for(int i = 2; i <= Math.sqrt(x); i++) {
            if(x % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPalin(int x) {
        String str = String.valueOf(x);
        StringBuilder sb = new StringBuilder(str);
        if(!str.equals(sb.reverse().toString())) {
            return false;
        }
        return true;
    }

}