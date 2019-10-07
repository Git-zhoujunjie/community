package mangbang;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Zhoujunjie
 * @create 2019/9/27 22:34
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            String str = in.nextLine();
            Map<Character,Integer> map = new HashMap<>();
            char[] cs = str.toCharArray();
            int min = 100;
            for(char c:cs){
                if(map.containsKey(c))
                    map.put(c,map.get(c)+1);
                else map.put(c,1);
            }
            for(char c:map.keySet()){
                if(min>map.get(c)) min = map.get(c);
            }
            StringBuilder sb = new StringBuilder();
            for(char c:cs){
                if(map.get(c)==min) continue;
                sb.append(c);
            }
            System.out.println(sb.toString());
        }
    }
}
