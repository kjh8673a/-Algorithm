import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        if (n <= 205) {
            System.out.println(1);
        } else if (n <= 217) {
            System.out.println(2);
        } else if (n <= 228) {
            System.out.println(3);
        } else {
            System.out.println(4);
        }
    }

}