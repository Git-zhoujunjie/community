package pdd;

import org.junit.Test;

import java.util.Scanner;

/**
 * @author Zhoujunjie
 * @create 2019/9/25 15:04
 */
public class Main2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int n = in.nextInt();
            int m = in.nextInt();
            int[] left = new int[m];
            int[] right = new int[m];
            for(int i=0;i<m;i++){
                left[i] = in.nextInt();
                right[i] = in.nextInt();
            }
            //int[] res = new int[m];
            int res = 0;
            boolean[] flag = new boolean[n+1];
            for(int i=0;i<m;i++){

                int count = 0;
                for(int j=left[i];j<=right[i];j++){
                    if(!flag[j]){
                        flag[j]=true;
                        count++;
                    }
                }

//                if(i==0) res[i] = count;
//                else res[i] = res[i-1]+count;
                if(i==0) res = count;
                else res += count;
                System.out.println(res);
            }
        }
    }


    @Test
    public void test(){
        int res = fun(4,2018);
        System.out.println(res);
    }

    public int fun(int a,int b){
        if(a>=b){
            if(a==b) return a;
            else return 0;
        }else{
            return fun(a+1,b-1)+a+b;
        }
    }
}
