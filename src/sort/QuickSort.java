package sort;

public class QuickSort {
	
	public static void main(String[] args) {  
        int[] data = new int[] { 5, 3, 6, 2, 1, 9, 4, 8, 7 };
        System.out.println("����qian�����飺");
        print(data); 
        System.out.println("����ing�����飺");
        quickSort(data, 0, data.length - 1);  
        System.out.println("���������飺");  
        print(data);  
    }  
  
    public static void swap(int[] data, int i, int j) {  
        if (i == j) {  
            return;  
        }  
        data[i] = data[i] + data[j];  
        data[j] = data[i] - data[j];  
        data[i] = data[i] - data[j];  
    }  
  
    public static void quickSort(int[] data, int start, int end) {  
        if (start >= end)  
            return;  
        //����ʼ����Ϊ�ֽ��  
        int pivot = data[start];  
        int i = start + 1;  
        int j = end;  
        while (true) {  
            while (i <= end && data[i] < pivot) {  
                i++;  
            }  
            while (j > start && data[j] > pivot) {  
                j--;  
            }  
            if (i < j) {  
                swap(data, i, j);  
            } else {  
                break;  
            }  
        }  
        //���� j�ͷֽ���ֵ  
        swap(data, start, j);  
        print(data);  
        //�ݹ���������  
        quickSort(data, start, j - 1);  
        //�ݹ���������  
        quickSort(data, j + 1, end);  
    }  
  
    public static void print(int[] data) {  
        for (int i = 0; i < data.length; i++) {  
            System.out.print(data[i] + "\t");  
        }  
        System.out.println();  
    }  
  
  
}
