package mangbang;

import java.util.*;

/**
 * @author Zhoujunjie
 * @create 2019/9/27 22:47
 */
public class Main1{

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int n = in.nextInt();
            int m = in.nextInt();
            int[] peach = new int[m];
            for(int i=0;i<m;i++) peach[i] = in.nextInt();

            Monkey[] mon1 = new Monkey[n];
            Monkey[] mon2 = new Monkey[n];

            for (int i = 0; i < n; i++) {
                mon1[i] = new Monkey();
                mon1[i].battle = in.nextInt();
                mon1[i].ang = in.nextInt();
                mon2[i] = mon1[i];
            }
            Arrays.sort(peach); //对所有桃子从小到大排序
            //对猴子按照战斗力降序排序
            Arrays.sort(mon1, new Comparator<Monkey>() {

                @Override
                public int compare(Monkey o1, Monkey o2) {
                    return o2.battle - o1.battle;
                }
            });
            //标记该猴子是否已经吃过
            boolean[] boo = new boolean[m];
            for (int i = 0; i < n; i++) {
                fun(peach, boo, mon1[i]);
            }

            for (int i = 0; i < n; i++) {
                System.out.println(mon2[i].ang);
            }
        }
    }
    static void fun(int[] peach, boolean[] boo, Monkey monkey) {
        for(int i=peach.length-1;i>=0;i--){
            if(boo[i] == false){
                if(monkey.ang >= peach[i]){
                    monkey.ang -= peach[i];
                    boo[i] = true;
                }
            }
        }
    }

}
class Monkey {
    int battle;
    int ang;
}
