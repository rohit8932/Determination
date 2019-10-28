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
	
}
