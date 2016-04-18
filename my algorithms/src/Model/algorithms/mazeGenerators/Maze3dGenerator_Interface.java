package Model.algorithms.mazeGenerators;
/**
 * Interface define two method for maze 3D Generation
 * @author Michael Kratik
 * @version 1.0
 *
 */
public interface Maze3dGenerator_Interface {
/**
 * measure the running time of the generation algorithm
 * @param cols
 * @param raws
 * @param floor
 * @return String - time from starting the generation to ending it.
 */
	public String measureAlgorithmTime(int cols, int raws, int floor);
	/**
	 *  generate a 3D Maze
	 * @param cols
	 * @param raws
	 * @param floor
	 * @return Maze3D
	 */
	public Maze3d generate(int cols, int raws, int floor);
	
}
