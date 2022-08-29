import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        int k = Integer.parseInt(str.split("/")[0]);
        int d = Integer.parseInt(str.split("/")[1]);
        int a = Integer.parseInt(str.split("/")[2]);

        if(k + a < d || d == 0) {
            System.out.println("hasu");
        }else {
            System.out.println("gosu");
        }

        

    }

    
}