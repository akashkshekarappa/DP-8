import java.util.List;
//Time Complexity : O(n^2)
//Space Complexity : O(1)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

public class Triangle {
	public int minimumTotal(List<List<Integer>> triangle) {
		//edge case
		if(triangle == null | triangle.size() == 0)
			return 0;
		int n = triangle.size();
		for(int i=n-2; i>=0; i--){  //from last row
			for(int j=0; j<triangle.get(i).size(); j++){    //for all elements of ith row
				triangle.get(i).set(j, triangle.get(i).get(j) + 
						Math.min(triangle.get(i+1).get(j), triangle.get(i+1).get(j+1)));     // get the min value from the row below from j and j+1 index and add
			}
		}
		return triangle.get(0).get(0);
	}
}
