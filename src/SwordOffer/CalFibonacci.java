package SwordOffer;

public class CalFibonacci {
    // 递归，不实用，空间消耗大，且容易溢出
    public static int fibonacci(int n){
        if(n==0)
            return 0;
        if(n==1)
            return 1;
        return fibonacci(n-1)+fibonacci(n-2);
    }


    public static int fibonacci2(int n){
        int [] result = {0,1};
        if(n<2)
            return result[n];
        int fibOne = 0;
        int fibTwo = 1;
        int fibN = 0;
        for(int i = 2;i<=n;i++){
            fibN = fibOne+fibTwo;
            fibOne = fibTwo;
            fibTwo = fibN;
        }
        return fibN;
    }

    public static void main(String [] args){
        for(int i = 1;i<10;i++)
            System.out.println(fibonacci2(i));
    }



}
