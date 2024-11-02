package Tree;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class HuffmanTree {


    static class Node{
        Node left;
        Node right;
        int freq;       //频次
        Character c; //字符
        String code; //编码

        public Node(Character c) {
            this.c = c;
        }

        public Node(Node left, Node right, int freq) {
            this.left = left;
            this.right = right;
            this.freq = freq;
        }

        int getFreq() {
            return freq;
        }

        boolean isLeaf() {
            return left == null && right == null;
        }

        @Override
        public String toString() {
            return "Node{" +
                    " freq=" + freq +
                    ", ch=" + c +
                    ", code='" + code + '\'' +
                    '}';
        }

    }


    String str;
    Map<Character,Node> map = new HashMap<>();



    //根据字符串创建哈夫曼树
    public HuffmanTree(String str) {
        //统计字符频次
        this.str = str;
        char[] chars = str.toCharArray();
        for (char c : chars) {
            if(!map.containsKey(c)){
                map.put(c,new Node(c));
            }
            Node node = map.get(c);
            node.freq++;
        }
        for (Node node : map.values()) {
            System.out.println(node);
        }
        System.out.println("====================================");
        //将字符与频次放入优先级队列
        PriorityQueue<Node> queue = new PriorityQueue<>(
                //比较器，根据频次比较，频次低的优先级高
                Comparator.comparing(Node::getFreq)
        );
        queue.addAll(map.values());
        while(queue.size()>=2){
            //每次出队两个节点元素
            Node x = queue.poll();
            Node y = queue.poll();
            //将两个节点元素合并为一个节点元素
            int freq = x.freq + y.freq;
            queue.offer(new Node(x,y,freq));
        }
        //此时队列中只剩下一个节点元素，即为哈夫曼树的根节点
        Node root = queue.poll();
        System.out.println(root);

        //进行编码
        dfs(root,new StringBuffer());
    }


    //进行编码——递归
    private void dfs(Node node,StringBuffer code){
        if(node.isLeaf()){
            //找到编码
            System.out.println(node.c+" : "+code);
        }else{
            dfs(node.left,code.append('0'));
            dfs(node.right,code.append('1'));
        }
        if(code.length()>0)
        code.deleteCharAt(code.length()-1);
    }

    public static void main(String[] args) {
        new HuffmanTree("abbccc");
    }
}
