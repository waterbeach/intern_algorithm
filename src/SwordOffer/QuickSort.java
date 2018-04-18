package SwordOffer;

// 快速排序
public class QuickSort {

    static void quicksort(int data[],int start,int end){
        if(start>end)
            return;
        int index = partition(data,start,end);
        quicksort(data,start,index-1);
        quicksort(data,index+1,end);
    }

    static int partition(int data[],int start,int end){
        //将key换到数组末尾
        int key = data[start];
        data[start] = data[end];
        data[end] = key;
        int j = start;
        for(int i = start;i < end;i++){
            if(data[i]<key){
                swapArray(data,i,j);
                j++;
            }
        }
        swapArray(data,j,end);
        return j;
    }
    static void swapArray(int [] data,int i,int j){
        int tmp = data[i];
        data[i] = data[j];
        data[j] = tmp;
    }


    public static void main(String [] args){
        int [] data = {1,4,3,1,78,3,7,8,2,34,2,10};
        quicksort(data,0,data.length-1);
        for(int i = 0;i<data.length;i++)
            System.out.println(data[i]);
    }
}
