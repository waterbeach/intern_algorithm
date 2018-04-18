package sort;

public class BubbleSort {


    public static void main(String[] args) {

        int[] list = {4, 89, 67, 23, 12, 34, 90};
        bubblesort(list);

        System.out.println("After BubbleSort the array is: ");
        for (int i = 0; i < list.length; i++)
            System.out.print(list[i] + " ");
    }

    public static void bubblesort(int[] list) {
        boolean flag = true;

        for (int k = 1; k < list.length && flag == true; k++) {
            flag = false;
            for (int i = 0; i < list.length - 1 - i; i++) {
                if (list[i] > list[i + 1]) {
                    int temp = list[i];
                    list[i] = list[i + 1];
                    list[i + 1] = temp;
                    flag = true;
                }
            }
        }
    }

}
