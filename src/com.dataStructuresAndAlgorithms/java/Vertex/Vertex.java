package Vertex;




import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * 图顶点
 * @author 李朋逊
 * @date 2023/11/10
 */
public class Vertex {
    //顶点名
    String name;
    //边——以此顶点为起点的边
    List<Edge> edges;
    //是否被访问
    boolean visited;


    //用于dijkstra算法
    int dist = INF;//从起点到此顶点的临时距离——初始化为无穷大
    static  final Integer INF = Integer.MAX_VALUE;

     Vertex prev = null;//前驱顶点
    public Vertex(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


    //图的深度优先遍历
    public void dfs(Vertex vertex) {
        //标记已访问
        vertex.visited = true;
        //打印
        System.out.println(vertex.name);
        //遍历边
        for (Edge edge : vertex.edges) {
            //如果边的终结点未被访问
            if (!edge.linked.visited) {
                //递归
                dfs(edge.linked);
            }
        }
    }

    //图的广度优先遍历
    public void bfs(Vertex vertex) {
        //自定义队列
        LinkedList<Vertex> queue = new LinkedList<>();
        //将图的开始节点加入队列
        queue.offer(vertex);
        //标记已访问
        vertex.visited = true;
        while (!queue.isEmpty()) {
            //出队
            Vertex poll = queue.poll();
            System.out.println(poll.name);
            for (Edge edge : poll.edges) {
                if (!edge.linked.visited) {
                    queue.offer(edge.linked);
                    edge.linked.visited = true;
                }
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vertex vertex = (Vertex) o;
        return Objects.equals(name, vertex.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    static void print(Vertex vertex){
        System.out.print(vertex.name);
        if(vertex.prev!=null){
            print(vertex.prev);
        }
    }

    //给定一对顶点，输出边的权值
    static void path(Vertex[][] prev, List<Vertex> graph, int i, int j){
        Vertex v1 = graph.get(i);
        Vertex v2 = graph.get(j);
        if(v1==v2){
            return;
        }
        if(prev[i][j]==null){
            System.out.println("没有路径");
            return;
        }
        System.out.print(v1.name);
        path(prev,graph,i,graph.indexOf(prev[i][j]));
        System.out.print(v2.name);
    }
}

