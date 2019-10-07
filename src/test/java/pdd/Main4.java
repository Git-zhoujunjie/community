package pdd;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Zhoujunjie
 * @create 2019/9/25 15:51
 */
public class Main4 {
    static int res=0;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while(in.hasNext()){
            int t = in.nextInt();
            //表示测试用例组数
            for(int i=0;i<t;i++){
                int n = in.nextInt(); //总周末
                int m = in.nextInt(); //指定周末
                int[] w = new int[m];
                int[] c = new int[m];
                for(int j=0;j<m;j++){
                    w[j] = in.nextInt();
                }
                for(int j=0;j<m;j++){
                    c[j] = in.nextInt();
                }
                ///////////计算////////
                int[] N = new int[n+1];
                for(int s=1;s<=n;s++) N[s] = s;
                int[] cur = new int[n+1];
                dfs(1,n,cur,N,w,c);
                System.out.println(res%1000000007);
            }
        }
    }
    static void dfs(int t,int n,int[] cur,int[] N,int[] w,int[] c){
        if(t>n) {
            res++;
            System.out.println(Arrays.toString(cur));
            return;
        }

        for(int i=1;i<=n;i++){
            if(N[i]!=cur[t-1]){
                if(w.length>0 && t==w[t-1]) {

                    cur[t] = c[t - 1];
                    dfs(t + 1, n, cur, N, w, c);

                }else {
                    cur[t] = N[i];
                    dfs(t + 1, n, cur, N, w, c);
                }
            }
        }

    }
}
