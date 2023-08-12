//{ Driver Code Starts
import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        
        //taking input using Scanner class
        Scanner sc = new Scanner(System.in);
        
        //taking total testcases
        int t = sc.nextInt();
        while(t > 0){
            
            //taking size of array
            int n = sc.nextInt();
            int array[] = new int[n];
            
            //inserting elements in the array
            for (int i = 0; i < n; ++i)
            {
                array[i] = sc.nextInt();
            }
            
            //creating an object of class Solution
            Solution ob = new Solution();
            
            //calling longestSubsequence() method of class
            //Solution
            System.out.println(ob.longestSubsequence(n,array));
            t--;
        }
    } 
} 
// } Driver Code Ends




class Solution 
{
    //Function to find length of longest increasing subsequence.
    static int longestSubsequence(int size, int a[])
    {
        // code here
        List<Integer> temp = new ArrayList<>();
        temp.add(a[0]);
        int len = 1;
        
        for(int i = 1; i < size; i++){
            if(a[i] > temp.get(temp.size()-1)){
                temp.add(a[i]);
                len++;
            }
            else{
                int ind = findIndex(temp, a[i]);
                temp.set(ind, a[i]);
            }
        }
        
        return len;
    }
    
    static int findIndex(List<Integer> temp, int target){
        int left = 0, right = temp.size()-1;
        int ans = temp.size();
        
        
        while(left <= right){
            int mid = left + (right-left)/2;
            if(temp.get(mid) >= target){
                ans = mid;
                right = mid-1;
            }
            else{
                left = mid+1;
            }
        }
        
        return ans;
    }
} 