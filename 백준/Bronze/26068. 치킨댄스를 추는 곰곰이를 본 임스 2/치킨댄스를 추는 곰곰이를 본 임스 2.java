import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int count = 0;
        for(int i = 0 ; i < n; i++) {
            String[] arr = br.readLine().split("-");
            if(Integer.parseInt(arr[1]) <= 90) {
                count++;
            }
        }

        System.out.println(count);
    }

}
