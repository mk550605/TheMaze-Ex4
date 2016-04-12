package algorithms.Search;

import java.util.ArrayList;
/**
 * Define a Solution of a Searchble problem
 * @author Michael Kratik
 * @version 1.0
 *
 */
public class Solution {
	private ArrayList<State> states;
	/**
	 * Getter of ArrayList States
	 * @return ArratList of States
	 */
	public ArrayList<State> getStates(){
		return states;
	}
	/**
	 * Setter of ArrayList States
	 */
	public void setStates(ArrayList<State> states){
		this.states= states;
}
	/**
	 * Getter of Size of States
	 * @return int Size
	 */
	public int getSize(){
		return states.size();
	}
	/**
	 * Override ToString 
	 * @return String
	 */
	@Override
	public String toString() {
		String str = new String();
		for (State state:states){
			str += state.getDescription() + " ";
				}
		return str;
	}
	
}