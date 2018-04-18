package SwordOffer;
import java.lang.reflect.Array;
import java.util.*;
/*
P为给定的二维平面整数点集。定义 P 中某点x，如果x满足 P 中任意点都不在 x 的右上方区域内（横纵坐标都大于x），则称其为“最大的”。
求出所有“最大的”点的集合。（所有点的横坐标和纵坐标都不重复, 坐标轴范围在[0, 1e9) 内）
 */

// 依然超时

public class newcoder {
    public static List<Pair> maxPoint(Pair [] list){ //暴力解法
        Arrays.sort(list);
        List<Pair> returnlist = new ArrayList<>();
        for(int i = 0;i<list.length;i++){
            boolean flag = true;
            for(int j = 0;j<list.length;j++){
                if(i==j)
                    continue;
                if(list[i].x < list[j].x && list[i].y < list[j].y){
                    flag = false;
                    break;
                }
            }
            if(flag)
                returnlist.add(list[i]);
        }
        Collections.reverse(returnlist);
        return returnlist;
    }

    public static List<Pair> maxPoint2(Pair [] list){
        Arrays.sort(list);
        List<Pair> returnlist = new ArrayList<>();
        int n = list.length;
        returnlist.add(list[n-1]); //排序后最后一个肯定是
        int maxY = list[n-1].y;
        for(int i = n-2;i>=0;i--){ // X升序 y降序
            if(list[i].y > maxY) {
                returnlist.add(list[i]);
                maxY = list[i].y;
            }
        }
        Collections.reverse(returnlist);
        return returnlist;
    }

    public static void main(String [] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); //数组大小
        Pair [] pairArr = new Pair[n];
        for(int i = 0;i < n;i++){
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            pairArr[i] = new Pair(x,y);
        }
        List<Pair> result = maxPoint2(pairArr);
        for(Pair pair:result)
            System.out.println(pair.x+" "+pair.y);
    }
}

class Pair implements Comparable<Pair>{
    int x;
    int y;
    public Pair(int x,int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Pair o) {
        return x==o.x ? o.y-y:x-o.x; //按照X升序 y降序
    }
}

// input
//5
//1 2
//5 3
//4 6
//7 5
//9 0
