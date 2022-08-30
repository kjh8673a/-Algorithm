import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int[] palin = new int[100000001];
        for(int i = 0; i < 10; i++) {
            palin[i]++;
        }
        for(int i = 0; i < 10000; i++) {
            
            int num = reverse(i);
            if(num < 100000001) {
                palin[num]++;
            }

            int num2 = reverse2(i);
            if(num2 < 100000001) {
                palin[num2]++;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = a; i <= b; i++) {
            if (palin[i] != 0) {
                if(isPrime(i)) {
                    sb.append(i).append("\n");
                }
            }
        }

        sb.append(-1);
        System.out.println(sb);

    }

    public static boolean isPrime(int x) {
        if (x == 1) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(x); i++) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPalin(int x) {
        String str = String.valueOf(x);
        String a;
        if(str.length() % 2 == 0) {
            a = str.substring(0, str.length()/2);
        }else {
            a = str.substring(0, str.length()/2 + 1);
        }
        
        String b = str.substring(str.length()/2);

        int len = a.length();
        
        for(int i = len-1; i >= 0; i--) {
            if(a.charAt(i) != b.charAt((len-1)-i)) {
                return false;
            }
        }

        return true;
    }

    public static int reverse(int x) {
        String str = String.valueOf(x);
        StringBuilder sbr = new StringBuilder(str);

        String num = str + sbr.reverse().toString();

        return Integer.parseInt(num);
    }

    public static int reverse2(int x) {
        String str = String.valueOf(x);
        StringBuilder sbr = new StringBuilder(str);

        String num = str.substring(0, str.length()-1) + sbr.reverse().toString();

        return Integer.parseInt(num);
    }

}