/**********************************Brute Force*********************************/
// Time Complexity : O(n^2)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Arithmetic_Slices_BF {
	public int numberOfArithmeticSlices(int[] A) {
		if(A == null || A.length == 0)
			return 0;
		int count = 0;
		for(int i=0; i<A.length-2; i++){
			int diff = A[i+1] - A[i];
			for(int j=i+1; j<A.length-1; j++){
				if(A[j+1] - A[j] == diff){
					count ++;
				}
				else{
					break;
				}
			}
		}
		return count;
	}
}
/********************************** Using Dynamic Programming *********************************/
//Time Complexity : O(n)
//Space Complexity : O(n)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

class Arithmetic_Slices_DP {
	public int numberOfArithmeticSlices(int[] A) {
		if(A == null || A.length < 3)
			return 0;
		int sum = 0;
		int[] dp = new int[A.length];
		for(int i=2; i<A.length; i++){
			if(A[i-1] - A[i-2] == A[i] - A[i-1]){
				dp[i] = dp[i-1] +1;
				sum+= dp[i];
			}   
		}
		return sum;
	}
}

/********************************** Using Dynamic Programming *********************************/
//Time Complexity : O(n)
//Space Complexity : O(1)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

class Arithmetic_Slices_DP1 {
	public int numberOfArithmeticSlices(int[] A) {
		if(A == null || A.length < 3)
			return 0;
		int sum = 0;
		int prev = 0;
		int curr = 0;
		for(int i=2; i<A.length; i++){
			if(A[i-1] - A[i-2] == A[i] - A[i-1]){
				curr = prev + 1;
				sum+= curr;
				prev = curr;
			}
			else{
				prev = 0;
			}
		}
		return sum;
	}
}