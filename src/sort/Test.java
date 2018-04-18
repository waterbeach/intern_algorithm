package sort;

import java.util.Arrays;

public class Test{
	public static void main(String [] args){
		HeapSort hs = new HeapSort();
	}

static public class HeapSort {  
  
     int  a[]={49,38,65,97,76,13,27,49,78,34,12,64,5,4,62,99,98,54,56,17,18,23,34,15,35,25,53,51};  
  
    public  HeapSort(){  
  
       heapSort(a);  
  
    }  
     
    public  void heapSort(int[] a){  
  
        System.out.println("��ʼ����");  
        int arrayLength=a.length;  
        
        //ѭ������  
        for(int i=0;i<arrayLength-1;i++){  
            //����  
            buildMaxHeap(a,arrayLength-1-i);  
            //�����Ѷ������һ��Ԫ��  
            swap(a,0,arrayLength-1-i);  
            System.out.println(Arrays.toString(a));  
        }  
    }  
  
   
  
    private  void swap(int[] data, int i, int j) {  
        int tmp=data[i];  
        data[i]=data[j];  
        data[j]=tmp;  
    }  
  
    //��data�����0��lastIndex���󶥶�  
    private void buildMaxHeap(int[] data, int lastIndex) {  
  
        //��lastIndex���ڵ㣨���һ���ڵ㣩�ĸ��ڵ㿪ʼ   ���һ���к��ӵĽ��
        for(int i=(lastIndex-1)/2;i>=0;i--){  
            
            int k=i;  //k���������жϵĽڵ�  
            while(k*2+1<=lastIndex){  //�����ǰk�ڵ���ӽڵ����
                int biggerIndex=2*k+1;  //k�ڵ�����ӽڵ������
  
                //���biggerIndexС��lastIndex����biggerIndex+1�����k�ڵ�����ӽڵ����  
                if(biggerIndex<lastIndex){  
                    if(data[biggerIndex]<data[biggerIndex+1]){ //�������ӽڵ��ֵ�ϴ� 
                        biggerIndex++;  //biggerIndex���Ǽ�¼�ϴ��ӽڵ������
                    }  
                }  
                if(data[k]<data[biggerIndex]){  //���k�ڵ��ֵС����ϴ���ӽڵ��ֵ  
                    swap(data,k,biggerIndex);  
                    k=biggerIndex;  //��biggerIndex����k����ʼwhileѭ������һ��ѭ�������±�֤k�ڵ��ֵ�����������ӽڵ��ֵ  
                }else{  
                    break;  
                }  
            }  
        }  
    }  
  
}  
}