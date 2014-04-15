package main;

import java.util.Date;

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
		Date startTime = new Date();
		resolution.simulatedAnnealing();
		Date endTime = new Date();
		System.out.println(getRuntime(startTime, endTime));
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

	private static String getRuntime(Date startTime, Date endTime) {
		long time = endTime.getTime() - startTime.getTime();
		if (time < 1000) {
			return time + " ms";
		} else {
			String string = (time / 1000) + "." + (time % 1000) + " s";
			return string;
		}
	}
}
