package SwordOffer;

import java.util.Scanner;

public class ReplaceBlank {
    public static String replaceSpace(StringBuffer str) {
        int blankNum = 0;
        for(int i = 0;i<str.length();i++){
            if(str.charAt(i)==' ')
                blankNum++;
        }
        if(blankNum==0)
            return str.toString();
        char [] c = new char[(str.length()-blankNum)+blankNum*3];

        int j = (str.length()-blankNum)+blankNum*3-1;
        for(int i = str.length()-1;i>=0;i--){
            if(str.charAt(i)==' '){
                c[j] = '0';
                c[--j]='2';
                c[--j]='%';
            }
            else
                c[j] = str.charAt(i);
            j--;
        }
        return String.valueOf(c);
    }

//    public static void main(String [] args){
//        StringBuffer a = new StringBuffer("We Are Happy");
//        System.out.println(new ReplaceBlank().replaceSpace(a));
//    }

    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        //获取输入的整数序列
        String str = sc.nextLine();
        StringBuffer a = new StringBuffer(str);
        System.out.println(replaceSpace(a));
    }
}
