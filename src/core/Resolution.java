package core;

public class Resolution {
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
		int temperature = 1;
		int iteration = 0;
		int maxIteration = 2000;
		do {
				Solution tempSolution = new Solution(solution);
				doRandomMove(tempSolution);
				delta = solution.calculateCost() - tempSolution.calculateCost();
				if (delta < 0 || (probabily() < Math.exp(-delta/temperature))){
					solution = tempSolution;
				}
				iteration++;
				temperature *= 0.99;
		}while (solution.calculateCost() > 0 || iteration >= maxIteration);
		
		return solution;
	}

	private double probabily() {
		return Math.random();
	}

	private void doRandomMove(Solution tempSolution) {
		Moves moves = new Moves(tempSolution);
		int first = -1;
		int second = -1;
		while (first == second){
			first = (int) ((Math.random() *10 ) % tempSolution.getVector().size());
			second = (int) ((Math.random() *10 ) % tempSolution.getVector().size());
		}
		
		moves.swap(first, second);
		
	}
	

}
