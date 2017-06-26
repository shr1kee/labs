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
    private ArrayList<Integer> H;
    private ArrayList<Integer> L;
    private ArrayList<Integer> R;
    private ArrayList<Integer> P;
    private ArrayList<Integer> Q;
    private ArrayList<Integer> W;
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
        W = new ArrayList<>(m);
        for (int k = 0; k< m; k++) {
            int i=sc.nextInt();
            int j=sc.nextInt();
            int w=sc.nextInt();
            I.add(i);
            J.add(j);
            W.add(w);
        }
        form();
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
    public void belford(int s)
    {
        R.clear();
        P.clear();
        Q.clear();
        int infinity=10000;
        for (int i = 0; i <n ; i++) {
            R.add(infinity);
            P.add(-2);
            Q.add(-2);
        }
        R.set(s,0);
        P.set(s,-1);
        int h_Q=s;
        int t_Q=s;
        Q.set(s,-1);
        while (h_Q != -1)
        {
            int i = h_Q;
            h_Q =Q.get(h_Q);
            Q.set(i,-2);
            for (int k = H.get(i); k !=-1 ; k = L.get(k))
            {
              int j=J.get(k);
              int rj=R.get(j);
              if  ( R.get(i)+W.get(k) < rj)
              {
                  R.set(j,R.get(i)+W.get(k));
                  P.set(j,k);
                  if (Q.get(j)==-2)
                  {
                      if (h_Q != -1)
                          Q.set(t_Q,j);
                      else
                          h_Q = j;
                      t_Q = j;
                      Q.set(j,-1);
                  }
              }
            }
        }

    }

}
