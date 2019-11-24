package code;

public class DP {
	int[] knownResult = new int[100];
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
}
