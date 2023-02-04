import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int sum = 0;
        while(true) {
            int money = Integer.parseInt(br.readLine());
            if(money == -1) break;
            sum += money;
        }
        System.out.println(sum);

    }

}