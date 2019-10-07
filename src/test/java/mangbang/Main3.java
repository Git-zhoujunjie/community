package mangbang;

/**
 * @author Zhoujunjie
 * @create 2019/9/27 23:10
 */
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main3 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] peach = new int[m];
        for (int i = 0; i < m; i++) {
            peach[i] = in.nextInt();
        }

        Bear[] bears = new Bear[n];
        Bear[] bears2 = new Bear[n];
        for (int i = 0; i < n; i++) {
            bears[i] = new Bear();
            bears[i].Combat = in.nextInt();
            bears[i].Hunger = in.nextInt();
            bears2[i] = bears[i];
        }
        Arrays.sort(peach);
        Arrays.sort(bears, new Comparator<Bear>() {

            @Override
            public int compare(Bear o1, Bear o2) {
                return o2.Combat - o1.Combat;
            }
        });
        boolean[] boo = new boolean[m];
        for (int i = 0; i < n; i++) {
            fun(peach, boo, bears[i]);
        }

        for (int i = 0; i < n; i++) {
            System.out.println(bears2[i].Hunger);
        }
    }

    private static void fun(int[] sugur, boolean[] boo, Bear bear) {
        for (int i = sugur.length - 1; i >= 0; i--) {
            if (boo[i] == false) {
                if (bear.Hunger >= sugur[i]) {
                    bear.Hunger -= sugur[i];
                    boo[i] = true;
                }
            }
        }
    }
}

class Bear {
    int Combat;
    int Hunger;
}

