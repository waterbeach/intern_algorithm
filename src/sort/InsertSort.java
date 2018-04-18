package sort;

/*
 * ��������
 */
public class InsertSort {
	int a[]={49,38,65,97,76,13,27};
	public static void main(String [] args) {  
		int numbers[]={49,38,65,97,76,13,27};
        int size = numbers.length;
        int temp = 0;  
        
      
       
        for (int i = 1; i < size; i++) { 
        	int j = i-1;
            temp = numbers[i];   
            for (; j >= 0 && temp < numbers[j]; j--)   
                numbers[j+1] = numbers[j];   
            numbers[j+1] = temp;   
        } 
        System.out.println("after insertsort: ");
        for(int i =0;i<size;i++)
        	System.out.print(numbers[i]+" ");
    }   
	
}
