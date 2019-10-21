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
	
}
