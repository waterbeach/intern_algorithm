package Mst;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class DijkstraTest {
	 public static void main(String[] args) {  
	        new Dijkstra().execute();  
	    }  
	}  
	  
	/* 
	 * ʵ�ֵ�Դ���·����Dijkstra�㷨 
	 * ͨ����׼����������ͼ����Ϣ 
	 * ������ʵ�ֵ�������ͼ�еĵ�Դ���·������Ҫ������ͼ����ֻ���޸ĵ�45�� 
	 * �������ݵ�һ��Ϊ��������n m��nΪ�������mΪ���� 
	 * ���ı�Ŵ�0��n-1 
	 * ������Ϊm�����ݣ���ʾÿ���ߵ���Ϣ����ʽΪf t l���ֱ��ʾ�����յ�ı�ţ��Լ���Ȩֵ 
	 * ���һ��Ϊ������������ʾҪ��·���������յ��� 
	 * �������ݼ���� 
	 */  
	class Dijkstra {  
	      
	    private static final int INFINITE = 9999;  
	      
	    public void execute() {  
	        Scanner in = new Scanner(System.in);  
	          
	        int n = in.nextInt(); // number of points  
	        int m = in.nextInt(); // number of paths  
	          
	        int[][] paths = new int[n][n];  
	        for (int i = 0; i < n; i++) {  
	            for (int j = 0; j < n; j++) {  
	                paths[i][j] = INFINITE;  
	            }  
	        }  
	          
	        int f, t, l;  
	        for (int i = 0; i < m; i++) {  
	            f = in.nextInt();  
	            t = in.nextInt();  
	            l = in.nextInt();  
	            paths[f][t] = paths[t][f] = l;  
	        }  
	          
	        int sp = in.nextInt(); // starting point  
	        int fp = in.nextInt(); // finishing point  
	          
	        in.close();  
	          
	        int[] dist = new int[n];  
	        List<List<Integer>> sPaths = new ArrayList<List<Integer>>();  
	        List<Integer> list = new ArrayList<Integer>();  
	        for (int i = 0; i < n; i++) {  
	            dist[i] = paths[sp][i];  
	            if (sp != i) {  
	                list.add(i);  
	            }  
	            if (dist[i] < INFINITE) {  
	                List<Integer> spa = new ArrayList<Integer>();  
	                sPaths.add(spa);  
	            } else {  
	                sPaths.add(null);  
	            }  
	        }  
	          
	        while (!list.isEmpty()) {  
	            Integer minIdx = list.get(0);  
	            for (int i: list) {  
	                if (dist[i] < dist[minIdx]) {  
	                    minIdx = i;  
	                }  
	            }  
	              
	            list.remove(minIdx);  
	              
	            for (int i = 0; i < n; i++) {  
	                if (dist[i] > dist[minIdx] + paths[minIdx][i]) {  
	                    dist[i] = dist[minIdx] + paths[minIdx][i];  
	                    List<Integer> tmp = new ArrayList<Integer>(sPaths.get(minIdx));  
	                    tmp.add(minIdx);  
	                    sPaths.set(i, tmp);  
	                }  
	            }  
	        }  
	          
	        System.out.println(dist[fp]);  
	        System.out.print(sp + " --> ");  
	        for (int p: sPaths.get(fp)) {  
	            System.out.print(p + " --> ");  
	        }  
	        System.out.println(fp);  
	    }  
	}  
	  
	//��������  
	//10 14  
	//0 1 3  
	//0 5 4  
	//0 8 5  
	//1 2 6  
	//2 3 1  
	//2 5 4  
	//3 4 8  
	//3 6 2  
	//3 7 5  
	//4 7 2  
	//5 6 3  
	//6 7 7  
	//8 9 2  
	//9 7 3  
	//0 4  


