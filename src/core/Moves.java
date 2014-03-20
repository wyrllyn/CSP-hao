package core;

import java.util.List;;

public class Moves {
	private Solution solution;
	
	public Moves(Solution solution){
		this.solution = solution;
	}

	public Solution getSolution() {
		return solution;
	}

	public void setSolution(Solution solution) {
		this.solution = solution;
	}
	
	public Solution swap(int first, int second){
		
		List<Integer> tempVector = solution.getVector();
		int valueOfFirst = tempVector.get(first);
		int valueOfSecond = tempVector.get(second);
		
		tempVector.set(first, valueOfSecond);
		tempVector.set(second, valueOfFirst);
		
		return solution;
	}
	
	public Solution move (int toMove){
		
		List<Integer> tempVector = solution.getVector();
		int value = tempVector.get(toMove);
		int newValue = value;
		
		while (newValue == value) {
			newValue = (int) ((Math.random() * 10) % tempVector.size());
		}
		
		tempVector.set(toMove, newValue);
		
		return solution;
	}
	
	
	
}
