import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Acer on 27.04.2017.
 */
public class Conteiner {

    ArrayList<Integer> I = new ArrayList<>();
    ArrayList<Integer> J = new ArrayList<>();
    ArrayList<Integer> H = new ArrayList<>();
    ArrayList<Integer> L = new ArrayList<>();
    ArrayList<Integer> W = new ArrayList<>();
    Integer m;//rebra
    Integer n;//versh
    Integer INF = 10000;

    public Conteiner(String text) {
        reading(text);
        for (int i = 0; i < m; i++)
            L.add(-1);
        for (int i = 0; i < n; i++)
            H.add(-1);
        fullH();
    }
    private void reading(String filename) {

        try {
            Scanner in = new Scanner(new File(filename));
            m = in.nextInt();
            n = in.nextInt();
            //neor
            for (int k = 0; k < m; k++) {
                int i=in.nextInt();
                int j=in.nextInt();
                int w=in.nextInt();
                I.add(i);
                J.add(j);
                W.add(w);
                //
                I.add(j);
                J.add(i);
                W.add(w);

            }
            m=2*m;
            in.close();


        } catch (IOException ex) {
            System.err.println("File not found");
        }


    }
    private void fullH() {
        for (int i = 0; i < m; i++) {
            if (H.get(I.get(i)) == -1) {
                H.set(I.get(i), i);
            } else {
                L.set(i, H.get(I.get(i)));
                H.set(I.get(i), i);
            }
        }
    }
    public int dijkstra(int s) {
        ArrayList<Integer> R = new ArrayList<>();
        ArrayList<Integer> P = new ArrayList<>();
        for (int i = 0; i < n ; i++) {
            R.add(INF);
            P.add(-2);
        }
        R.set(s, 0);
        P.set(s, -1);
        int C = W.get(0);
        for (int i = 1; i < m ; i++)
            if (C < W.get(i))
                C = W.get(i);
        int M = C * n;
        Bucket B = new Bucket(M, n);
        B.INSERT(s, 0);
        for (int b = 0; b <M; b++) {
            int i;
            while ( (i=B.GET(b))!=-1)
                for (int k = H.get(i); k != -1; k = L.get(k))
                {
                    int j=J.get(k);
                    int rj=R.get(j);
                    if(R.get(i)+W.get(k)<rj)
                    { R.set(j,R.get(i)+W.get(k));
                        P.set(j,I.get(k));}
                    if(rj!=INF)
                        B.REMOVE(j,rj);
                    B.INSERT(j,R.get(j));
                }


        }
        System.out.println("Кратчайшие расстояния:");
        for (int i = 0; i <R.size() ; i++) {
            System.out.println(R.get(i));
        }
        System.out.println("Дерево предков:");
        for (int i = 0; i <P.size() ; i++) {
            System.out.println(P.get(i));
        }
        int sum=0;/*
        for(int i=0;i<n;i++)
            if(R.get(i)!=INF)
                sum+=R.get(i);

        for(int i=0;i<n;i++)
            System.out.print(P.get(i)+" ");
        System.out.println();*/

        return sum;

    }

}
