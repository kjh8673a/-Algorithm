import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String[] numbers = new String[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            numbers[i] = st.nextToken();
        }

        Arrays.sort(numbers, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int num = o2.charAt(0) - o1.charAt(0);
                if(num != 0) {
                    return num;
                }else {
                    int d = gcd(o1.length(), o2.length());
                    int len = o1.length() * o2.length() / d;
                    String a = "";
                    for(int i = 0; i < len; i += o1.length()) {
                        a += o1;
                    }
                    String b = "";
                    for(int i = 0; i < len; i += o2.length()) {
                        b += o2;
                    }
                    BigInteger bigA = new BigInteger(a);
                    BigInteger bigB = new BigInteger(b);
                    return bigB.compareTo(bigA);
                }
                
            }
        });

        String ans = "";
        for(int i = 0; i < N; i++) {
            ans += numbers[i];
        }
        if(ans.startsWith("0") && ans.endsWith("0")) {
            System.out.println(0);
        }else {
            System.out.println(ans);
        }
        
    }

    public static int gcd(int a, int b) {
        while(b != 0) {
            int r = a % b;

            a = b;
            b = r;
        }
        return a;
    }

}