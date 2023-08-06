//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class Main {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int T=sc.nextInt();
		sc.nextLine();
		while(T-->0)
		{
		    
		    Solution ob=new Solution();
		    
		    String S=sc.nextLine();
		    
		    ArrayList<String> arr = ob.permutation(S);
		    for(String s : arr){
		        System.out.print(s+" ");
		    }
		    System.out.println();
		}
		
	}
}

// } Driver Code Ends


//User function Template for Java


class Solution
{
    public ArrayList<String> permutation(String S)
    {
        //Your code here
        char[] arr = S.toCharArray();
        ArrayList<String> ans = new ArrayList<>();
        boolean[] freq = new boolean[S.length()];
        
        fun(arr, new StringBuilder(), ans, freq);
        
        Collections.sort(ans);
        
        return ans;
    }
    
    public void fun(char[] arr, StringBuilder sb, 
    ArrayList<String> ans, boolean[] freq){
        
        if(sb.length() == arr.length){
            ans.add(sb.toString());
            return;
        }
        
        for(int i = 0; i < arr.length; i++){
            if(!freq[i]){
                freq[i] = true;
                sb.append(arr[i]);
                
                fun(arr, sb, ans, freq);
                
                sb.deleteCharAt(sb.length()-1);
                freq[i] = false;
            }
        }
    }
	   
}
