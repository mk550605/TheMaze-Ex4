package algorithms.Search;


import java.util.HashMap;
import java.util.Map.Entry;
/**
 * Searcher algorithm via Breadth first search
 * @author Michael Kratik
 * @version 1.0
 */
public class BreadthFS extends CommonSearcher {
	/**
	 * This function finds a solution to a searchable problem
	 * with Breadth First Search 
	 * @param s the problem
	 * @return solution
	 */
	@Override
	public Solution search(Searchable s) {
		openList.add(s.getStartState());
		
		while (!openList.isEmpty()) {
			State state = openList.poll();
			stepCounter++;
			closedList.add(state);
			
			if (state.equals(s.getGoalState())) 
				return backtrace(state);
			
			HashMap<Action , State> successors = s.getAllPossibleStates(state);
			for (Entry<Action, State> entry: successors.entrySet()) {
				//Action action = entry.getKey();
				State successor = entry.getValue();
				
				if (!openList.contains(successor) && !closedList.contains(successor)){
					successor.setCameFrom(state);
					successor.setCost(state.getCost() + 1); 
					openList.add(successor);
				}
				else
				{
					if (successor.getCost() > state.getCost()+1){
						successor.setCameFrom(state);
						successor.setCost(state.getCost()+1);
						if (!openList.contains(successor)){
							openList.add(successor);
						}
						else
						{
							openList.remove(successor); 
							openList.add(successor);
						}
					}
						
				}
					
			}
		}
		return null;  // Never Used
	}


}
