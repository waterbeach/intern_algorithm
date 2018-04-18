package week1_enum.TheClocks;

import java.util.Scanner;

/**
 * Created by zengyarong on 2017/9/24.
 * 拨钟问题
 1         ABDE    0,1,3,4
 2         ABC     0,1,2
 3         BCEF    1,2,4,5
 4         ADG     0,3,6
 5         BDEFH   1,3,4,5,7
 6         CFI     2,5,8
 7         DEGH    3,4,6,7
 8         GHI     6,7,8
 9         EFHI    4,5,7,8

 A B C D E F G H I
 0 1 2 3 4 5 6 7 8
 */

public class Main {

    //用二维数组存储移动影响的时钟
    private final int [][] influArrays = {{0,1,3,4},{0,1,2},{1,2,4,5},{0,3,6},{1,3,4,5,7},{2,5,8},{3,4,6,7},{6,7,8},{4,5,7,8}};//每个动作影响的时钟
    private int [] moveList = new int[9];//每个动作移动多少次0,1,2,3
    private static int[] originTime = new int[9];//原始时钟时间
    private static int[] currentTime = new int[9];//中间时钟时间
    private static int[] result;//存储结果
    private int minPath = 65535;


    public void iteMove(int n){
        //边界条件，9个动作都遍历
        if(n>=9){
            System.arraycopy(originTime, 0, currentTime, 0, 9);

            int totaltime=0;
            for(int i = 0;i<9;i++){
                totaltime +=  moveList[i];
                for(int j :influArrays[i]){//移动i会影响的时钟
                    currentTime[j] = (currentTime[j]+ moveList[i]) % 4;//更新时钟状态
                }
            }

            int a;
            //判断是否满足条件，都到12点
            for(a=0 ;a < 9;a++){
                if(currentTime[a]!=0)
                    break;
            }
            if(a==9) {
                //将最短路径存储到result
                if (totaltime < minPath) {
                    minPath = totaltime;
                    result = moveList.clone();

                }
            }
            return;
        }
        for(int i =0;i<4;i++){
            moveList[n] = i;//存储移动次数
            iteMove(n+1);
        }

    }

    public void Enum(){
        for(int i =0;i<4;i++){
            for(int j=0;j<4;j++){
                for(int k =0;k<4;k++){
                    int totaltime = i+j+k;
                    System.arraycopy(originTime, 0, currentTime, 0, 9);
                    moveList[3] = getMoveTimes((currentTime[0]+i+j)%4);//满足A
                    moveList[4] = getMoveTimes((currentTime[1]+i+j+k)%4);//B
                    moveList[5] = getMoveTimes((currentTime[2]+j+k)%4);//C
                    moveList[6] = getMoveTimes((currentTime[3]+i+moveList[3]+moveList[4])%4);//D
                    moveList[7] = getMoveTimes((currentTime[6]+moveList[3]+moveList[6])%4);//G
                    moveList[8] = getMoveTimes((currentTime[8]+moveList[5]+moveList[7])%4);//I

                    //判断E,F,H
                    currentTime[4] = (currentTime[4]+moveList[0]+moveList[2]+moveList[4]+moveList[6]+moveList[8])%4;//1,3,5,7,9
                    currentTime[5] = (currentTime[5]+moveList[2]+moveList[4]+moveList[5]+moveList[8])%4;//3,5,6,9
                    currentTime[7] = (currentTime[7]+moveList[4]+moveList[5]+moveList[7]+moveList[8])%4;//5,7,8,9

                    if(currentTime[4]!=0 || currentTime[5]!=0 || currentTime[7]!=0)
                        continue;
                    for(int a = 3;a<9;a++){
                        totaltime += moveList[a];
                    }
                    if(totaltime < minPath) {
                        minPath = totaltime;
                        result = moveList.clone();
                    }
                }
            }
        }
    }

    public int getMoveTimes(int n){
        if(n==0)
            return 0;
        else
            return (4-n);
    }

    public static void main(String [] args) {

        //输入数据
        Scanner scan = new Scanner(System.in);
        int i = 0;
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                originTime[i++] = scan.nextInt();
            }
        }

        Main main = new Main();
        //main.iteMove(0);
        main.Enum();

        //打印结果
        for (int r = 0; r < 9; r++) {
            for (int j = 0; j < result[r]; j++)
                System.out.print((r+1)+" ");
        }

    }
}

/*
思路解析：
目标：找最短的移动序列
1.暴力解法，遍历所有动作的所有移动次数，4^9次
2.条件判断方法，减少枚举次数
枚举动作1，2，3，后面的都能确定，找局部！！！！！
 */