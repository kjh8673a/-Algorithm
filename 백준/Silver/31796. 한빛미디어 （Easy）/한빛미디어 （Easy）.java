import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] books = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            books[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(books);

        int answer = 1;
        int s = books[0];
        for (int i = 1; i < n; i++) {
            if (books[i] >= s * 2) {
                answer++;
                s = books[i];
            }
        }

        System.out.println(answer);
    }

}