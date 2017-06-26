import edu.uci.ics.jung.algorithms.layout.CircleLayout;
import edu.uci.ics.jung.graph.DirectedSparseGraph;
import edu.uci.ics.jung.graph.SparseGraph;
import edu.uci.ics.jung.visualization.VisualizationImageServer;
import edu.uci.ics.jung.visualization.decorators.ToStringLabeller;
import edu.uci.ics.jung.visualization.renderers.Renderer;

import java.awt.*;
import java.awt.print.Book;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ListIterator;
import java.util.Scanner;
import javax.swing.JFrame;


/**
 * Created by Acer on 12.03.2017.
 */
public class graph {
    ArrayList<Edge> L_E=new ArrayList<>();
    private ArrayList<Integer> I;
    private ArrayList<Integer> J;
    private ArrayList<Integer> H;//исходный граф
    private ArrayList<Integer> L;//исходный граф
    private ArrayList<Integer> W;// веса в исходном
    private ArrayList<Integer> K;//номера ребер в дереве
    private ArrayList<Integer> M;//принадлежность к компоненту
    private ArrayList<Integer> X;// кол-во элементов в компоненте связности
    private ArrayList<Integer> TrH;
    private ArrayList<Integer> TrL;
    Boolean[] b;

    private int m;//rebra
    private int n;//versh
    private int w = 0;//versh v ostovnom

    public void read(String s) throws FileNotFoundException {
        Scanner sc = new Scanner(new File(s));
        n = sc.nextInt();
        m = sc.nextInt();
        I = new ArrayList<>(m);
        J = new ArrayList<>(m);
        H = new ArrayList<>(n);
        L = new ArrayList<>(m);
        W = new ArrayList<>(m);
        M = new ArrayList<>(n);
        X = new ArrayList<>(n);
        TrH = new ArrayList<>(n);
        TrL=new ArrayList<>(n);
        K=new ArrayList<>(n);
        for (int k = 0; k< m; k++) {
            int i=sc.nextInt();
            int j=sc.nextInt();
            int w=sc.nextInt();
           /* I.add(i);
            J.add(j);
            W.add(w);
            J.add(i);
            I.add(j);
            W.add(w);*/
            Edge e=new Edge(i,j,w);
            L_E.add(e);
        }
      //  m=2*m;
        sort();
        form();
    }
    public void sort(){
        Collections.sort(L_E);
        for (int i = 0; i <L_E.size() ; i++) {
            System.out.println(L_E.get(i).w);
        }
        for (int i = 0; i <L_E.size() ; i++) {
            I.add(L_E.get(i).i);
            J.add(L_E.get(i).j);
            W.add(L_E.get(i).w);
        }

    }
    public void Tree(int s1,int s2,int s3){

        for (int i = 0; i <n ; i++) {
            TrH.add(i);
            TrL.add(-1);
            X.add(1);
            M.add(i);
            K.add(-1);
        }
        for (int k = 0; k <m && w<n-1 ; k++) {
            int i=I.get(k);
            int j=J.get(k);
            int mi=Find(i);
            int mj=Find(j);
            if(mi!=mj)
            {
                K.set(w,k);
                w++;
                Union(mi,mj);
            }
            if(Find(s1)==Find(s2) && Find(s2)==Find(s3))
                break;

        }

    }
    public void update(int s1,int s2,int s3)
    {
       // System.out.println("massiv K");
        //ArrayList<Integer> count=new ArrayList<>();
        Integer[] count=new Integer[n];
        Integer[] num=new Integer[n];
        b=new Boolean[w];
        for (int i = 0; i <w ; i++) {
            b[i]=true;
        }
        for (int i = 0; i <n ; i++) {
            count[i]=0;
        }
        for (int i = 0; i <w; i++)
        {
            int im=I.get(K.get(i));
            int jm=J.get(K.get(i));
            count[im]++;
            count[jm]++;
            num[im]=i;
            num[jm]=i;
           // System.out.println(K.get(i)+" "+I.get(K.get(i))+" "+J.get(K.get(i)));

        }
        for (int i = 0; i <n ; i++) {
           if(count[i]==1 &&(i!=s1 && i!=s2 && i!=s3))
           {
               b[num[i]]=false;
           }
        }
       /* for (int i = 0; i <w; i++) {
            System.out.println(b[i]);
        }
        for (int i = 0; i < w; i++) {
            System.out.println(K.get(i)+" "+I.get(K.get(i))+" "+J.get(K.get(i)));

        }*/



    }
    public int Find(int i)
    {return M.get(i);}
    public void Union(int mi, int mj)
    {
        int k;//номер меньшего
        int l;
        if(X.get(mi)<X.get(mj))
        {
            k=mi;
            l=mj;
        }
        else
        {
            k=mj;
            l=mi;
        }
        int i=0;
        for (i = TrH.get(k) ; TrL.get(i) !=-1 ; i=TrL.get(i))
            M.set(i,l);
        M.set(i,l);
        TrL.set(i,TrH.get(l));
        TrH.set(l,TrH.get(k));
        X.set(l,X.get(l)+X.get(k));


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
    public void addD(int i, int j) {
        I.add(i);
        J.add(j);
        m++;
        int k = H.get(i);
        H.set(i, m - 1);
        L.add(k);

    }
    public void delD(int a, int b)
    {
        for (int k = H.get(a); k != -1; k = L.get(k))
        {
            if (J.get(k) == b)
            {
                I.remove(k);
                J.remove(k);
            }
        }
        m--;
        form();
    }
    public void showTr()
    {
        SparseGraph g=new SparseGraph();
        for (int i = 0; i <n; i++)
            g.addVertex(i);
        //System.out.println("nomera reber");
        for (int i = 0; i <w ; i++)
        {
           // System.out.println(b[i]);
          // System.out.println(K.get(i));
            if(b[i]!=false) {
                g.addEdge(i, I.get(K.get(i)), J.get(K.get(i)));
            }
          //  System.out.println(I.get(K.get(i))+" "+J.get(K.get(i)));

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
    // public void form{}
}
