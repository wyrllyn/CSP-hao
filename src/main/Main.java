package main;

import core.Resolution;
import core.Solution;

public class Main {

	private static int size = Solution.DEFAULT_SIZE;
	private static Solution.Init init = Solution.Init.KNIGHT;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		dealWithArgs(args);
		Solution solution = new Solution(size);
		switch (init) {
		case KNIGHT:
			solution.init_knight();
			break;
		case DIAG:
			solution.init_diag();
			break;
		}
		Resolution resolution = new Resolution(solution);
		resolution.simulatedAnnealing();
	}

	private static void dealWithArgs(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
