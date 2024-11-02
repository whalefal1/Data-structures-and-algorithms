package Vertex;

import java.util.List;

import static Vertex.Dijkstra.dijkstra;
import static Vertex.FloydWarshall.floydWarshall;


public class trash {
    public static void main(String[] args) {
        Vertex v1 = new Vertex("乌鲁木齐");
        Vertex v2 = new Vertex("西宁");
        Vertex v3 = new Vertex("拉萨");
        Vertex v4 = new Vertex("哈尔滨");
        Vertex v5 = new Vertex("银川");
        Vertex v6 = new Vertex("兰州");
        Vertex v7 = new Vertex("成都");
        Vertex v8 = new Vertex("昆明");
        Vertex v9 = new Vertex("长春");
        Vertex v10 = new Vertex("呼和浩特");
        Vertex v11 = new Vertex("太原");
        Vertex v12 = new Vertex("西安");
        Vertex v13 = new Vertex("重庆");
        Vertex v14 = new Vertex("贵阳");
        Vertex v15 = new Vertex("南宁");
        Vertex v16 = new Vertex("海口");
        Vertex v17 = new Vertex("沈阳");
        Vertex v18 = new Vertex("北京");
        Vertex v19 = new Vertex("石家庄");
        Vertex v20 = new Vertex("郑州");
        Vertex v21 = new Vertex("武汉");
        Vertex v22 = new Vertex("长沙");
        Vertex v23 = new Vertex("广州");
        Vertex v24 = new Vertex("澳门");
        Vertex v25 = new Vertex("大连");
        Vertex v26 = new Vertex("天津");
        Vertex v27 = new Vertex("济南");
        Vertex v28 = new Vertex("南京");
        Vertex v29 = new Vertex("合肥");
        Vertex v30 = new Vertex("南昌");
        Vertex v31 = new Vertex("厦门");
        Vertex v32 = new Vertex("深圳");
        Vertex v33 = new Vertex("青岛");
        Vertex v34 = new Vertex("上海");
        Vertex v35 = new Vertex("杭州");
        Vertex v36 = new Vertex("宁波");
        Vertex v37 = new Vertex("福州");
        Vertex v38 = new Vertex("香港");
        v1.edges = List.of(new Edge(v2,9));
        v2.edges = List.of(new Edge(v1,9),new Edge(v3,20),new Edge(v6,1));
        v3.edges = List.of(new Edge(v2,20));
        v4.edges = List.of(new Edge(v9,1));
        v5.edges = List.of(new Edge(v10,8),new Edge(v11,6),new Edge(v6,8),new Edge(v12,3));
        v6.edges = List.of(new Edge(v5,8),new Edge(v2,1),new Edge(v7,7),new Edge(v12,3));
        v7.edges = List.of(new Edge(v6,7),new Edge(v12,3),new Edge(v13,1),new Edge(v14,3));
        v8.edges = List.of(new Edge(v15,2),new Edge(v16,4));
        v9.edges = List.of(new Edge(v4,1),new Edge(v17,1));
        v10.edges = List.of(new Edge(v5,8),new Edge(v11,5),new Edge(v18,2));
        v11.edges = List.of(new Edge(v10,5),new Edge(v5,6),new Edge(v12,3),new Edge(v19,2));
        v12.edges = List.of(new Edge(v5,3),new Edge(v11,3),new Edge(v6,3),new Edge(v7,3),new Edge(v13,5),new Edge(v20,2));
        v13.edges = List.of(new Edge(v7,1),new Edge(v12,5),new Edge(v14,2),new Edge(v21,6));
        v14.edges = List.of(new Edge(v7,3),new Edge(v8,2),new Edge(v13,2),new Edge(v22,3),new Edge(v15,5),new Edge(v23,4));
        v15.edges = List.of(new Edge(v8,4),new Edge(v14,5),new Edge(v23,3));
        v16.edges = List.of(new Edge(v23,10));
        v17.edges = List.of(new Edge(v9,1),new Edge(v18,3),new Edge(v25,2),new Edge(v26,4));
        v18.edges = List.of(new Edge(v10,2),new Edge(v17,3),new Edge(v26,1),new Edge(v19,1));
        v19.edges = List.of(new Edge(v11,2),new Edge(v18,1),new Edge(v20,2),new Edge(v26,2),new Edge(v27,2));
        v20.edges = List.of(new Edge(v12,2),new Edge(v19,2),new Edge(v27,3),new Edge(v21,2),new Edge(v28,3),new Edge(v29,3));
        v21.edges = List.of(new Edge(v13,6),new Edge(v20,2),new Edge(v29,2),new Edge(v30,2),new Edge(v22,1));
        v22.edges = List.of(new Edge(v14,3),new Edge(v21,1),new Edge(v30,2),new Edge(v23,3));
        v23.edges = List.of(new Edge(v14,4),new Edge(v15,3),new Edge(v16,10),new Edge(v22,3),new Edge(v24,1),new Edge(v32,1));
        v24.edges = List.of(new Edge(v23,1));
        v25.edges = List.of(new Edge(v17,2),new Edge(v26,4));
        v26.edges = List.of(new Edge(v17,4),new Edge(v18,1),new Edge(v19,2),new Edge(v25,4),new Edge(v27,1));
        v27.edges = List.of(new Edge(v19,2),new Edge(v20,3),new Edge(v26,1),new Edge(v28,2),new Edge(v33,2));
        v28.edges = List.of(new Edge(v20,3),new Edge(v27,2),new Edge(v29,1),new Edge(v34,1),new Edge(v33,5),new Edge(v35,1));
        v29.edges = List.of(new Edge(v20,3),new Edge(v21,2),new Edge(v28,1),new Edge(v30,4),new Edge(v35,2));
        v30.edges = List.of(new Edge(v21,2),new Edge(v22,2),new Edge(v29,4),new Edge(v31,5),new Edge(v35,2),new Edge(v37,3));
        v31.edges = List.of(new Edge(v30,5),new Edge(v32,3),new Edge(v37,2));
        v32.edges = List.of(new Edge(v23,1),new Edge(v31,3),new Edge(v38,1));
        v33.edges = List.of(new Edge(v27,2),new Edge(v28,5),new Edge(v34,5));
        v34.edges = List.of(new Edge(v28,1),new Edge(v33,5),new Edge(v35,1));
        v35.edges = List.of(new Edge(v28,1),new Edge(v29,2),new Edge(v30,2),new Edge(v34,1),new Edge(v36,1));
        v36.edges = List.of(new Edge(v35,1),new Edge(v37,4));
        v37.edges = List.of(new Edge(v30,3),new Edge(v31,2),new Edge(v36,4));
        v38.edges = List.of(new Edge(v32,1),new Edge(v37,2));

    List<Vertex> list = List.of(v1,v2,v3,v4,v5,v6,v7,v8,v9,v10,v11,v12,v13,v14,
            v15,v16,v17,v18,v19,v20,v21,v22,v23,v24,v25,v26,v27,v28,v29,v30,
            v31,v32,v33,v34,v35,v36,v37,v38);

    dijkstra(list,v11);
    floydWarshall(list);
    }
}
