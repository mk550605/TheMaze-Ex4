package algorithms.mazeGenerators;


public class run {
private static void testMazeGenerator(Maze3dGenerator mg) throws Exception{
	int cols =9 , raws =9 , floor =3;
// prints the time it takes the algorithm to run

	System.out.println(mg.measureAlgorithmTime(cols, raws, floor));
// generate another 3d maze
Maze3d maze=mg.generate(cols, raws, floor);
// get the maze entrance
Position p=maze.getStartPosition();
// print the position
System.out.println(p); // format "{x,y,z}"
System.out.println(maze.toString());
// get all the possible moves from a position
String[] moves=maze.getPossibleMoves(p);
// print the moves
for(String move : moves)
System.out.println(move);
// prints the maze exit position
System.out.println(maze.getGoalPosition());
try{
// get 2d cross sections of the 3d maze
int[][] maze2dx=maze.getCrossSectionByX(2);
// TODO add code to print the array
int[][] maze2dy=maze.getCrossSectionByY(5);
// TODO add code to print the array
int[][] maze2dz=maze.getCrossSectionByZ(0);
// TODO add code to print the array
// this should throw an exception!
maze.getCrossSectionByX(-1);
} catch (IndexOutOfBoundsException e){
System.out.println("good!");

}
System.out.println( " run Ends" + mg.getClass());
}
public static void main(String[] args) throws Exception {
testMazeGenerator(new SimpaleMaze3D());
testMazeGenerator(new myMaze3dGenerator());
}
}
