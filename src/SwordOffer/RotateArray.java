package SwordOffer;

public class RotateArray {

    public static int minNumberInRotateArray(int [] array) {
        if(array.length==0)
            return -1;
        int lpoint = 0;
        int rpoint = array.length-1;
        int midpoint = 0;
        while(array[lpoint]>=array[rpoint])
        {
            if(rpoint-lpoint==1)
                return array[rpoint];
            midpoint = (lpoint+rpoint)/2;
            if(array[lpoint]==array[rpoint] && array[lpoint] == array[midpoint])
                return minInOrder(array,lpoint,rpoint);
            if(array[midpoint] > array[lpoint]) // 中值在前一个数组
                lpoint = midpoint;
            else if(array[midpoint] <= array[rpoint])
                rpoint = midpoint;
        }
        return array[midpoint];
    }

    public static int minInOrder(int[] arr,int leftIndex,int rightIndex){
        int result = arr[leftIndex];
        for(int i = leftIndex +1;i<rightIndex;i++){
            if(result> arr[i]){
                result = arr[i];
            }
        }
        return result;
    }

    public static void main(String[] args){
        int[] arr={3,4,5,1,2};    //{2,2,2,2,2,0,1,2,2};
        System.out.println(minNumberInRotateArray(arr));

    }
}
