import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

        int k = sc.nextInt();

        int[] len = new int[6];
        for(int i = 0; i < 6; i++) {
            int no = sc.nextInt();
            len[i] = sc.nextInt();
        }
        sc.close();

        int aMax = 0;
        int aidx = 0;
        int bMax = 0;
        int bidx = 0;
        for(int i = 0; i < 6; i++) {
            if(i % 2 == 0 && aMax != Math.max(len[i], aMax)) {
                aMax = Math.max(len[i], aMax);
                aidx = i;
            }else if(i % 2 != 0 && bMax != Math.max(len[i], bMax)) {
                bMax = Math.max(len[i], bMax);
                bidx = i;
            }            
        }

        int a = (aidx > 2) ? len[aidx-3] : len[aidx+3];
        int b = (bidx > 2) ? len[bidx-3] : len[bidx+3];

        int area = aMax * bMax - a * b;
        System.out.println(area * k);
	}

}