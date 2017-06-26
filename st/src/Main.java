import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Created by Acer on 09.06.2017.
 */
public class Main {
    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        int n=in.nextInt();
        ArrayList<Integer> list=new ArrayList<>();
        for (int i = 0; i <n ; i++) {
            list.add(in.nextInt());
        }
        Collections.sort(list);
        int ans = 0;
        int k=0;
        while (list.contains(0)) {
            k = list.indexOf(0);
            list.remove(k);
        }

       int nn =  list.size();
        if (nn >=3)
        {
            if (list.get(nn - 1) < 0)
                ans = list.get(nn - 1) * list.get(nn - 2) * list.get(nn - 3);
            else {
                int m1 = list.get(0) * list.get(1) * list.get(nn - 1);
                int m2 = list.get(nn - 1) * list.get(nn - 2) * list.get(nn - 3);
                ans = m1;
                if (m2 > ans)
                    ans = m2;
            }
            if (ans < 0 && nn!=n )
                ans=0;
        }
         System.out.println(ans);
    }
}
