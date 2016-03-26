package algorithms.mazeGenerators;


public abstract class Maze3dGenerator implements Maze3dGenerator_Interface {

	
	@Override
	public abstract Maze3d generate(int cols , int raws , int floor);

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
