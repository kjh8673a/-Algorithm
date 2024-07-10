import java.io.*;

public class Main {
    static int[] count = { 12, 11, 11, 10, 9, 9, 9, 8, 7, 6, 6 };
    static int[] score = { 1600, 894, 1327, 1311, 1004, 1178, 1357, 837, 1055, 556, 773 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()) - 1;

        System.out.println(count[n] + " " + score[n]);
    }

}