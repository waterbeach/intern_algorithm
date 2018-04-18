package week2_recur.quanpailie;

import java.util.Scanner;

/**
 * Created by zengyarong on 2017/9/26.
 */
public class Main {

    private static char [] result;
    private static int num;
    public void Enum(char [] c){
        if(c.length==1){
            result[num - c.length] = c[0];
            System.out.println(String.valueOf(result));
            return;
        }
        for(int i=0;i<c.length;i++){
            result[num - c.length] = c[i];

            char [] tmp = new char[c.length-1];
            for(int j =0;j<i;j++)
                tmp[j] = c[j];
            for(int j =i+1;j<c.length;j++)
                tmp[j-1] = c[j];

            Enum(tmp);
        }
    }

    public static void main(String [] args){
        Scanner scan = new Scanner(System.in);
        char [] input = scan.nextLine().toCharArray();

        num = input.length;
        result = new char[num];

        Main main = new Main();
        main.Enum(input);

    }

}
