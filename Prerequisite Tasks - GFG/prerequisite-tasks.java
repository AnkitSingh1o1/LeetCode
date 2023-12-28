//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
	public static void main(String args[]) throws IOException
	{
	    Scanner sc = new Scanner(System.in);
	    int t = sc.nextInt();
		while(t>0)
		{
		    int N = sc.nextInt();
		    int P = sc.nextInt();
		    int prerequisites[][] = new int[P][2];
		    for(int i=0;i<P;i++)
		    {
		        for(int j=0;j<2;j++)
		        {
		            prerequisites[i][j] = sc.nextInt();
		        }
		    }
			Solution ob = new Solution();
			if(ob.isPossible(N,P,prerequisites))
			{
			    System.out.println("Yes");
			}
			else{
			    System.out.println("No");
			}
			t--;
		}
	}
	
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    public boolean isPossible(int v,int e, int[][] edges)
    {
        // Your Code goes here
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < v; i++){
            adj.add(i, new ArrayList<>());
        }
        for(int i = 0; i < e; i++){
            adj.get(edges[i][0]).add(edges[i][1]);
        }
        
        //Topological Sort
        int[] indegree = new int[v];
        for(List<Integer> a : adj){
            for(int i : a){
                indegree[i]++;
            }
        }
        
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < v; i++){
            if(indegree[i] == 0)
            q.add(i);
        }
        int[] ans = new int[v];
        int i = 0;
        while(!q.isEmpty()){
            int node = q.peek();
            q.remove();
            
            ans[i++] = node;
            
            for(int it : adj.get(node)){
                indegree[it]--;
                if(indegree[it] == 0){
                    q.add(it);
                }
            }
        }
        
        return i == v ? true : false;
    }
    
}