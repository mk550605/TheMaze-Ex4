package Presenter;

import com.thoughtworks.xstream.annotations.XStreamAlias;

public class Properties implements PropertiesInterface {
	@XStreamAlias("numOfcols-In-Maze")
	private  int numOfCols ;
	
	@XStreamAlias("numOfRows-In-Maze")
	private  int numOfRows ;
	
	@XStreamAlias("numOfFloors-In-Maze")
	private   int numOfFloors ;
	
	@XStreamAlias("numOfThreads")
	private   int numOfThreads ;
	
	@XStreamAlias("AlgorithmForMazeGeneration")
	private   String AlgorithmForMazeGeneration;
	
	@XStreamAlias("AlgorithmForMazeSolution")
	private   String AlgorithmForMazeSolution ;
	
	@XStreamAlias("straightMoveScore")
	private int straightMoveScore;
	// UI settings
	@XStreamAlias("up")
	private String up;
	
	@XStreamAlias("down")
	private String down;
	
	@XStreamAlias("left")
	private String left;
	
	@XStreamAlias("right")
	private String right;
	
	@XStreamAlias("forward")
	private String forward;
	
	@XStreamAlias("backwards")
	private String backwards;
	
	/**
	 * Default CTOR
	 */
	public Properties() {
	}
	
	/**
	 * @param numOfCols
	 * @param numOfRows
	 * @param numOfFloors
	 * @param numOfThreads
	 * @param algorithmForMazeGeneration
	 * @param algorithmForMazeSolution
	 * @param straightMoveScore
	 * @param up
	 * @param down
	 * @param left
	 * @param right
	 * @param forward
	 * @param backwards
	 */
	public Properties(int numOfCols, int numOfRows, int numOfFloors, int numOfThreads,
			String algorithmForMazeGeneration, String algorithmForMazeSolution, int straightMoveScore, String up,
			String down, String left, String right, String forward, String backwards) {
		super();
		this.numOfCols = numOfCols;
		this.numOfRows = numOfRows;
		this.numOfFloors = numOfFloors;
		this.numOfThreads = numOfThreads;
		this.AlgorithmForMazeGeneration = algorithmForMazeGeneration;
		this.AlgorithmForMazeSolution = algorithmForMazeSolution;
		this.straightMoveScore = straightMoveScore;
		this.up = up;
		this.down = down;
		this.left = left;
		this.right = right;
		this.forward = forward;
		this.backwards = backwards;
	}


	@Override
	public String getClassAlias() {
		return "Properties";
	}


	public int getNumOfCols() {
		return numOfCols;
	}


	public int getNumOfRows() {
		return numOfRows;
	}


	public int getNumOfFloors() {
		return numOfFloors;
	}


	public int getNumOfThreads() {
		return numOfThreads;
	}


	public String getAlgorithmForMazeGeneration() {
		return AlgorithmForMazeGeneration;
	}


	public String getAlgorithmForMazeSolution() {
		return AlgorithmForMazeSolution;
	}


	public int getStraightMoveScore() {
		return straightMoveScore;
	}


	public String getUp() {
		return up;
	}


	public String getDown() {
		return down;
	}


	public String getLeft() {
		return left;
	}


	public String getRight() {
		return right;
	}


	public String getForward() {
		return forward;
	}


	public String getBackwards() {
		return backwards;
	}
	
}
