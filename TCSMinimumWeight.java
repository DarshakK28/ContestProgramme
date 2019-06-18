import java.util.*;

public class TCSMinimumWeight {
	int ans=0;
	/*int a[][]=new int[][] {{1,29,40,24,12},{13,31,40,31,33},{29,40,17,35,32},{15,39,28,3,31},{15,21,31,38,24}};*/
	int a[][]=new int[][] {{1, 5, 3, 6, 7},
		{1, 8, 9, 9, 9},
		{1, 7, 5, 4 ,3},
		{1, 8, 8, 8, 8},
		{1, 12, 12, 7, 6}};
	    public int min(int a,int b) {
			if(a>=b) {
				return b;
			}
			else {
				return a;
			}   	
	    }
	    
	    public int countPaths(int n,int m){
	        int T[][] = new int[n][m];
	        T[0][0]=a[0][0];
	        for(int i=1; i < n; i++){
	        	if(T[i-1][0]>a[i][0]) {
	        		T[i][0] = T[i-1][0];
	        	}
	        	else {
	        		T[i][0] = a[i][0];
	        	}
	        }
	        
	        for(int i=1; i < m; i++){
	        	if(T[0][i-1]>a[0][i]) {
	        		T[0][i] = T[0][i-1];
	        	}
	        	else {
	        		T[0][i] = a[0][i];
	        	}
	        	
	        }
	        for(int i=1; i < n; i++){
	            for(int j=1; j < m; j++){
	                T[i][j] = min(T[i-1][j],T[i][j-1]);
	                if(a[i][j]>T[i][j]) {
	                	T[i][j]=a[i][j];
	                }
	            }
	        }
	        
	        for(int i=0; i < n; i++){
	            for(int j=0; j < m; j++){
	                System.out.print(a[i][j]+"   ");
	            }
	            System.out.println();
	        }
	        System.out.println();
	        
	        for(int i=0; i < n; i++){
	            for(int j=0; j < m; j++){
	                System.out.print(T[i][j]+"   ");
	            }
	            System.out.println();
	        }
	        
	        return T[n-1][m-1];
	    }
	    
	    public static void main(String args[]){
	        TCSMinimumWeight nop = new TCSMinimumWeight();
	        System.out.println("Answer  : "+nop.countPaths(5,5));
	        
	    }
}

	 

