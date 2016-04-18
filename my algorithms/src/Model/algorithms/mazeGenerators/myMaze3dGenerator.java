package Model.algorithms.mazeGenerators;

import java.util.ArrayList;

/**
 * myMaze3dGenerator extend the Maze3dGenerator class
 * create a 3Dmaze via DFS algorithm.
 */
public class myMaze3dGenerator extends Maze3dGenerator {

	private Maze3d maze3d;
	//private Position startPosition;
	//private Position endposition;
	
	/**
	 * choose a random position only in odd position in all 3 factors
	 * @return Position
	 */
	private Position chooseRandomPosition(){
		// choose an even cloumn
		int x = Utils.random.nextInt(maze3d.getCols());
		int y = Utils.random.nextInt(maze3d.getRows());
		int z = Utils.random.nextInt(maze3d.getFloor());
		while (x%2 ==1)
			x = Utils.random.nextInt(maze3d.getCols());
		while (y%2 == 1)
			y = Utils.random.nextInt(maze3d.getRows());
		while (z%2 ==1)
			z = Utils.random.nextInt(maze3d.getFloor());
		return new Position(x, y, z);
	}
/**
 * Generate a 3Dmaze via DFS 
 */
	public Maze3d generate (int cols, int raws, int floors){
		maze3d = new Maze3d(cols, raws, floors);
		for(int i=0 ; i < maze3d.getFloor()  ; i++){
			for (int j=0 ; j < maze3d.getRows()  ; j++){
				for(int k=0 ; k < maze3d.getCols() ; k++){
						maze3d.setWall(k, j, i);
				}
			}
		} 
		Position startPosition =chooseRandomPosition();
		maze3d.setStartPosition(startPosition);
		maze3d.setFree(startPosition.x,startPosition.y,startPosition.z);
	// to delete
		//	System.out.println(maze3d.toString());
		DFS(startPosition);
		//choose end Position
		Position endposition = chooseRandomPosition();
		int Temp = maze3d.getValue(endposition.x, endposition.y, endposition.z);
		while (Temp != maze3d.FREE || endposition.equals(startPosition)){
			 endposition = chooseRandomPosition();
			 Temp = maze3d.getValue(endposition.x, endposition.y, endposition.z);
		}
		//maze3d.setFree(endposition.x, endposition.y, endposition.z);
		maze3d.setGoalPosition(endposition);
		return maze3d;
	}
	
	/**
	 * DFS Maze generator Algorithm
	 * @param currPos
	 */
	private void DFS(Position currPos){
		//Find all Possible Directions
		ArrayList<Direction> dirs = getPossibleDirections(currPos);
		Position newPos;
		if (dirs.size()==0)
			return;
		// to delete
		//System.out.println(currPos);
		// to delete 
		//System.out.println(maze3d.toString());
		
		for(int i =0 ; i< dirs.size(); i++) {
			int dirx = Utils.random.nextInt(dirs.size());
			Direction dir = dirs.get(dirx);
			dirs.remove(dirx);
		//	System.out.println(dir);
			switch(dir){
			case RIGHT:
				maze3d.setFree(currPos.x+1,currPos.y,currPos.z);
				maze3d.setFree(currPos.x+2,currPos.y,currPos.z);
				newPos = new Position(currPos.x + 2, currPos.y, currPos.z);
				DFS(newPos);
				break;
			case LEFT:
				maze3d.setFree(currPos.x-1,currPos.y,currPos.z);
				maze3d.setFree(currPos.x-2,currPos.y,currPos.z);
				newPos = new Position(currPos.x - 2, currPos.y, currPos.z);
				DFS(newPos);		
				break;
			case REVERSE:
				maze3d.setFree(currPos.x,currPos.y+1,currPos.z);
				maze3d.setFree(currPos.x,currPos.y+2,currPos.z);
				newPos = new Position(currPos.x , currPos.y+2, currPos.z);
				DFS(newPos);		
				break;
			case FORWARD:
				maze3d.setFree(currPos.x,currPos.y-1,currPos.z);
				maze3d.setFree(currPos.x,currPos.y-2,currPos.z);
				newPos = new Position(currPos.x , currPos.y-2, currPos.z);
				DFS(newPos);		
				break;
			case UP:
				maze3d.setFree(currPos.x,currPos.y,currPos.z+1);
				maze3d.setFree(currPos.x,currPos.y,currPos.z+2);
				newPos = new Position(currPos.x , currPos.y, currPos.z+2);
				DFS(newPos);		
				break;
			case DOWN:
				maze3d.setFree(currPos.x,currPos.y,currPos.z-1);
				maze3d.setFree(currPos.x,currPos.y,currPos.z-2);
				newPos = new Position(currPos.x , currPos.y, currPos.z-2);
				DFS(newPos);		
				break;
			default:
				break;
			}
		}
	}
	/**
	 * get all possible Directions from the current position
	 * @param currPos
	 * @return ArrayList of Directions 
	 */
	private ArrayList<Direction> getPossibleDirections(Position currPos){
		ArrayList<Direction> directions = new ArrayList<Direction>();
		if (currPos.x +2 < maze3d.getCols() && maze3d.getValue(currPos.x+2, currPos.y, currPos.z)==Maze3d.WALL)
			directions.add(Direction.RIGHT);
		if (currPos.x -2 >= 0 && maze3d.getValue(currPos.x-2, currPos.y, currPos.z)==Maze3d.WALL)
			directions.add(Direction.LEFT);
		if (currPos.y +2 < maze3d.getRows() && maze3d.getValue(currPos.x, currPos.y+2, currPos.z)==Maze3d.WALL)
			directions.add(Direction.REVERSE);
		if (currPos.y -2 >= 0 && maze3d.getValue(currPos.x, currPos.y-2, currPos.z)==Maze3d.WALL)
			directions.add(Direction.FORWARD);
		if (currPos.z +2 < maze3d.getFloor() && maze3d.getValue(currPos.x, currPos.y, currPos.z+2)==Maze3d.WALL)
			directions.add(Direction.UP);
		if (currPos.z -2 >= 0 && maze3d.getValue(currPos.x, currPos.y, currPos.z-2)==Maze3d.WALL)
			directions.add(Direction.DOWN);
		return directions;
	}
	


}
