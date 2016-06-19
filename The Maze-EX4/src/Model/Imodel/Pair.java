package Model.Imodel;

import java.io.Serializable;
/**
 * 
 * @author Michael Kratik
 * Pairing the Maze3D with the Solution .
 *
 * @param <X> - Maze3D
 * @param <Y> - Solution
 */
public class Pair <X,Y> implements Serializable {
	public X maze;
	public Y sol;
	public Pair(X maze, Y sol){
		this.maze= maze;
		this.sol=sol;
	}
}
