package week2_recur.micifang;

import java.util.Scanner;

/**
 * Created by zengyarong on 2017/9/27.
 */
public class Main {

    public String Enum(int input){
        String result = "";
        if(input<=2){
            if(input==1)
                return "";
            else
                return "("+String.valueOf(input)+")";
        }

        String bin_input = Integer.toBinaryString(input);

        for(int i = 0; i < bin_input.length(); i++) {
            if(bin_input.charAt(i)=='1'){
                int a = bin_input.length()-(i+1);
                result += "2"+Enum(a)+"+";
            }
        }
        return "("+result.substring(0,result.length()-1)+")";
    }

    public static void main(String [] args){
        Scanner scan = new Scanner(System.in);
        int input = scan.nextInt();
        Main main = new Main();
        String result = main.Enum(input);
        System.out.println(result.substring(1,result.length()-1));
    }
}
