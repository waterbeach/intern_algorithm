package SwordOffer;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

/*
    计算数组中的逆序对
    思路： 归并排序
 */
public class CountInversePairs {
    static List<Pair<Integer,Integer>> list= new ArrayList<>();

    public static void main(String [] args){
        int [] array = {7,5,6,4};
        System.out.println(InversePairs(array));
        for(Pair pair:list)
            System.out.println("<"+pair.getKey()+","+pair.getValue()+">");
    }

    public static int InversePairs(int [] array) {
        int left = 0,right = array.length-1;
        return countPairs(array,left,right);
    }

    public static int countPairs(int [] data,int left,int right){
        if(left >= right)
            return 0;
        int center = (left+right)/2;
        int leftCount = countPairs(data,left,center);
        int rightCount = countPairs(data,center+1,right);

        int count = 0;
        //临时数组赋值索引 & 回转索引
        int tmpindex = right,copyindex = right;
        int mid = center;
        int [] tmparray = new int[data.length];
        while(center>=left && right>=mid+1){
            if(data[center]>data[right]) {
                count += right - mid;
                addList(data,center,mid+1,right);
                tmparray[tmpindex--] = data[center];
                center--;
            }else{
                tmparray[tmpindex--] = data[right];
                right--;
            }
        }
        while(center>=left){
            tmparray[tmpindex--] = data[center--];
        }
        while(right>=mid+1)
            tmparray[tmpindex--] = data[right--];

        while(left <= copyindex){
            data[left] = tmparray[left++];
        }
        return leftCount+rightCount+count;
    }


    static void addList(int [] data,int left,int center,int right){
        for(int i = center;i<= right;i++)
            list.add(new Pair<>(data[left],data[i]));
    }

}
