package core;
import java.util.ArrayList;
import java.util.List;


public class Solution {
	
	public static final int DEFAULT_SIZE = 8;
	private List<Integer> vector;
	
	public Solution (){
		vector = new ArrayList<>(DEFAULT_SIZE);
	}
	
	public Solution(int size){
		vector = new ArrayList<>(size);
	}

	public List<Integer> getVector() {
		return vector;
	}

	public void setVector(List<Integer> vector) {
		this.vector = vector;
	}
	
	public void init(){
		int size = vector.size();
		int col = 0;
		int ligne = 0;
		for (int i = 0; i < size; i ++) {
			vector.add(col, ligne);
			col = (col + 2) % size;
			ligne++;
		}
	}
	
	public int calculateCost(){
		int cost = 0;
		for(int i = 0; i < vector.size() ; i++){
			
		}
		
		return cost;
	}

}
