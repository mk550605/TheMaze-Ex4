package algorithms.demo;

import algorithms.Search.State;
import algorithms.mazeGenerators.Position;
/**
 * the Class Provide the connection between the Global State to the States in the State in the Maze Problem.
 * have one Object of Position
 * 
 * @author Michael Kratik
 *
 */
public class mazeState extends State {
	
	private Position currplayerposition;

	/**
	 * Getter of the current Position of the player in the maze. 
	 * @return Position
	 */
	public Position getCurrplayerposition() {
		return currplayerposition;
	}
	/**
	 * Setter for the current Position of the player in the maze. 
	 * 
	 */
	public void setCurrplayerposition(Position currplayerposition) {
		this.currplayerposition = currplayerposition;
	}
	/**
	 * constructor for mazeState take the position and translate it to State format.
	 * @param pos
	 */
	public mazeState(Position pos) {
		this.currplayerposition = pos;
		this.setDescription(pos.toString());
	}
	
	
	
	
}

