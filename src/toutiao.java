import javafx.util.Pair;

import java.util.*;

public class toutiao {
    static class Node {
        public int x;
        public int y;
        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //获取输入个数
        String num_str = sc.nextLine();
        int num = Integer.parseInt(num_str);

        Node [] nodes = new Node[num];
        for(int i = 0;i< num;i++){
            String input = sc.nextLine();
            String[] strs = input.split(" ");
//            System.out.println(input);
            int x = Integer.parseInt(input.split(" ")[0]);
            int y = Integer.parseInt(input.split(" ")[1]);
            nodes[i] = new Node(x,y);
        }

        List<Node> res = getResult(nodes);
        for(int i =res.size()-1;i>=0;i--){
            System.out.println(res.get(i).getX()+" "+res.get(i).getY());

        }


    }
    public static List<Node> getResult(Node [] nodes){

        if(nodes.length == 0)
            return null;
        Arrays.sort(nodes, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if (o1.getX() == o2.getX())
                    return o1.getY() - o2.getY();
                else
                    return o1.getX() - o2.getX();
            }
        });

        List<Node> res = new ArrayList<>();
        res.add(nodes[nodes.length-1]);
        int maxY = nodes[nodes.length-1].getY();
        for(int i = nodes.length-2;i>=0;i--){
            if(nodes[i].getY() > maxY){
                res.add(nodes[i]);
                maxY = nodes[i].getY();
            }
            if(nodes[i].getX() == nodes[i+1].getX() && nodes[i].getY() <= nodes[i+1].getY())
                break;
        }
        return res;
    }
}

//        Node s1 = new Node(1,2);
//        Node s2 = new Node(5,3);
//        Node s3 = new Node(4,6);
//        Node s4 = new Node(3,5);
//        Node s5 = new Node(3,4);
//        Node [] nodes = new Node[5];
//        nodes[0] = s1;
//        nodes[1] = s2;
//        nodes[2] = s3;
//        nodes[3] = s4;
//        nodes[4] = s5;
