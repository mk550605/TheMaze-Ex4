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
	
	@XStreamAlias("AlgorithmForMazeSolution")
	private   String AlgorithmForMazeSolution ;
	
	@XStreamAlias("straightMoveScore")
	private int straightMoveScore;
	
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
	 * @param algorithmForMazeSolution
	 * @param straightMoveScore
	 */
	public Properties(int numOfCols, int numOfRows, int numOfFloors, int numOfThreads,
			String algorithmForMazeSolution, int straightMoveScore) {
		this.numOfCols = numOfCols;
		this.numOfRows = numOfRows;
		this.numOfFloors = numOfFloors;
		this.numOfThreads = numOfThreads;
		this.AlgorithmForMazeSolution = algorithmForMazeSolution;
		this.straightMoveScore = straightMoveScore;

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

	public String getAlgorithmForMazeSolution() {
		return AlgorithmForMazeSolution;
	}

	public int getStraightMoveScore() {
		return straightMoveScore;
	}

	@Override
	public String getClassAlias() {
		return "Properties";
	}



	
}
