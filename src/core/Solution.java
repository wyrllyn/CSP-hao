package core;
import java.util.ArrayList;
import java.util.List;


public class Solution {
	
	public static final int DEFAULT_SIZE = 8;
	private List<Integer> vector;
	private int size;
	
	public Solution (){
		this(DEFAULT_SIZE);
	}
	
	public Solution(int size){
		vector = new ArrayList<>(size);
		this.size = size;
		for (int i = 0; i < size; i++) {
			vector.add(-1);
		}
	}

	public Solution(Solution solution) {
		this.vector = new ArrayList<>(solution.getVector());
	}

	public List<Integer> getVector() {
		return vector;
	}

	public void setVector(List<Integer> vector) {
		this.vector = vector;
	}
	
	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public void init(){
		int col = 0;
		int ligne = 0;
		for (int i = 0; i < size; i ++) {
			if (vector.get(col) != -1 && col < (size - 1)) {
				col++;
			}
			//System.out.println(col + "; " + ligne);
			vector.set(col, ligne);
			col = (col + 2) % size;
			ligne++;
		}
	}
	
	public int calculateCost(){
		int cost = 0;
		for(int i = 0; i < vector.size() ; i++){
			for (int j = i + 1 ; j < vector.size() ; j++){
				cost += diagConflict(j-i, vector.get(i), vector.get(j)) ;
				cost += lineConflict(vector.get(i), vector.get(j));
			}
		}
		
		return cost;
	}

	protected int lineConflict(int iValue, int jValue) {
		if (iValue == jValue){
			return 1;
		}
		return 0;
	}

	protected int diagConflict(int difference, int iValue, int jValue) {
		if (difference == Math.abs(iValue - jValue)){
			return 1;
		}
		return 0;
	}

}
