import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(true) {
            int n = sc.nextInt();

            if(n == 0) break;

            String[] words = new String[n];
            double[] rank = new double[n];
            for(int i = 0; i < n; i++) {
                String str = sc.next();
                words[i] = str;
                for(int j = 0; j < str.length(); j++) {
                    rank[i] += (str.toUpperCase().charAt(j)-0)/(Math.pow(100, j));
                }
            }
            
            double min = Integer.MAX_VALUE;
            int idx = 0;
            for(int i = 0; i < rank.length; i++) {
                min = Math.min(min, rank[i]);
                if(rank[i] == min) {
                    idx = i;
                }
            }

            System.out.println(words[idx]);
        }

        sc.close();

    }

}