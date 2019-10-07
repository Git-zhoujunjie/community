package pdd;

import java.util.Arrays;
import java.util.Scanner;


public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            int m = in.nextInt();
            int[] cla = new int[n];
            String str = in.nextLine();
            String[] strings = str.split(" ");

            for (int i = 0; i < n; i++) {
                cla[i] = Integer.parseInt(strings[i]);
            }
            Arrays.sort(cla);

            int flag = 0;
            while (flag < n && cla[flag] < 0) {
                flag++;
            }
            int left = flag;
            int right = n - flag;
            int sum = 0;
            if (left >= m && right >= m) {
                for (int i = 0; i < m; i++) {
                    int muti = cla[i] * cla[n - 1 - i];
                    sum += muti;

                }
                System.out.println(sum);
                return;
            }
            if (left >= m) {
                for (int i = 0; i < right; i++) {
                    int muti = cla[i] * cla[n - 1 - i];
                    sum += muti;

                }
                int lastLength = m - right;
                for (int i = 0; i < lastLength; i++) {

                    sum += cla[flag - (2 * lastLength) + i] * cla[flag - 1 - i];
                }
                System.out.println(sum);
                return;
            }
            if (right >= m) {
                for (int i = 0; i < left; i++) {
                    int muti = cla[i] * cla[n - 1 - i];
                    sum += muti;

                }
                int lastLength = m - left;
                for (int i = 0; i < lastLength; i++) {

                    sum += cla[flag + i] * cla[flag + 2 * lastLength - 1 - i];
                }
                System.out.println(sum);
                return;
            }

        }
    }
}


