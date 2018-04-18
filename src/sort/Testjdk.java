package sort;

public class Testjdk {
	 public static void main(String [] args){
		  new Thread( new Runnable(){
		    	 public void run(){
		    		 loop(0);
		    	 }
		    	 public void loop(int i){
		    		 if(i!=2000){
		    			 i++;
		    			 loop(i);
		    		 }
		    			
		    	 }
		     }).start();
	 }
   
} 
