import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] tab = new int[368];
        int[] space = new int[368];

        int maxSleep = 0;
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            char type = st.nextToken().charAt(0);
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            if (type == 'T') {
                tab[s]++;
                tab[e + 1]--;
            } else {
                space[s]++;
                space[e + 1]--;
            }

            maxSleep = Math.max(maxSleep, e - s + 1);
        }

        int moreOne = 0;
        int maxPeople = 0;
        int noFight = 0;
        int maxPeopleWithNoFight = 0;
        for (int i = 1; i < 367; i++) {
            tab[i] += tab[i - 1];
            space[i] += space[i - 1];

            if (tab[i] + space[i] > 0) {
                moreOne++;

                if (tab[i] == space[i]) {
                    noFight++;
                    maxPeopleWithNoFight = Math.max(maxPeopleWithNoFight, tab[i] + space[i]);
                }
            }

            maxPeople = Math.max(maxPeople, tab[i] + space[i]);
        }

        System.out.println(moreOne);
        System.out.println(maxPeople);
        System.out.println(noFight);
        System.out.println(maxPeopleWithNoFight);
        System.out.println(maxSleep);
    }

}