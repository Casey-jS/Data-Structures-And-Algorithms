
import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.util.Collections;
import java.util.*;



public class Edge{
    
    private int weight;
    private int first;
    private int last;

    public Edge(int weight, int first, int last){
        this.weight = weight;
        this.first = first;
        this.last = last;
    }
    public int getWeight(){
        return this.weight;
    }

    public static ArrayList<Edge> kruskal(ArrayList<Edge> list, int numVertices){

        DisjSets set = new DisjSets(numVertices);
        ArrayList<Edge> valid_edges = new ArrayList<Edge>();

        while (valid_edges.size() != numVertices - 1){
            Edge e = list.get(0);
            int uset = set.find(e.first);
            int vset = set.find(e.last);

            if (uset != vset){
                valid_edges.add(e);
                set.union(uset, vset);
            }
            list.remove(e);
            
        }
        return valid_edges;
    }
    public static void main(String[] args) throws Exception{

        File file = new File(args[0]);
        Scanner in = new Scanner(file);
        int maxVertex = 0;

        ArrayList<Edge> list = new ArrayList<Edge>();
        while(in.hasNextLine()){
            int first = in.nextInt();
            int last = in.nextInt();
            int weight = in.nextInt();

            if (first > maxVertex){
                maxVertex = first;
            }
            if (last > maxVertex){
                maxVertex = last;
            }

            Edge e = new Edge(weight, first, last);
            list.add(e);
        }
        Collections.sort(list, new EdgeComparator());

        ArrayList<Edge> valid_edges = kruskal(list, maxVertex + 1);

        System.out.println("The set of edges in the MST is:");

        int total = 0;
        for (Edge e : valid_edges){
            System.out.println("[" + e.first + "," + e.last + "] weight: " + e.weight);
            total += e.weight;
        }
        System.out.println("The total cost is: " + total);    
    }
}
