package Model.algorithms.demo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import Model.IO.MyCompressorOutputStream;
import Model.IO.MyDecompressorInputStream;
import Model.algorithms.Search.BestFS;
import Model.algorithms.Search.BreadthFS;
import Model.algorithms.Search.DFS;
import Model.algorithms.Search.Solution;
import Model.algorithms.mazeGenerators.Maze3d;
import Model.algorithms.mazeGenerators.Maze3dGenerator;
import Model.algorithms.mazeGenerators.SimpaleMaze3D;
import Model.algorithms.mazeGenerators.myMaze3dGenerator;

public class Demo {
	/**
	 * Demo for all Project , test the maze creation , MazeAdapter, BFS *2 ,DFS and File Handeling.
	 * @param mg - MazeGenerator 
	 * @throws Exception - i/o
	 */
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
	InputStream in=new MyDecompressorInputStream(new FileInputStream("theMaze.maz"));
			byte b[]=new byte[maze.toByteArray().length];
			in.read(b);
			in.close();
			Maze3d loaded=new Maze3d(b);
			System.out.println("are the mazes simular ? " + loaded.equals(maze));
	}	



}
