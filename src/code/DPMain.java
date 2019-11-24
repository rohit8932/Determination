package code;

public class DPMain {
	public static void main(String[] args) {
		DP dp = new DP();
//		System.out.println(dp.fibonacciUsingRecursion(10));
//		System.out.println(dp.fibonacciUsingDP(10));
	
//		System.out.println(dp.coinChangeDP(new int[] {1, 2, 3}, 2, 0));
//		System.out.println(dp.coinChangeRecursive(new int[] {1, 2, 3}, 5, 0));
		
//		System.out.println(dp.coinChangeBottomUp(new int[] {1, 2, 3}, 6));
//		System.out.println(dp.minNumCoinsRequired(new int[] {1, 2, 3}, 1));
		
		System.out.println(dp.knapsackProblemRepeatSelection(new int[]{0, 2, 10, 3, 6, 18}, new int[] {0, 1, 20, 3, 14, 100}, 15));
		//System.out.println(dp.knapsackProblemNoRepeat(new int[]{0, 2, 10, 3, 6, 18}, new int[] {0, 1, 20, 3, 14, 100}, 15, 0));
	}
	

}
