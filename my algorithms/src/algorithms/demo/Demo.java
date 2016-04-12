package algorithms.demo;

import java.io.FileOutputStream;
import java.io.OutputStream;

import IO.MyCompressorOutputStream;
import algorithms.Search.BestFS;
import algorithms.Search.BreadthFS;
import algorithms.Search.DFS;
import algorithms.Search.Solution;
import algorithms.mazeGenerators.Maze3d;
import algorithms.mazeGenerators.Maze3dGenerator;
import algorithms.mazeGenerators.SimpaleMaze3D;
import algorithms.mazeGenerators.myMaze3dGenerator;

public class Demo {
	public static void testMazeGenerator(Maze3dGenerator mg) throws Exception{
		int cols =11 , raws =11 , floor =11;
	Maze3d maze=mg.generate(cols, raws, floor);
	
	// get the maze entrance
	System.out.println("maze start pos is : " + maze.getStartPosition()); // format "{x,y,z}"
	System.out.println("maze Goal Pos is : " + maze.getGoalPosition());
	System.out.println();
	System.out.println();
	System.out.println(maze.toString());
	MazeAdapter myadapter = new MazeAdapter(maze);
	BestFS myBestFS = new BestFS();
	Solution sol = myBestFS.search(myadapter);
	System.out.println(" BestFS : " + myBestFS.getStepCounter());
	BreadthFS myBreadthFS = new BreadthFS();
	Solution sol1 = myBreadthFS.search(myadapter);
	System.out.println(" BreathFS : " +myBreadthFS.getStepCounter());
	DFS myDFS = new DFS();
	Solution sol2 = myDFS.search(myadapter);
	System.out.println(" DFS : " +myDFS.getStepCounter());
	
	OutputStream out=new MyCompressorOutputStream(new FileOutputStream("theMaze.maz"));
	out.write(maze.toByteArray());
	out.flush();
	out.close();
	}	



}
