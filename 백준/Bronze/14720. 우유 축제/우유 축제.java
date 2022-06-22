import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        sc.close();

        int strawberry = 0;
        int choco = 0;
        int banana = 0;

        for(int i = 0; i < n; i++) {
            if(strawberry == choco && choco == banana && arr[i] == 0) {
                strawberry++;
            }
            if(strawberry - choco == 1 && choco == banana && arr[i] == 1) {
                choco++;
            }
            if(strawberry == choco && choco - banana == 1 && arr[i] == 2) {
                banana++;
            }
        }

        System.out.println(strawberry + choco + banana);
        
    }
}