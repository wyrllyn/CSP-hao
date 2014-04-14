package core;

import core.Solution.Init;

public class Resolution {
	
	private static final int DEFAULT_TEMPERATURE = 2000;
	protected static final int OK = -1;
	private Solution solution;
	private static int maxIteration = 100000;
	
	public Resolution(Solution solution){
		this.solution = solution;
	}

	public Solution getSolution() {
		return solution;
	}

	public void setSolution(Solution solution) {
		this.solution = solution;
	}
	
	public Solution simulatedAnnealing(){
		int delta = 0;
		double temperature = DEFAULT_TEMPERATURE;
		int iteration = 0;
		Solution bestSolution = solution;
		int initalCost = solution.calculateCost();
		do {
				Solution tempSolution = new Solution(solution);
				doRandomMove(tempSolution);
				//doMoveOnConflict(tempSolution);
				delta = solution.calculateCost() - tempSolution.calculateCost();
				double probability = probability();
				double e = Math.exp(-delta/temperature);
				//System.out.println("proba=" + probability + "; e=" + e);
				//System.out.println(solution.getVector() + " cost=" + solution.calculateCost());
				//System.out.println(tempSolution.getVector() + " cost=" + tempSolution.calculateCost());
				if (delta > 0 || (probability < e)){
					solution = tempSolution;
				}
				iteration++;
				temperature *= 0.99;
				System.out.println("iteration #" + iteration + "; cost=" + solution.calculateCost());
				
				if (solution.calculateCost() < bestSolution.calculateCost()) {
					bestSolution = solution;
				}
				
		} while (solution.calculateCost() > 0 && iteration < maxIteration);
		
		System.out.println("best cost=" + bestSolution.calculateCost() + " (initial cost = " + initalCost + ")");
		return bestSolution;
	}
	
	private int nonUsedValue(){
		for (int i = 0; i < solution.getVector().size(); i++){
			if (!solution.getVector().contains(i)){
				return i;
			}
		}
		
		return -1;
	}

	private double probability() {
		return Math.random();
	}

	protected void doRandomMove(Solution tempSolution) {
		Moves moves = new Moves(tempSolution);
		if (tempSolution.getInit() == Init.KNIGHT) {
			if (Math.random() <= 0.5) {
				int result = doSwap(tempSolution, moves);
				if (result != OK) {
					doOneMove(tempSolution, moves, result);
				}
			} else {
				doOneMove(tempSolution, moves);
			}
		} else {
			doSwapDiag(tempSolution, moves);
		}
	}
	
	protected void doSwapDiag(Solution tempSolution, Moves moves) {
		//System.out.println("doSwapDiag");
		int first = -1;
		int second = -1;
		while (first == second) {
			first = (int) (Math.random() * tempSolution.getVector().size() );
			second = (int) (Math.random() * tempSolution.getVector().size() );
		}
		moves.swap(first, second);
	}

	protected void doOneMove(Solution tempSolution, Moves moves) {
		//System.out.println("doOneMove");
		int toMove = (int) (Math.random() *tempSolution.getVector().size() );
		moves.move(toMove);
	}
	
	protected void doOneMove(Solution tempSolution, Moves moves, int toMove) {
		//System.out.println("doOneMove");
		int value = nonUsedValue();
		if (value != -1){
			solution.getVector().set(toMove, value);
		}
		else {		
			moves.move(toMove);
		}
	}

	protected int doSwap(Solution tempSolution, Moves moves) {
		//System.out.println("doSwap");
		int first = -1;
		int second = -1;
		while (first == second) {
			first = (int) (Math.random() * tempSolution.getVector().size() );
			second = (int) (Math.random() * tempSolution.getVector().size() );
		}
		
		if (tempSolution.getVector().get(first) == tempSolution.getVector().get(second)) {
			return first;
		} else {
			moves.swap(first, second);
			return OK;
		}
	}
}
