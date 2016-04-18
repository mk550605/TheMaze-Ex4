package Model.algorithms.mazeGenerators;

/**
 * abstract class that implements the Maze3dGenerator_Interface 
 * the only function define in it is measureAlgorithmTime
 * @author Michael Kratik
 *@version 1.0
 */
public abstract class Maze3dGenerator implements Maze3dGenerator_Interface {

	
	@Override
	public abstract Maze3d generate(int cols , int raws , int floor);

	/**
	 * the function check the time that the maze generation algorithm is taken for 
	 * generating the maze.   
	 */
	@Override
	public String measureAlgorithmTime(int cols , int raws , int floor) {
	
		// TODO Auto-generated method stub
		long startTime = System.currentTimeMillis();
		generate(cols,raws,floor);
		long endTime = System.currentTimeMillis();
		long duration = endTime - startTime;
		return String.valueOf(duration);
	}

}
