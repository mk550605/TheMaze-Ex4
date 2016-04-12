package algorithms.demo;

import algorithms.Search.Action;
import algorithms.mazeGenerators.Direction;
/**
 * 
 * @author Michael Kratik
 * @category MazeAdapter
 * this Class Extends Action Class.
 * this class describe the connection between the Action of the solver and our Problem the Maze.
 * the class have two parameters 
 * Move -Direction Enum for easy describe the Actions in our leng.
 * Move Cost -  with Final cost of =1 .
 */
public class MazeAction extends Action{
	private Direction move;
	private static final double mazeMovmentCost =1;
	/**
	 * Constructor of the Class
	 * use the parent constructor 
	 * transfer the move description and the Final cost of the move to Super.
	 * @param move
	 * 
	 */
	public MazeAction(Direction move) {
		super(move.toString(), mazeMovmentCost);
		
	}

}
