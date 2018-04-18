package sort;

public class MergeSort18 {
    public static void main(String [] args){
        int [] input = {2,7,1,3,9,0,4,6,12,4,2,1};
        System.out.println("raw array data:");
        print(input);
        System.out.println("start sort:");
        mergesort(input,0,input.length-1);
    }

    public static void mergesort(int [] array,int left,int right){
        if(left >= right)
            return;
        int center = (left+right)/2;
        mergesort(array,left,center);
        mergesort(array,center+1,right);
        merge(array,left,center,right);
        print(array);
    }

    public static void merge(int [] array,int left,int center,int right){
        int rCenter = center+1;
        int finalLeft = left,tmp = left;
        int [] resArray = new int[array.length];
        while(left <= center && rCenter <=right){
            if(array[left] <= array[rCenter])
                resArray[finalLeft++] = array[left++];
            else
                resArray[finalLeft++] = array[rCenter++];
        }
        while(left <= center){
            resArray[finalLeft++] = array[left++];
        }
        while(rCenter <= right){
            resArray[finalLeft++] = array[rCenter++];
        }
        while(tmp <= right){
            array[tmp] = resArray[tmp];
            tmp++;
        }

    }

    public static void print(int[] data) {
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + "\t");
        }
        System.out.println();
    }
}
