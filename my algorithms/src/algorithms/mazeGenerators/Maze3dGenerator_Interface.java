package algorithms.mazeGenerators;

public interface Maze3dGenerator_Interface {


	
	public String measureAlgorithmTime(int cols, int raws, int floor);
	public Maze3d generate(int cols, int raws, int floor);
	
}
