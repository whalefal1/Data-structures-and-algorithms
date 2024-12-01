package Vertex;

public class FindCenter {
    public int findCenter(int[][] edges) {
        int[] edge = edges[0];
        int[] edge1 = edges[1];
        int m = 0;
        for (int i = 0; i < 2; i++) {
            int x = edge[i];
            for (int j = 0; j < 2 ; j++) {
                int y = edge1[j];
                if(x == y){
                    m = x;
                }
            }
        }
        return m;
    }
}
