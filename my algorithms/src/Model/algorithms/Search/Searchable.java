package Model.algorithms.Search;


import java.util.HashMap;
/**
 * Interface describe the Searchable functions
 * @author Michael Kratik
 * @version 1.0
 *
 */
public interface Searchable {
	/**
	 * define the getStartState function of the Searchable Problem
	 * @return State of start 
	 */
	State getStartState();
	/**
	 * define the getGoalState function of the Searchable Problem
	 * @return State of Goal 
	 */
	State getGoalState();
	/**
	 * define the getAllPossibleStates function of the Searchable Problem
	 * @return HashMap <Action,State> of all possible state from the current state
	 */
	HashMap<Action,State> getAllPossibleStates(State currState);
}
