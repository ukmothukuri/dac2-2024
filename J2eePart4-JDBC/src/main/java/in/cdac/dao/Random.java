package in.cdac.dao;

public class Random {
	 public static void main(String args[])
	    {
	        int max = 84;
	        int min = 1;
	        int range = max - min + 1;

	        for (int i = 0; i < 10; i++) {
	            int rand = (int)(Math.random() * range) + min;
	            
	            System.out.println(rand);
	            break;
	        }
	    }
}
