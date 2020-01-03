package code;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DP {
	int[] knownResult = new int[100];
	int count = 0;
	DP() {
		for(int i = 0; i < 100; i++) {
			knownResult[i] = -1;		
		}
	}
	
	//time- O(2^n) space- O(n)
	public int fibonacciUsingRecursion(int n) {
		if(n == 0) {
			return 0;
		}
		if(n == 1) {
			return 1;
		}
		
		return fibonacciUsingRecursion(n-1) + fibonacciUsingRecursion(n-2);
	}
	
	//time- O(n) space- O(n)
	public int fibonacciUsingDP(int n) {
		if(knownResult[n] != -1) {
			return knownResult[n];
		}
		if(n == 1) {
			return 1;
		}
		if(n == 0) {
			return 0;
		}
		knownResult[n] = fibonacciUsingDP(n-1) + fibonacciUsingDP(n - 2);
		return knownResult[n];
	}
	
	//time- O(numCoins^n) space- O(n)
	public int coinChangeRecursive(int[] coins, int n, int count) {
		if(n == 0)
			return count+1;
		
		for(int i = 0; i < coins.length; i++) {
			if(coins[i] <= n) {				
				count = coinChangeRecursive(coins, n - coins[i], count);
			}
		}
		return count;
	}
	
	//time- O(n) space- O(n)
	public int coinChangeDP(int[] coins, int n, int count) {
		if(n == 0) {
			return count + 1;
		}
		
		if(knownResult[n] != -1) {
			return count + knownResult[n];
		}
		
		for(int i = 0; i < coins.length; i++) {
			if(coins[i] <= n) {
				count = coinChangeDP(coins, n - coins[i], count);
			}
		}
		knownResult[n] = count;
		return count;
	}
	
	//time- O(n) space- O(n)
	public int coinChangeBottomUp(int[] coins, int n) {
		int[] arr = new int[n + 1];
		arr[0] = 0;
		
		for(int i = 1; i <= n; i++) {
			for(int j = 0; j < coins.length; j++) {
				if(i - coins[j] >= 0) {
					if(coins[j] == i) {
						arr[i] += arr[i-coins[j]] + 1;
					}
					arr[i] += arr[i-coins[j]];
				}
			}
		}
		return arr[n];
	}
	
	//time- O(coins^n) space- O(n) where n is sum
	public int minNumCoinsRequired(int[] coins, int sum) {
		if(sum == 0) {
			return 0;
		}
		int min = Integer.MAX_VALUE - 1;
		for(int coin : coins) {
			if(coin <= sum) {
				min = Math.min(min, minNumCoinsRequired(coins, sum - coin));
			}
		}
		return min + 1;
	}
	
	//time- space-
	public int knapsackProblemRepeatSelection(int[] weights, int[] values, int w) {
		if(w <= 0) {
			return 0;
		}
		int maxValue = Integer.MIN_VALUE;
		for(int i = 0; i < weights.length; i++) {
			if(i == 0)
				continue;
			if(weights[i] <= w) {
				maxValue = Math.max(maxValue,knapsackProblemRepeatSelection(weights, values, w - weights[i]) + values[i]);
			}
		}
		return maxValue;
	}
	
	//time- space-
	public int knapsackProblemNoRepeat(int[] weights, int[] values, int w, int index) {
		if(w <= 0) {
			return 0;
		}

		int maxValue = Integer.MIN_VALUE;
		
		for(int i = index; i < weights.length; i++) {
			if(weights[i] <= w)
				maxValue = Math.max(maxValue,knapsackProblemNoRepeat(weights, values, w - weights[i], i + 1) + values[i]);
		}
		return maxValue;
	}
	
	//time- O(nums^2) space- O(n)
	public int targetSumBruteForce(int[] nums, int T, int i, int sum) {
		if(i == nums.length) {
			if(sum == T)
				return 1;
			else
				return 0;
		}
		
		return (targetSumBruteForce(nums, T, i + 1, sum + nums[i]) + targetSumBruteForce(nums, T, i + 1, sum - nums[i]));
	
	}
	
	
	public int targetSumDP(int[] nums, int T, int i, int sum, Map<Integer, Map<Integer, Integer>> cache) {
		if(i == nums.length) {
			return sum == T? 1 : 0;
		}
		if(!cache.containsKey(i)) {
			cache.put(i, new HashMap<Integer, Integer>());
		}
		
		Integer cached = cache.get(i).get(sum);
		if(cached != null) return cached;
		
		int toReturn = targetSumDP(nums, T, i + 1, sum + nums[i], cache) 
				+ targetSumDP(nums, T, i + 1, sum - nums[i], cache);
		
		cache.get(i).put(sum, toReturn);
		
		return toReturn;
	}

	//time- O(weights^2) space- O(weights)
	public int knapsackBruteForce(int[] weights, int[] values, int w, int i) {
		if(i >= weights.length || w <= 0) {
			return 0;
		}
		return Math.max(knapsackBruteForce(weights, values, w - weights[i], i + 1) + values[i], knapsackBruteForce(weights, values, w, i + 1));
	}
	
	public int knapsackDP(int[] weights, int[] values, int w, int i, Map<Integer, Map<Integer, Integer>> cache) {
		if(i >= weights.length || w <= 0) {
			return 0;
		}
		if(!cache.containsKey(w)) {
			cache.put(w, new HashMap<Integer, Integer>());
		}
		Integer cached = cache.get(w).get(i);
		if(cached != null) return cached;
		
		int toReturn = Math.max(knapsackDP(weights, values, w - weights[i], i + 1, cache) + values[i], knapsackDP(weights, values, w, i + 1, cache));
		cache.get(w).put(i, toReturn);
		return toReturn;
	}
	
	//time- O(n^2) space- O(n)
	public int rodCuttingBruteForce(int[] profit, int n) {
		if(n == 0) {
			return 0;
		}
		int max = -99;
		for(int i = 1; i <= n; i++) {
			max = Math.max(max, profit[i] + rodCuttingBruteForce(profit, n-i));
		}
		return max;
	}
	
	//time- O(2^max(n,m)) space- O(max(n,m)) where n and m are length of two strings
	public int lcs(String str1, String str2, int i, int j) {
		if(i < 0 || j < 0) {
			return 0;
		}
		if(str1.charAt(i) == str2.charAt(j)) {
			return lcs(str1, str2, i - 1, j -1 ) + 1;
		}else {
			return Math.max(lcs(str1, str2, i, j - 1), lcs(str1, str2, i - 1, j));
		}
		
	}
	
	//time- O(2^n) space-O(n)
	public int lis(int[] arr, int i, int prev) {
		if(i == arr.length) {
			return 0;
		}
		if(arr[i] > prev)
			return Math.max(lis(arr, i + 1, arr[i]) + 1,  lis(arr, i + 1, prev));
		else
			return lis(arr, i + 1, prev);
	}
	
	//time- O() space- O()
	public int lis_dp(int[] arr, int i, int prev) {
		if(i == arr.length) {
			return 0;
		}
		if(knownResult[i] != -1)
			return knownResult[i];
		
		if(arr[i] > prev) {
			knownResult[i] = Math.max(lis_dp(arr,i + 1, arr[i]) + 1, lis_dp(arr, i + 1, prev) );
			return knownResult[i];
		}else {
			return lis_dp(arr, i + 1, prev);
		}	
	}
	
	//time- O() space-O()
	public int editDistance(String str1, String str2, int i, int j) {
		if(i == 0) {
			return j;
		}
		if(j == 0) {
			return i;
		}
		
		if(str1.charAt(i) == str2.charAt(j)) {
			return editDistance(str1, str2, i - 1, j - 1);
		}
		else {
			return Math.min(editDistance(str1, str2, i, j - 1) + 1, 
					Math.min(editDistance(str1, str2, i - 1, j) + 1,editDistance(str1, str2, i - 1, j - 1) + 1));
		}
	}

	
	//time- O() spce- O()
	public void wordBreak(List<String> dict, String str, String out) {		
		if(str.length() == 0) {
			System.out.println(out);
		}
		
		for(int i = 0; i <= str.length(); i++) {
			String preFix = str.substring(0, i);
			if(dict.contains(preFix)) {
				wordBreak(dict, str.substring(i), out + " " + preFix);
			}
		}
			
	}
	
	public void  robotInGrid(int[][] mat, int i, int j, int x, int y) {
		if(i == x && j == y) {
			System.out.println("Reached destination");
			 count = count + 1 ;
			return;
		}
		
		if(isSafe(mat, i + 1, j)) {
			robotInGrid(mat, i + 1, j, x, y);
		}
		if(isSafe(mat, i, j + 1)) {
			robotInGrid(mat, i, j + 1, x, y);			
		}
	}
	private boolean isSafe(int[][] mat, int x, int y) {
		if(x < mat.length && y < mat[0].length && mat[x][y] != 1) {
			return true;
		}
		return false;
	}
	
	//time- O(log n) space- O()
	public void magicNumber(int[] arr, int start, int end) {
		if(start < 0 || end > arr.length) {
			return;
		}
		int mid = (start + end) / 2;
		if(arr[mid] == mid) {
			System.out.println("Magic number found " + mid );
		}else if(mid < arr[mid] ) {
			magicNumber(arr, start, mid - 1);
		}else {
			magicNumber(arr, mid + 1, end);
		}
	}
	
	//time- O(2^n) space- O(n)
	public void generatePowerSet(int[] arr, int i, int[] temp, int k) {
		if(i >= arr.length) {
			for(int j = 0; j < k; j ++) {
				System.out.print(temp[j] + " ");
			}
			System.out.println();
			return;
		}
		
		
		temp[k] = arr[i];
		generatePowerSet(arr, i + 1, temp, k + 1);
		generatePowerSet(arr, i + 1, temp, k); 
	}
	
	
}