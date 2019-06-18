/*In the amusement park at Looney’s amusement, there is a “Weighted Maze” challenge. This consists of a set of East West roads (referred to as left to right roads) and North South roads (referred to as up down roads). Each intersection has a block of iron bar, the weight of which is given. You enter the maze at the top left corner with 1 kg in a cart. The exit from the maze is at the bottom right corner. Movement at any intersection is to the right or down provided a road exists in that direction.

At each intersection you pass through, you must exchange the weight in your cart with the weight of the bar at the intersection if it is heavier than the weight you have in the cart.

The objective is to determine a path through the maze along the roads so that one can exit the maze with the minimum weight in the cart.
For example, in the maze shown, the least weight one can exit the maze is 22 kg.

-> 1 8 21 7
19 17 10 20
2 18 23 22
14 25 4 13 ->

Input:
The first line consists of a positive integer n, which is the number of intersection in any up-down or left-right road.
The next n lines each consist of n positive integers representing the weights at the intersections in the corresponding left-right road

Output:
A positive integer that represents the minimum weight possible in the cart when exiting the maze.

Example
Input
4
1,8,21,7
19,17,10,20
2,18,23,22
14,25,4,13
Output
22

Explanation
One possible path through the maze is through the intersections with coordinates
(1,1),(1,2),(2,2),(2,3)(2,4)(3,4),(4,4). This would result in the cart having a weight of 22 kg ( at the intersections on this path,, the weight in the cart after the exchange are 1,8,17,18,18,20,22,22

Input
5 1,29,40,24,12 13,31,40,31,33 29,40,17,35,32 15,39,28,3,31 15,21,31,38,24
Output
38
Explanation
One path through the maze is (1,1),(2,1), (3,1),(4,1),(5,1),(5,2), (5,3), (5,4) (5,5). The maximum weight in this path is 38, which is the weight in the cart when leaving the maze.
As there is no other pathe in the maze which has a lower weight in the cart when exiting it, the output is 38*/
import java.util.*;

public class MinimumWeight {
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
	        MinimumWeight nop = new MinimumWeight();
	        System.out.println("Answer  : "+nop.countPaths(5,5));
	        
	    }
}

	 

