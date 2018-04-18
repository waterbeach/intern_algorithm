package Mst;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;


public class MstTest {
	 public static void main(String[] args) {  
	        List<Path> mst = Kruskal.execute();  
	        for (Path path: mst) {  
	            System.out.println(path.p1 + "\t" + path.p2 + "\t" + path.len);  
	        }  
	    }  
	}  
	  

	class Kruskal {  
	      
	    public static List<Path> execute() {  
	        List<Path> mst = new ArrayList<Path>();  
	          
	        Scanner in = new Scanner(System.in);  
	          
	        int n = in.nextInt();  
	        int m = in.nextInt();  
	          
	        List<Set<Integer>> sets = new ArrayList<Set<Integer>>();  
	        for (int i = 0; i < n; i++) {  
	            Set<Integer> set = new HashSet<Integer>();  
	            set.add(i);  
	            sets.add(set);  
	        }  
	          
	        Heap<Path> heap = new Heap<Path>();  
	        heap.setMaxHeap(false);  
	        int f, t, l;  
	        for (int i = 0; i < m; i++) {  
	            f = in.nextInt();  
	            t = in.nextInt();  
	            l = in.nextInt();  
	              
	            Path path = new Path(f, t, l);  
	            heap.add(path);  
	        }  
	        in.close();  
	          
	        while (sets.size() != 1 && !heap.isEmpty()) {  
	            Path path = heap.pop();  
	            int p1 = path.p1;  
	            int p2 = path.p2;  
	              
	            Set<Integer> p1Set = null;  
	            for (Set<Integer> s: sets) {  
	                if (s.contains(p1)) {  
	                    p1Set = s;  
	                    break;  
	                }  
	            }  
	            if (!p1Set.contains(p2)) {  
	                Set<Integer> p2Set = null;  
	                for (Set<Integer> s: sets) {  
	                    if (s.contains(p2)) {  
	                        p2Set = s;  
	                        break;  
	                    }  
	                }  
	                sets.remove(p2Set);  
	                p1Set.addAll(p2Set);  
	                mst.add(path);  
	            }  
	        }  
	          
	        return mst;  
	    }  
	}  
	  
	class Path implements Comparable<Path> {  
	    public int p1;  
	    public int p2;  
	    public int len;  
	      
	    public Path(int p1, int p2, int len) {  
	        this.p1 = p1;  
	        this.p2 = p2;  
	        this.len = len;  
	    }  
	  
	    @Override  
	    public int compareTo(Path o) {  
	        return this.len - o.len;  
	    }  
	}  
	  
	//7 11  
	//0 1 12  
	//1 2 32  
	//2 5 3  
	//5 6 24  
	//0 6 18  
	//0 3 25  
	//1 3 14  
	//0 4 34  
	//3 4 10  
	//3 5 8  
	//4 5 7  