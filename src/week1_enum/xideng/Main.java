package week1_enum.xideng;

import java.util.Scanner;

/**
 * Created by zengyarong on 2017/9/23.
 * 熄灯问题
 */
public class Main {

    static byte [] orjLights = null; //原始灯的状态，不变
    static byte [] Lights = null; //灯中间变化的状态
    static byte [] result = null; //最终的开关动作结果
    static byte switches; //某一行的改变状态

    public static int getBit(byte c,int i){
        return (c >> i) &1;
    }

    public static byte setBit(byte c,int i,int v){
        if(v==1)
            c |= (1<<i);//或
        else
            c &= ~(1<<i);//与
        return c;
    }

    public static byte flitBit(byte c,int i){//翻转，改变灯的状态
        c ^= (1<<i);
        return c;
    }

    public static void outputResult(int t,byte result[]){
        System.out.println("PUZZLE #"+(t+1));
        for(int i=0;i<5;i++){
            for(int j=0;j<6;j++){
                System.out.print(getBit(result[i],j)+" ");
            }
            System.out.println();
        }
    }

    public static void main(String [] args){

        //输入数据
        Scanner scan = new Scanner(System.in);
        int test = scan.nextInt();
        for(int t =0;t<test;t++) {
            orjLights = new byte[5]; //原始灯的状态，不变
            Lights = new byte[5]; //灯中间变化的状态
            result = new byte[5]; //最终的开关动作结果

            for (int r = 0; r < 5; r++)
                for (int c = 0; c < 6; c++) {
                    int stat = scan.nextInt();
                    orjLights[r] = setBit(orjLights[r], c, stat);

                }

            for (int i = 0; i < 64; i++) {//枚举改变灯状态的动作
                for(int tmp = 0;tmp<5;tmp++){//每次都要重新赋值
                    Lights[tmp] = orjLights[tmp];
                }
                switches = (byte) i;

                for (int r = 0; r < 5; r++) {
                    result[r] = switches;
                    for (int c = 0; c < 6; c++) {
                        if (getBit(switches, c) == 1) {//按下，改变该行左右灯的状态
                            if (c > 0)
                                Lights[r] = flitBit(Lights[r], c - 1);
                            Lights[r] = flitBit(Lights[r], c);
                            if (c < 5)
                                Lights[r] = flitBit(Lights[r], c + 1);
                        }
                    }
                    if (r < 4)
                        //改变下一行的开关状态，与1异或取反，与0异或不变
                        Lights[r + 1] ^= switches;//1表示按下，0表示不按
                    switches = Lights[r];//确定下一行的开关动作
                }
                //判断最后一行灯的状态
                if (Lights[4] == 0) {
                    outputResult(t, result);
                    break;
                }
            }
        }
        return;
    }
}


/*
Sample Input
2
case1:
0 1 1 0 1 0
1 0 0 1 1 1
0 0 1 0 0 1
1 0 0 1 0 1
0 1 1 1 0 0
case2:
0 0 1 0 1 0
1 0 1 0 1 1
0 0 1 0 1 1
1 0 1 1 0 0
0 1 0 1 0 0

Sample Output

PUZZLE #1
1 0 1 0 0 1
1 1 0 1 0 1
0 0 1 0 1 1
1 0 0 1 0 0
0 1 0 0 0 0
PUZZLE #2
1 0 0 1 1 1
1 1 0 0 0 0
0 0 0 1 0 0
1 1 0 1 0 1
1 0 1 1 0 1

*/