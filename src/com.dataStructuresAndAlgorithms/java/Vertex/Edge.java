package Vertex;

/**
 * 图的边
 * @author 李朋逊
 * @date 2023/11/10
 */
public class Edge {

        //边的终顶点
        Vertex linked;
        //边的权重
        int weight;

    public Edge(Vertex linked, int weight) {
        this.linked = linked;
        this.weight = weight;
    }
}
