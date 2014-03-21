package core;

public class Resolution {
	
	protected static final int OK = -1;
	private Solution solution;
	
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
		double temperature = 2000;
		int iteration = 0;
		int maxIteration = 100000;
		Solution bestSolution = solution;
		int initalCost = solution.calculateCost();
		do {
				Solution tempSolution = new Solution(solution);
				//doRandomMove(tempSolution);
				doMoveOnConflict(tempSolution);
				delta = solution.calculateCost() - tempSolution.calculateCost();
				double probability = probability();
				double e = Math.exp(-delta/temperature);
				System.out.println("proba=" + probability + "; e=" + e);
				System.out.println(solution.getVector() + " cost=" + solution.calculateCost());
				System.out.println(tempSolution.getVector() + " cost=" + tempSolution.calculateCost());
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
		
		System.out.println("best cost=" + bestSolution.calculateCost() + "(initial cost = " + initalCost + ")");
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
		if (Math.random() <= 0.5) {
			int result = doSwap(tempSolution, moves);
			if (result != OK) {
				doOneMove(tempSolution, moves, result);
			}
		} else {
			doOneMove(tempSolution, moves);
		}
	}
	
	protected void doMoveOnConflict(Solution tempSolution) {
		Moves moves = new Moves(tempSolution);
		int conflict = tempSolution.getConflict();
		
		doOneMove(tempSolution, moves, conflict);

	}
	

	protected void doOneMove(Solution tempSolution, Moves moves) {
		int toMove = (int) ((Math.random() *10 ) % tempSolution.getVector().size());
		moves.move(toMove);
	}
	
	protected void doOneMove(Solution tempSolution, Moves moves, int toMove) {
		int value = nonUsedValue();
		if (value != -1){
			solution.getVector().set(toMove, value);
		}
		else {		
			moves.move(toMove);
		}
	}

	protected int doSwap(Solution tempSolution, Moves moves) {
		int first = -1;
		int second = -1;
		while (first == second) {
			first = (int) ((Math.random() *10 ) % tempSolution.getVector().size());
			second = (int) ((Math.random() *10 ) % tempSolution.getVector().size());
		}
		
		if (tempSolution.getVector().get(first) == tempSolution.getVector().get(second)) {
			return first;
		} else {
			moves.swap(first, second);
			return OK;
		}
	}
	
	protected int doSwap(Solution tempSolution, Moves moves, int first) {
		int second = -1;
		do {
			second = tempSolution.getConflict(first);
		} while (second == first && tempSolution.areInConflict(first, second));
		if (second != -1) {
			moves.swap(first, second);
			return OK;
		} else {
			return -1;
		}
	}
}
