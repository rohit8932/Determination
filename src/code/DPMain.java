package code;

import java.util.HashMap;
import java.util.Map;

public class DPMain {
	public static void main(String[] args) {
		DP dp = new DP();
//		System.out.println(dp.fibonacciUsingRecursion(10));
//		System.out.println(dp.fibonacciUsingDP(10));
	
//		System.out.println(dp.coinChangeDP(new int[] {1, 2, 3}, 2, 0));
//		System.out.println(dp.coinChangeRecursive(new int[] {1, 2, 3}, 5, 0));
		
//		System.out.println(dp.coinChangeBottomUp(new int[] {1, 2, 3}, 6));
//		System.out.println(dp.minNumCoinsRequired(new int[] {1, 2, 3}, 1));
		
//		System.out.println(dp.knapsackProblemRepeatSelection(new int[]{0, 2, 2, 2, 6, 18}, new int[] {0, 1, 20, 3, 15, 20}, 2));
//		System.out.println(dp.knapsackProblemNoRepeat(new int[]{0, 2, 2, 2, 6, 18}, new int[] {0, 1, 20, 3, 15, 20}, 2, 0));
		
//		System.out.println(dp.targetSumDP(new int[] {1, 1, 1, 1, 1}, 3, 0, 0, new HashMap<Integer, Map<Integer,Integer>>()));
//		System.out.println(dp.targetSumBruteForce(new int[] {1, 1, 1, 1, 1}, 3, 0, 0));
		
//		System.out.println(dp.knapsackBruteForce(new int[]{0, 2, 2, 2, 6, 18}, new int[] {0, 1, 20, 3, 15, 20}, 2, 0));
//		System.out.println(dp.knapsackDP(new int[]{0, 2, 2, 2, 6, 18}, new int[] {0, 1, 20, 3, 15, 20}, 2, 0, new HashMap<Integer, Map<Integer,Integer>>()));
		
//		System.out.println(dp.rodCuttingBruteForce(new int[] {0, 1, 5, 8, 9}, 4));
		
//		System.out.println(dp.lcs("AGGTAB", "GXTXAYB", 5, 6));
//		int[] arr = new int[] {3, 10, 2, 1, 20};
//		System.out.println(dp.lis(arr, 0, Integer.MIN_VALUE));
//		System.out.println(dp.lis_dp(arr, 0, Integer.MIN_VALUE));
		
		System.out.println(dp.editDistance("sunday", "saturday", 5, 7));
		
	}
	

}
