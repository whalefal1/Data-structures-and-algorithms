package Vertex;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 弗洛伊德算法
 * 用于求解图中的多源最短路径
 * @author 李朋逊
 * @date 2023/12/19
 */
public class FloydWarshall {


    public static void main(String[] args) {
        Vertex v1 = new Vertex("v1");
        Vertex v2 = new Vertex("v2");
        Vertex v3 = new Vertex("v3");
        Vertex v4 = new Vertex("v4");
        v1.edges = List.of(new Edge(v3,-2));
        v2.edges = List.of(new Edge(v1,4),new Edge(v3,3));
        v3.edges = List.of(new Edge(v4,2));
        v4.edges = List.of(new Edge(v2,-1));
        List<Vertex> graph = List.of(v1,v2,v3,v4);

        floydWarshall(graph);

    }

     static void floydWarshall(List<Vertex> graph) {

    int size = graph.size();
    int[][] dist = new int[size][size];
    Vertex[][] prev = new Vertex[size][size];
    //1.初始化
        for (int i = 0; i < size; i++) {
            Vertex v = graph.get(i);
            Map<Vertex, Integer> map = v.edges.stream().collect(Collectors.toMap(e -> e.linked, e -> e.weight));
            for (int j = 0; j < size; j++) {
                Vertex u = graph.get(j);
                if(v==u){
                    dist[i][j] = 0;
                }else {
                   dist[i][j] = map.getOrDefault(u,Integer.MAX_VALUE);
                   prev[i][j] =  map.get(u) != null ? v: null;

                }

            }
        }

        //2.看能否通过借路到达其他顶点
        /*
        v2->v1              v1->v?
        dist[1][0]    +   dist[0][0]......

         */
        //k表示借路的顶点
        for (int k = 0; k < size; k++) {
            //i表示起点
            for (int j = 0; j < size; j++) {
                //j表示终点
                for (int i = 0; i < size; i++) {
                    //第i行的顶点，借助k顶点，到达j列顶点
                     if(dist[i][k] != Integer.MAX_VALUE && dist[k][j] != Integer.MAX_VALUE&&
                             dist[i][k] + dist[k][j] < dist[i][j]){
                         dist[i][j] = dist[i][k] + dist[k][j];
                            prev[i][j] = prev[k][j];
                     }
                }
            }
        }

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                path(prev,graph,i,j);
            }
        }

    }

    static void print(int [][] dist){
        System.out.println("------------------------------");
        for(int[] row : dist){
            System.out.println(Arrays.stream(row).boxed()
                            .map(x -> x == Integer.MAX_VALUE ? "∞" : String.valueOf(x))
                            .map(x -> String.format("%2s", x))
                    .collect(Collectors.toList())
            );
        }
    }
    static void print(Vertex[][] prev){
        System.out.println("------------------------------");
        for(Vertex[] row : prev){
            System.out.println(Arrays.stream(row).map(x -> x == null ? "null" : x.name)
                    .map(x -> String.format("%2s", x))
                    .collect(Collectors.toList())
            );
        }
    }

    static void path(Vertex[][] prev,List<Vertex> graph,int i,int j){
        LinkedList<String> stack = new LinkedList<>();
        System.out.print("["+ graph.get(i).name + "," + graph.get(j).name + "]");
        stack.push(graph.get(j).name);
       while(i!=j){
           Vertex p = prev[i][j];
              stack.push(p.name);
                j = graph.indexOf(p);
       }
        System.out.println(stack);
    }

}
