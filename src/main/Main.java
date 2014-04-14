package main;

import core.Resolution;
import core.Solution;
import core.Solution.Init;

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
		for (int i = 0; i < args.length; i++) {
			switch (args[i]) {
			case "-knight":
				init = Init.KNIGHT;
				break;
			case "-diag":
				init = Init.DIAG;
				break;
			case "-size":
				size = Integer.parseInt(args[++i]);
				break;
			}
		}
	}

}
