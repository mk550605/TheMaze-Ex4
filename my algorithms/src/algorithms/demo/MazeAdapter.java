package algorithms.demo;

import java.util.HashMap;

import algorithms.Search.Action;
import algorithms.Search.Searchable;
import algorithms.Search.State;
import algorithms.mazeGenerators.Direction;
import algorithms.mazeGenerators.Maze3d;
import algorithms.mazeGenerators.Position;
/**
 * 
 * @author Michael Kratik
 * @category Maze Adapter
 * the class responsible for the adaption from searchble to Maze Search problem
 * the class implement Searchable interface and holding a Maze3d object.
 *
 */
public class MazeAdapter implements Searchable {
	private Maze3d themaze;
	private static final double MAZEMOVE=1; 
/**
 * class constructor for MazeAdapter
 * @param theMaze
 */
	public MazeAdapter(Maze3d theMaze) {
		this.themaze = theMaze;
		// TODO Auto-generated constructor stub
	}
	/**
	 * Getter for StartState of the maze problem
	 * @return State
	 */
	@Override
	public State getStartState() {
		mazeState startState = new mazeState(themaze.getStartPosition());
		return startState;
	}

	/**
	 * Getter for GoalState of the maze problem
	 * @return State
	 */
	@Override
	public State getGoalState() {
		mazeState GoalState = new mazeState(themaze.getGoalPosition());
		return GoalState;
	}
	/**
	 * Check all the possible States that we can move to from the state given in the param.
	 * @param currState
	 * @return HashMap
	 */
	@Override
	public HashMap<Action, State> getAllPossibleStates(State currState) {
		mazeState mazeState = (mazeState)currState;
		Position curPos = mazeState.getCurrplayerposition();
		Direction[] direction = themaze.getPossibleMovesDirectionarray(curPos);
		HashMap<Action, State> actions = new HashMap<Action,State>();
		for (Direction d: direction){
			Action action = new Action(d.toString(), MAZEMOVE);
			mazeState newsState = new mazeState(getNextPosition(curPos, d));
			newsState.setCameFrom(new mazeState(curPos));
			actions.put(action, newsState);
		}
		return actions;
		
	}
	/**
	 * provide the next position on the maze , depend on the current position and the direction provided.
	 * @param currPos
	 * @param dir
	 * @return Position
	 */
	private Position getNextPosition(Position currPos, Direction dir){
		switch (dir) {
		case LEFT:
			return new Position(currPos.x - 1, currPos.y, currPos.z);
		case RIGHT:
			return new Position(currPos.x + 1, currPos.y, currPos.z);
		case UP:
			return new Position(currPos.x, currPos.y, currPos.z+1);
		case DOWN:
			return new Position(currPos.x, currPos.y, currPos.z-1);
		case FORWARD:
			return new Position(currPos.x, currPos.y-1, currPos.z);
		case REVERSE:
			return new Position(currPos.x, currPos.y+1, currPos.z);
		default:
			return null;
		}
	}

}
