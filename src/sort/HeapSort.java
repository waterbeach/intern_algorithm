package sort;

import java.util.Arrays;


 public class HeapSort{
    public static void main(String [] args){
        int a[]={49,38,65,97,76,13,27,49,78,34,12,64,5,4,62,99,98,54,56,17,18,23,34,15,35,25,53,51};
        System.out.println("raw data:");
        System.out.println(Arrays.toString(a));
        System.out.println("after sort:");
        heapSort(a);
        System.out.println(Arrays.toString(a));
    }

    public static void heapSort(int[] a){
        int lastIndex=a.length-1;
        for(int i=0;i<lastIndex;i++){
            buildMaxHeap(a,lastIndex-i);
            //change element
            swap(a,0,lastIndex-i);
            System.out.println(Arrays.toString(a));  
        }  
    }  
   
    private static void swap(int[] data, int i, int j) {
        int tmp=data[i];  
        data[i]=data[j];  
        data[j]=tmp;  
    }
    //build max heap
    private static void buildMaxHeap(int[] data, int lastIndex) {
  
        for(int i=(lastIndex-1)/2;i>=0;i--){ // from last have child node
            
            int k=i;
            while(k*2+1<=lastIndex){
                int biggerIndex=2*k+1;

                if((biggerIndex+1) <= lastIndex && data[biggerIndex]<data[biggerIndex+1]){
                    biggerIndex++;
                }
                if(data[k]<data[biggerIndex]){
                    swap(data,k,biggerIndex);  
                    k=biggerIndex;
                }else{  
                    break;  
                }  
            }
        }
    }  
  
}  