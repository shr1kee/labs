import edu.uci.ics.jung.algorithms.layout.CircleLayout;
import edu.uci.ics.jung.graph.DirectedSparseGraph;
import edu.uci.ics.jung.visualization.VisualizationImageServer;
import edu.uci.ics.jung.visualization.decorators.ToStringLabeller;
import edu.uci.ics.jung.visualization.renderers.Renderer;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Acer on 27.05.2017.
 */
public class Graph {
    private ArrayList<Integer> I;
    private ArrayList<Integer> J;
    private ArrayList<Integer> H;
    private ArrayList<Integer> L;
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
        W = new ArrayList<>(m);
        for (int k = 0; k< m; k++) {
            int i = sc.nextInt();
            int j = sc.nextInt();
            int w = sc.nextInt();
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
    public void var1(int x)
    {
        int min = (int) Double.POSITIVE_INFINITY;
        int kmin = H.get(x);
        int kprev = -1;
        int prev = -1;
        for(int k=H.get(x); k!=-1; k=L.get(k))
        {
            int w = W.get(k);
            if (w < min)
            {
                min = w;
                kmin = k;
                kprev = prev;
            }
            prev = k;
        }
        if (H.get(x) != kmin)
        {
            int head = H.get(x);
            H.set(x,kmin);
            int next = L.get(kmin);
            L.set(kmin,head);
            L.set(kprev,next);
        }

    }
    public void var2( int[] p, int x,int y)
    {
        ArrayList<Integer> xlist=new ArrayList<>();
        ArrayList<Integer> ylist = new ArrayList();
        for (int i = x; i != -1 ;) {
            xlist.add(i);
            i=p[i];
        }
        for (int i = y; i != -1 ;) {
            ylist.add(i);
            i=p[i];
        }
        int xlen = 0;
        int ylen = 0;

        if ( xlist.size() < ylist.size())
        {
            for (int i = 0; i < xlist.size(); i++) {
                int v = xlist.get(i);
                if (ylist.contains(v))
                {
                    xlen = i;
                    ylen = ylist.indexOf(v);
                    System.out.println(v+" " +xlen+" "+ylen);
                    break;
                }
            }
        }
        else
        {
            for (int i = 0; i < ylist.size(); i++) {
                int v = ylist.get(i);
                if (xlist.contains(v))
                {
                    ylen = i;
                    xlen = xlist.indexOf(v);
                    System.out.println(v+" " +xlen+" "+ylen);
                    break;
                }
            }
        }


    }
    public void var3()
    {
        ArrayList<Integer> H_in = new ArrayList<>();
        ArrayList<Integer> H_out = new ArrayList<>();
        ArrayList<Integer> L_in = new ArrayList<>();
        ArrayList<Integer> L_out = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            H_in.add(-1);
            H_out.add(-1);
        }
        for (int i = 0; i < m ; i++) {
            L_in.add(-1);
            L_out.add(-1);
        }
        for (int k = 0; k < m; k++) {
            int i = I.get(k);
            if( W.get(k)>0) {
                L_out.set(k,H_out.get(i));
                H_out.set(i, k);
            }
            else if(W.get(k) < 0)
            {
               L_in.set(k,H_in.get(i));
               H_in.set(i,k);
            }
        }


    }
    public void var4(){}
    public void var5(){

    }
    public void var6(int x)
    {
        int max = 0;
        int kmax = 0;
        for(int k=H.get(x); k!=-1; k=L.get(k))
        {
            int w = W.get(k);
            if (w > max)
            {
                max = w;
                kmax = k;
            }
        }
        I.remove(kmax);
        J.remove(kmax);
        m--;
        form();
    }
    public void var7()
    {
        //найти все листья
        //пройти от каждого листа до вершины и находить высоту

    }
    public void var8()
    {
        //второй по величине либо левый потомок максимума(если есть), если нет - либо предок максимума
        // предпоследний по величине либо правый потомок минимума, либо - предок минимума
    }
    public void var9()
    {
        //допилить var 8
    }
    public void var10()
    {
        //выписать вершины входящие в ветку от корня до i в L
        // P[x] =-1
        // P[i] = L[i-1]
    }
    public void var11()
    {
        //Ln(n)+1??
    }
    public void var12(int x){
        int min = (int) Double.POSITIVE_INFINITY;
        int kmin = 0;
        for(int k=H.get(x); k!=-1; k=L.get(k))
        {
            int w = W.get(k);
            if (w < min)
            {
                min = w;
                kmin = k;
            }
        }
        I.remove(kmin);
        J.remove(kmin);
        m--;
        form();
    }
    public void var14(){}
    public void var15(ArrayList p)
    {
        int sum = 0;
        for (int i = 0; i <p.size() ; i++) {
            if (!p.contains(i))
                sum++;
        }
        System.out.println(sum);
    }
    public void var16(){}
    public void write()
    {
        System.out.println("head");
        for (int i = 0; i < n ; i++) {
            System.out.println(H.get(i));
        }
        System.out.println("link: ");
        for (int i = 0; i < m ; i++) {
            System.out.println(L.get(i));
        }
    }
    public void showG() {
        DirectedSparseGraph g = new DirectedSparseGraph();
        for (int i = 0; i < n; i++) {
            g.addVertex(i);
        }
        for (int i = 0; i < m; i++) {
            g.addEdge(i, I.get(i), J.get(i));

        }
        VisualizationImageServer vs =
                new VisualizationImageServer(
                        new CircleLayout(g), new Dimension(200, 200));
        vs.getRenderContext().setVertexLabelTransformer(new ToStringLabeller());
        vs.getRenderer().getVertexLabelRenderer().setPosition(Renderer.VertexLabel.Position.CNTR);


        JFrame frame = new JFrame();
        frame.getContentPane().add(vs);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

}
