package sort;

public class mergeSort {

	 public static void main(String[] args) {  
	        int[] data = new int[] { 5, 3, 6, 2, 1, 9, 4, 8, 7 };  
	        System.out.println("raw array data");
	        print(data);
		 	System.out.println("start sort:");
	        double starttime = System.currentTimeMillis();
	        mergeSort(data, 0, data.length - 1);
	        double endtime = System.currentTimeMillis();
	        System.out.println(endtime - starttime);
	        System.out.println("sort time cost: ");
	        print(data);  
	    }  

	    public static void mergeSort(int[] data, int left, int right) {
	        if (left >= right)  
	            return;  
	        int center = (left + right) / 2;
			mergeSort(data, left, center);
			mergeSort(data, center + 1, right);
	        merge(data, left, center, right);
			System.out.println("left:"+left+" center: "+center+" right:"+right);
			print(data);
	    }  
	  

	    public static void merge(int[] data, int left, int center, int right) {  
	        int[] tmpArr = new int[data.length];
	        int mid = center + 1;
	        int third = left;
	        int tmp = left;
	        while (left <= center && mid <= right) {  
	            if (data[left] <= data[mid]) {
	                tmpArr[third++] = data[left++];  
	            } else {  
	                tmpArr[third++] = data[mid++];  
	            }  
	        }  
	        while (mid <= right) {
	            tmpArr[third++] = data[mid++];  
	        }  
	        while (left <= center) {  
	            tmpArr[third++] = data[left++];  
	        }  
	        while (tmp <= right) {
	            data[tmp] = tmpArr[tmp++];  
	        }  
	    }  
	  
	    public static void print(int[] data) {  
	        for (int i = 0; i < data.length; i++) {  
	            System.out.print(data[i] + "\t");  
	        }  
	        System.out.println();  
	    }  
	  

}
