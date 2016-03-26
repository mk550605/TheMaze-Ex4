package algorithms.mazeGenerators;

import java.util.ArrayList;

public class Maze3d {
	private int cols;
	private int rows;
	private int floor;
	public int [][][] maze;
	public static final int WALL = 1;
	public static final int FREE = 0;
	private Position startPosition;
	private Position endPosition;
	
	public int getCols() {
		return cols;
	}

	public int getRows() {
		return rows;
	}

	public int getFloor() {
		return floor;
	}	
	
	
	
	public void setFree(int cols, int rows, int floor){
		maze[cols][rows][floor] = FREE;
	}
public Maze3d(int cols, int rows, int floors) {
	this.cols=cols;
	this.rows=rows;
	this.floor=floors;
	this.maze = new int[cols][rows][floors];
}

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


public void setWall(int cols, int rows , int floor) {
	maze[cols][rows][floor] = WALL;
}



public int getValue(int cols, int rows , int floor) {
	return maze[cols][rows][floor];
}

public Position getStartPosition() {
	return startPosition;
}

public void setStartPosition(Position startPosition) {	
	this.startPosition = startPosition;
}

public Position getGoalPosition() {
	return endPosition;
}

public void setGoalPosition(Position endPosition) {
	this.endPosition = endPosition;
}

public int[][] getCrossSectionByX(int i) throws Exception{
	int[][] crossMaze = new int[rows][floor];
	for (int j=0 ; j < floor ; j++){
		for (int k=0 ; k < rows;k++){
			crossMaze[k][j] = maze[i][k][j];
		}
	}
	return crossMaze;
}

public int[][] getCrossSectionByY(int i) throws Exception{
	int[][] crossMaze = new int[cols][floor];
	for (int j=0 ; j < floor ; j++){
		for (int k=0 ; k < cols;k++){
			crossMaze[k][j] = maze[k][i][j];
		}
	}
	return crossMaze;
}

public int[][] getCrossSectionByZ(int i) throws Exception{
	int[][] crossMaze = new int[cols][rows];
	for (int j=0 ; j < rows ; j++){
		for (int k=0 ; k < cols;k++){
			crossMaze[k][j] = maze[k][j][i];
		}
	}
	return crossMaze;
}

public String[] getPossibleMoves(Position p) {
	ArrayList<Direction> directions = new ArrayList<Direction>();
	if (p.x > 0 && p.x <cols && this.getValue(p.x-1, p.y, p.z)==FREE)
			directions.add(Direction.LEFT);
	if (p.x >= 0 && p.x <cols - 2 && this.getValue(p.x+1, p.y, p.z)==FREE)
			directions.add(Direction.RIGHT);
	if (p.y > 0 && p.y <rows && this.getValue(p.x, p.y-1, p.z)==FREE )
		directions.add(Direction.FORWARD);
	if (p.y >= 0 && p.y <rows - 2 && this.getValue(p.x, p.y+1, p.z)==FREE)
		directions.add(Direction.REVERSE);
	if (p.z > 0 && p.z <floor && this.getValue(p.x, p.y, p.z-1)==FREE )
		directions.add(Direction.DOWN);
	if (p.z >= 0 && p.z <floor - 2 && this.getValue(p.x, p.y, p.z+1)==FREE)
		directions.add(Direction.UP);
	ArrayList<String> str = new ArrayList<String>();
	for (Direction dir : directions) {
		str.add(dir.toString());
	}
	return str.toArray(new String[str.size()]);
}







}
