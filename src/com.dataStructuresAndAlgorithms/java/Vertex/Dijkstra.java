package Vertex;


import java.util.ArrayList;
import java.util.List;

/**
 *
 * 狄克斯特拉算法——求最短路径
 * @author 李朋逊
 * @date 2023/11/10
 *
 *
 * 1.将所有顶点标记为未访问。创建一个未访问顶点的集合
 * 2.为每个顶点分配一个临时距离值
 * 。对于我们的初始顶点，将其设置为零
 * 。对于所有其他顶点，将其设置为无穷大3.每次选择最小临时距离的未访问顶点，作为新的当前顶点4.对于当前顶点，遍历其所有未访问的邻居，并更新它们的临时距离为更小例如，1->6 的距离是 14，而1->3->6 的距离是11。这时将距离更新为 11。否则，将保留上次距离值
 * 5.当前顶点的邻居处理完成后，把它从未访问集合中删除
 *
 */
public class Dijkstra {

    public static void main(String[] args) {
        Vertex v1 = new Vertex("v1");
        Vertex v2 = new Vertex("v2");
        Vertex v3 = new Vertex("v3");
        Vertex v4 = new Vertex("v4");
        Vertex v5 = new Vertex("v5");
        Vertex v6 = new Vertex("v6");

        v1.edges = List.of(new Edge(v3,9),new Edge(v2,7),new Edge(v6,14));
        v2.edges = List.of(new Edge(v4,15));
        v3.edges = List.of(new Edge(v4,11),new Edge(v6,2));
        v4.edges = List.of(new Edge(v5,6));
        v5.edges = List.of();
        v6.edges = List.of(new Edge(v5,9));
        List<Vertex> graph = List.of(v1,v2,v3,v4,v5,v6);

        dijkstra(graph,v1);


    }

     static void dijkstra(List<Vertex> graph, Vertex source) {
        //1.初始化
        ArrayList<Vertex> list = new ArrayList<>(graph);
        //2.将起点初始临时距离设为0
        source.dist = 0;
        while(!list.isEmpty()){
            //3.选取当前顶点
           Vertex cur  =  chooseMinDisVertex(list);
            //4.更新当前顶点的邻接顶点的距离
            updateNeighborDist(cur);
            //5.将当前顶点从集合中移除,表示当前顶点已被访问
            list.remove(cur);
            cur.visited = true;
        }
        //6.打印结果
        for (Vertex vertex : graph) {
            System.out.println(vertex.name+" "+vertex.dist);
            print(vertex);
            System.out.println("\n");
        }
    }

    private static void updateNeighborDist(Vertex cur) {

        for (Edge edge : cur.edges) {
            Vertex n = edge.linked;
            if(n.visited == false){
                int newDist = cur.dist + edge.weight;
                if(newDist<n.dist){
                    n.dist = newDist;
                    n.prev = cur;
                }
            }
        }
    }

    private static Vertex chooseMinDisVertex(ArrayList<Vertex> list) {

        Vertex min = list.get(0);
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).dist<min.dist){
                min = list.get(i);
            }
        }
        return min;
    }

    private static void print(Vertex source){
        System.out.print(source.name);
        if(source.prev!=null){
            print(source.prev);
        }
    }
    //2)	打印输出从源点u到某个顶点v的最短路径
    static void path(Vertex[][] prev, List<Vertex> graph, int i, int j){
        Vertex v1 = graph.get(i);
        Vertex v2 = graph.get(j);
        System.out.println(v1.name+"->"+v2.name+" "+v2.dist);
        print(v2);
        System.out.println("\n");
    }
}
