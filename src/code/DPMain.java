package code;

public class DPMain {
	public static void main(String[] args) {
		DP dp = new DP();
//		System.out.println(dp.fibonacciUsingRecursion(10));
//		System.out.println(dp.fibonacciUsingDP(10));
	
		System.out.println(dp.coinChangeDP(new int[] {1, 2, 3}, 5, 0));
		System.out.println(dp.coinChangeRecursive(new int[] {1, 2, 3}, 5, 0));
		
	}
	

}
