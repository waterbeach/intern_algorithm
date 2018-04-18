package week1_enum.mimasuo;

import java.util.Scanner;

/**
 * Created by zengyarong on 2017/9/24.
 */
public class Main {

    private static int switches;

    public static int getBit(int c,int i){
        return (c >> i) &1;
    }

    public static int setBit(int c,int i,int v){
        if(v==1)
            c |= (1<<i);//或
        else
            c &= ~(1<<i);//与
        return c;
    }


    public static int flitBit(int c,int i){//翻转状态
        c ^= (1<<i);
        return c;
    }

    public static void main(String [] args){
        //输入数据
        Scanner scan = new Scanner(System.in);
        int origin=0,target=0;

        char [] str1 = scan.nextLine().toCharArray();
        char [] str2 = scan.nextLine().toCharArray();
        int count = str1.length; //记录密码锁长度

        for (int i = 0; i < count; i++) {
            origin = setBit(origin, i, str1[i]-'0');
            target = setBit(target, i,str2[i]-'0');
        }

        //枚举改变动作
        int changeTurn;
        int minChange = 30;
        boolean flag = false;
        for(int i =0;i< 2;i++){

            changeTurn = 0;
            int current = origin;
            switches = i;

            for(int j = 0;j<count;j++){
                if(switches==1){//按下按钮
                    changeTurn++;
                    if(j>0)
                        current = flitBit(current,j-1);
                    current = flitBit(current,j);
                    if(j<count-1)
                        current = flitBit(current,j+1);
                }
                if(getBit(current,j)!=getBit(target,j))
                    switches =1;
                else
                    switches = 0;

            }

            if(current == target){
                flag = true;
                if(changeTurn < minChange)
                    minChange = changeTurn;
            }
        }
        if(flag)
            System.out.println(minChange);
        else
            System.out.println("impossible");

    }

}
/*
思路解析：
010001
000000

只需枚举局部状态：
是否按下第一个的状态确定了，则是否要按下2就确定了，后面的345....同理
所以只需枚举第一个密码的状态，即为0/1
 */
