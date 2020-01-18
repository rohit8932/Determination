package code;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

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
		
//		System.out.println(dp.editDistance("sunday", "saturday", 5, 7));
//		List<String> dict = Arrays.asList("this", "th", "is", "famous", "Word", 
//				"break", "b", "r", "e", "a", "k", "br", 
//				"bre", "brea", "ak");
//		String str = "Wordbreakproblem";
//		
//		dp.wordBreak(dict, str, "");
		
//		int[][] mat = new int[][] {{0, 0, 0},
//								   {0, 1, 0},
//								   {0, 0, 0}};
//		dp.robotInGrid(mat, 0, 0, 2, 2);
//		System.out.println(dp.count);
		
//		int[] arr = new int[] {-2, 0, 1, 3, 5};
//		dp.magicNumber(arr, 0, arr.length);
		
//		dp.generatePowerSet(new int[] {1, 2, 3, 4}, 0, new int[10], 0);
		
//		Set<String> result = new HashSet<>();
//		dp.permute(new char[] {'A', 'B', 'C', 'D', 'E'}, 0, result);
//		System.out.println();
//		System.out.println(result.size());
//		for(String str: result) {
//			System.out.println(str);
//		}
		
//		int [][]mat = new int[][] {{0, 1, 0, 1},
//								   {1, 0, 1, 1},
//								   {1, 1, 1, 1},
//								   {1, 0, 1, 1}};
//		dp.paintFill(mat, 0, 0, 0, 2);
//		
//		for(int i = 0; i < mat.length; i++) {
//			for(int j = 0; j < mat[0].length; j++) {
//				System.out.print(mat[i][j] + " ");
//			}
//			System.out.println();
//		}
//		int[] coins = new int[] {1, 3, 5, 7};
//		System.out.println(dp.numWaysToMakeChange(coins, 8));
//		System.out.println(dp.count);
//		
//		System.out.println(dp.minCoinsRequiredToMakeSum(coins, 8));
		
//		int[][] board = { { 0, 0, 0, 0 }, 
//                { 0, 0, 0, 0 }, 
//                { 0, 0, 0, 0 }, 
//                { 0, 0, 0, 0 } }; 
//		dp.nQueenProblem(board, 0);
		
//		int n = 3;
//		dp.parens(new char[n * 2], n, 0, 0, 0);
		
//		System.out.println(dp.stackOfBoxes(new int[] {1, 4, 2}, new int[] {3, 1, 6}, new int[] {1, 8, 2}));
		System.out.println(dp.tripleSteps(10));
		
		
	}
		
		
	

}
