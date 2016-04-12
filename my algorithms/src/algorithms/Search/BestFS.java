package algorithms.Search;
import java.util.HashMap;
import java.util.Map.Entry;
/**
 * 
 * Searcher algorithm via Best first search
 * @author Michael Kratik
 * @version 1.0
 */
public class BestFS extends CommonSearcher {
	/**
	 * This function finds a solution to a searchable problem
	 * with Best First Search 
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
				Action action = entry.getKey();
				State successor = entry.getValue();
				
				if (!openList.contains(successor) && !closedList.contains(successor)){
					successor.setCameFrom(state);
					successor.setCost(state.getCost() + action.getCost());
					
					openList.add(successor);
				}
				else
				{
					if (successor.getCost() > state.getCost()+action.getCost()){
						successor.setCameFrom(state);
						successor.setCost(state.getCost()+action.getCost());
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
