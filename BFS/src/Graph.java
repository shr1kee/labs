import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Acer on 03.05.2017.
 */
public class Graph {
    private ArrayList<Integer> I;
    private ArrayList<Integer> J;
    private ArrayList<Integer> H;//исходный граф
    private ArrayList<Integer> L;//исходный граф
    private ArrayList<Integer> R;
    private ArrayList<Integer> P;
    private ArrayList<Integer> Q;
    private int m;//rebra
    private int n;//versh
    public void read(String s) throws FileNotFoundException {
        Scanner sc = new Scanner(new File(s));
        n = sc.nextInt();
        m = sc.nextInt();
        I = new ArrayList<>(m);
        J = new ArrayList<>(m);
        H = new ArrayList<>(n);
        L = new ArrayList<>(m);
        R = new ArrayList<>(n);
        P = new ArrayList<>(n);
        Q = new ArrayList<>(n);
        for (int k = 0; k< m; k++) {
            int i=sc.nextInt();
            int j=sc.nextInt();
            int w=sc.nextInt();
            I.add(i);
            J.add(j);
        }
        form();
    }
    public void bfs(Integer s)
    {
        R.clear();
        P.clear();
        Q.clear();
        for (int i = 0; i <n ; i++) {
            R.add(n);
            P.add(-2);

        }
        R.set(s,0);
        P.set(s,-1);
        Q.add(s);
        int r=0;
        int w=1;
        while(r<w)
        {
            int i=Q.get(r);
            r++;
            for (int k = H.get(i); k !=-1 ; k=L.get(k)) {
                int j=J.get(k);
                if(R.get(j)==n)
                {
                    R.set(j,R.get(i)+1);
                    P.set(j,k);
                    Q.add(j);
                    w++;
                }
            }

        }

    }
    public void write()
    {
        System.out.println("Длина пути:");
        for (int i = 0; i <n ; i++) {
            System.out.println(R.get(i));
        }
        System.out.println("Дерево предков:");
        for (int i = 0; i <n ; i++){
            System.out.println(P.get(i));
        }
    }
    public void form() {
        H.clear();
        L.clear();
        for (int i = 0; i < n; i++) {
            H.add(-1);
        }
        for (int k = 0; k < m; k++) {
            int i = I.get(k);
            L.add(H.get(i));
            H.set(i, k);
        }
    }
}
