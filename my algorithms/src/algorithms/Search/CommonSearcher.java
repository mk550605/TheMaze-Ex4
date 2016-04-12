package algorithms.Search;
import java.util.ArrayList;
import java.util.PriorityQueue;


/**
 * Abstract Class for Searcher problems 
 * @author Michael Kratik
 * @version 1.0
 */
public abstract class CommonSearcher implements Searcher {
	
	protected PriorityQueue<State> openList;
	protected PriorityQueue<State> closedList;
	protected int stepCounter = 0;
	/**
	 * Getter for Step Counter
	 * @return int- the Counter
	 */
	public int getStepCounter() {
		return stepCounter;
	}
	/**
	 * Setter for Step Counter
	 * 
	 */
	public void setStepCounter(int stepCounter) {
		this.stepCounter = stepCounter;
	}
	/**
	 * CommonSearcher contractor hold two PriorityQueue
	 * openList and closedList
	 */
	public CommonSearcher() {
		openList = new PriorityQueue<State>();
		closedList = new PriorityQueue<State>();
	}
	/**
	 * BackTrace the Solution from CameFrom cell of State
	 * @param state - current State
	 * @return Solution
	 */
	protected Solution backtrace(State state) {
		State s = state;
		ArrayList<State> states = new ArrayList<State>();
		while (s != null) {
			states.add(0, s);	
			s = s.getCameFrom();
		}
		Solution solution = new Solution();
		solution.setStates(states);
		return solution;
	}
	
}
