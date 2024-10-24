package programmers.warpUp;

import java.util.Arrays;
import java.util.Comparator;

public class LambdaS {

    private static class Node{
        int dest, cost;

        public Node(int dest, int cost) {
            this.dest = dest;
            this.cost = cost;
        }
    }

    public static void main(String[] args) {
        Node[] nodes = new Node[5];
        nodes[0] = new Node(1, 10);
        nodes[1] = new Node(2, 20);
        nodes[2] = new Node(3, 30);
        nodes[3] = new Node(4, 40);
        nodes[4] = new Node(5, 50);

        // 람다식
        Arrays.sort(nodes, (a, b) -> Integer.compare(a.cost, b.cost));

        // 일반식
        Arrays.sort(nodes, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return Integer.compare(o1.cost, o2.cost);
            }
        }); // 다만 코테에서, 람다식을 사용하는 일은 드물다.


    }
}
