package Model.algorithms.Search;


import java.util.HashMap;
import java.util.HashSet;

/**
 * 
 * Searcher algorithm via Depth-first search
 * @author Michael Kratik
 * @version 1.0
 */
public class DFS extends CommonSearcher{
	
	private HashSet<State> visitedStates = new HashSet<State>() ;
	private Solution sol;

	/**
	 * This function finds a solution to a searchable problem
	 * with DFS recursive 
	 * @param s the problem
	 * @return solution
	 */
	public Solution search(Searchable s) {
		dfs(s, s.getStartState());
		return sol;
	}
	/**
	 * DFS recursive 
	 * @param s - the searchble problem
	 * @param state - the current State of the problem
	 */
	private void dfs(Searchable s, State state) {
		if (state.equals(s.getGoalState())){
			this.sol = backtrace(state);
			return ;
		}
		stepCounter++;
		visitedStates.add(state);
		
		HashMap<Action,State> actions = s.getAllPossibleStates(state);
		for(State neighbor: actions.values())
		{
			if (!visitedStates.contains(neighbor)) {
				neighbor.setCameFrom(state);
				dfs(s, neighbor);
					
			}
		}
		return;
	}

	
}

