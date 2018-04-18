package sort;

import java.util.Scanner;

public class Poj_001 {
	public static void main(String [] args){
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int arr [] = new int [n];
		for(int i = 0;i<n;i++)
			arr[i] = scanner.nextInt();
		quicksort(arr, 0, n-1);
		for(int i = 0;i< n;i++)
			System.out.print(arr[i]+" ");
	}
	public static void quicksort(int [] arr,int start,int end){
		if (start >= end)  
            return;
		int val = arr[start];
		int i = start+1;
		int j = end;
		while(true){
			while(i<=end && arr[i] < val)
				i++;
			while(j>start && arr[j] > val)
				j--;
			if(i<j)
	      		swap(arr,i,j);
			else 
				break;
		}
		swap(arr,start,j);
		quicksort(arr, start, j-1);
		quicksort(arr, j+1, end);
		
	}
	public static void swap(int[] data, int i, int j) {  
        if (i == j) {  
            return;  
        }  
        data[i] = data[i] + data[j];  
        data[j] = data[i] - data[j];  
        data[i] = data[i] - data[j];  
    }  
	
}
