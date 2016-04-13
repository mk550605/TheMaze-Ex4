package algorithms.mazeGenerators;

import java.util.ArrayList;
import java.util.Arrays;
/**
 *
 * this Maze 3d class explain how to build a maze in 3 Dimantions.
 * @author Michael Kratik
 * @version 1.0
 * 
 */
public class Maze3d {
	
	
	private int cols;
	private int rows;
	private int floor;
	public int [][][] maze;
	/**
	 * The state of Wall in the maze is binary 1
	 * and the state of Free to walk cell is binary 0.
	*/
	public static final int WALL = 1;
	public static final int FREE = 0;
	private Position startPosition;
	private Position endPosition;
	
	/**
	 * Getter the number of cols in the maze.
	 * @return  int - cols number
	 */
	public int getCols() {
		return cols;
	}
	/**
	 * Getter the number of rows in the maze.
	 * @return  int - rows number
	 */
	public int getRows() {
		return rows;
	}
	/**
	 * Getter the number of floors in the maze.
	 * @return  int - floors number
	 */
	public int getFloor() {
		return floor;
	}	
	
	
	/**
	 * setting the cell free to go
	 *  
	 */
	public void setFree(int cols, int rows, int floor){
		maze[cols][rows][floor] = FREE;
	}
	
	/**
	 * maze 3D constructor getting the number of cols, rows and floors
	 * and initialize the the maze array 
	 */
	public Maze3d(int cols, int rows, int floors) {
	this.cols=cols;
	this.rows=rows;
	this.floor=floors;
	this.maze = new int[cols][rows][floors];
}
	/**
	 * printing all the maze by floors
	 */
@Override
public String toString() {
	StringBuilder sb = new StringBuilder();
	for (int k =0 ; k < floor; k++){
		sb.append("floor" + k + "\n\n");
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				sb.append(maze[j][i][k] + " ");
			}
			sb.append("\n");
		}
		sb.append("\n\n");
	}
		return sb.toString();
}

/**
 *Set the cell as a Wall
 */
public void setWall(int cols, int rows , int floor) {
	maze[cols][rows][floor] = WALL;
}


/**
 * return the value of the cell you ask for
 * @return int- value 
 */
public int getValue(int cols, int rows , int floor) {
	return maze[cols][rows][floor];
}

/**
 * return the start position of the maze.
 * @return Position - the start position
 */
public Position getStartPosition() {
	return startPosition;
}

/**
 * set the start position of the  maze
 */
public void setStartPosition(Position startPosition) {	
	this.startPosition = startPosition;
}
/**
 * return the Goal position of the maze.
 * @return Position - the Goal position
 */
public Position getGoalPosition() {
	return endPosition;
}

/**
 * set the Goal position of the  maze
 */
public void setGoalPosition(Position endPosition) {
	this.endPosition = endPosition;
}
/**
 * the Function take the asked for X section and return a two dimension array
 * its look like 2D maze.
 */
public int[][] getCrossSectionByX(int i) throws Exception{
	int[][] crossMaze = new int[rows][floor];
	for (int j=0 ; j < floor ; j++){
		for (int k=0 ; k < rows;k++){
			crossMaze[k][j] = maze[i][k][j];
		}
	}
	return crossMaze;
}
/**
 * the Function take the asked for y section and return a two dimension array
 * its look like 2D maze.
 */
public int[][] getCrossSectionByY(int i) throws Exception{
	int[][] crossMaze = new int[cols][floor];
	for (int j=0 ; j < floor ; j++){
		for (int k=0 ; k < cols;k++){
			crossMaze[k][j] = maze[k][i][j];
		}
	}
	return crossMaze;
}
/**
 * the Function take the asked for z section and return a two dimension array
 * its look like 2D maze.
 */
public int[][] getCrossSectionByZ(int i) throws Exception{
	int[][] crossMaze = new int[cols][rows];
	for (int j=0 ; j < rows ; j++){
		for (int k=0 ; k < cols;k++){
			crossMaze[k][j] = maze[k][j][i];
		}
	}
	return crossMaze;
}

/**
 * the function get a point and check all the possible moves on the maze from this point.
 * the function return a String array of all possible Directions .
 */ 
public String[] getPossibleMoves(Position p) {
	
	Direction[] directions = getPossibleMovesDirectionarray(p);
	ArrayList<String> str = new ArrayList<String>();
	for (Direction dir : directions) {
		str.add(dir.toString());
	}
	return str.toArray(new String[str.size()]);
}

/**
 * the function get a point and check all the possible moves on the maze from this point.
 * the function return a Direction array of all possible Directions .
 * @param p - Current position
 * @return Direction[]
 */
public Direction[] getPossibleMovesDirectionarray(Position p) {

	ArrayList<Direction> directions = new ArrayList<Direction>();
	if (p.x > 0 && p.x <cols && this.getValue(p.x-1, p.y, p.z)==FREE)
			directions.add(Direction.LEFT);
	if (p.x >= 0 && p.x <cols - 1 && this.getValue(p.x+1, p.y, p.z)==FREE)
			directions.add(Direction.RIGHT);
	if (p.y > 0 && p.y <rows && this.getValue(p.x, p.y-1, p.z)==FREE )
		directions.add(Direction.FORWARD);
	if (p.y >= 0 && p.y <rows - 1 && this.getValue(p.x, p.y+1, p.z)==FREE)
		directions.add(Direction.REVERSE);
	if (p.z > 0 && p.z <floor && this.getValue(p.x, p.y, p.z-1)==FREE )
		directions.add(Direction.DOWN);
	if (p.z >= 0 && p.z <floor - 1 && this.getValue(p.x, p.y, p.z+1)==FREE)
		directions.add(Direction.UP);
	Direction[] arr = new Direction[directions.size()];
	directions.toArray(arr);
	return arr;
}

public byte[] toByteArray(){
	ArrayList<Byte> byteArrayList = new ArrayList<Byte>();
	byteArrayList.add((byte)cols);
	byteArrayList.add((byte)rows);
	byteArrayList.add((byte)floor);
	byteArrayList.add((byte)startPosition.x);
	byteArrayList.add((byte)startPosition.y);
	byteArrayList.add((byte)startPosition.z);
	byteArrayList.add((byte)endPosition.x);
	byteArrayList.add((byte)endPosition.y);
	byteArrayList.add((byte)endPosition.z);
	for (int k =0 ; k < floor; k++){
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				byteArrayList.add((byte) maze[j][i][k]);
			}
		}
	}
	byte[] byteArray = new byte[byteArrayList.size()];
	for (int i=0 ;i<byteArrayList.size();i++ ){
		byteArray[i]= byteArrayList.get(i);
	}
	return byteArray;
}

	// to be fill 
	public Maze3d(byte[] b) {
		int counter ;
		this.cols = (int)b[0];
		this.rows = (int)b[1];
		this.floor =  (int)b[2];
		this.maze = new int[cols][rows][floor];
		Position sPos = new Position((int)b[3], (int)b[4], (int)b[5]);
		this.setStartPosition(sPos);
		Position gPos = new Position((int)b[6], (int)b[7], (int)b[8]);
		this.setGoalPosition(gPos);
		for (counter = 9; counter < b.length ; counter++){
			for (int k =0 ; k < floor; k++){
				for (int i = 0; i < rows; i++) {
					for (int j = 0; j < cols; j++) {
						this.maze[j][i][k] = b[counter];
						counter++;
					}
				}
			}
		}

	}
	
	@Override
	public boolean equals(Object obj) {
		if (getClass() != obj.getClass())
			return false;
		Maze3d other = (Maze3d) obj;
		if (cols != other.cols)
			return false;
		if (rows != other.rows)
			return false;
		if (floor != other.floor)
			return false;
		if (!endPosition.equals(other.endPosition))
			return false;
		if (!startPosition.equals(other.startPosition))
			return false;
		for (int k =0 ; k < floor; k++){
			for (int i = 0; i < rows; i++) {
				for (int j = 0; j < cols; j++) {
					if (maze[j][i][k] != other.maze[j][i][k])
						return false;
				}
			}
		}
		return true;
	}


}






