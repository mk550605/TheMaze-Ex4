package Model.Imodel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.concurrent.ConcurrentHashMap;
import Model.IO.MyCompressorOutputStream;
import Model.IO.MyDecompressorInputStream;
import Model.algorithms.mazeGenerators.Maze3d;
import Model.algorithms.mazeGenerators.myMaze3dGenerator;
import controller.Controller;
import java.lang.instrument.Instrumentation;


public class MyModel implements Model {
	private Controller thecontroller;
	private ConcurrentHashMap<String, Maze3d> maze3dDB;
    private static Instrumentation instrumentation;

	
	public MyModel(Controller c) {
		this.thecontroller=c;
	}
	
	@Override
	public void generateMaze(String name , int cols , int rows , int floors){
		myMaze3dGenerator mg = new myMaze3dGenerator();
		Maze3d theMaze = mg.generate(cols, rows, floors);
		maze3dDB.put(name, theMaze);
	}

	@Override
	public String displayMaze3D(String name) {
		Maze3d theMaze = maze3dDB.get(name);
		return theMaze.toString();
	}

	@Override
	public int[][] displayCrossSectionByX(int x , String name) {
		Maze3d theMaze = maze3dDB.get(name);
		try {
			return theMaze.getCrossSectionByX(x);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;	
	}

	@Override
	public int[][] displayCrossSectionByY(int x, String name) {
		Maze3d theMaze = maze3dDB.get(name);
		try {
			return theMaze.getCrossSectionByY(x);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	

	@Override
	public int[][] displayCrossSectionByZ(int x, String name) {
		Maze3d theMaze = maze3dDB.get(name);
		try {
			return theMaze.getCrossSectionByZ(x);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;	
	}

	@Override
	public void saveToFile(String name, String fileName) throws IOException {
		Maze3d theMaze = maze3dDB.get(name);
		OutputStream out=new MyCompressorOutputStream(new FileOutputStream(fileName));
		out.write(theMaze.toByteArray());
		out.flush();
		out.close();
		
	}

	@Override
	public void loadFromFile(String name, String fileName) {
		try {
			InputStream in = new MyDecompressorInputStream(new FileInputStream("1.maz"));
			byte b[]=new byte[maze.toByteArray().length];                        //            How to know how big the array should be?
			in.read(b);
			in.close();
			Maze3d theMaze=new Maze3d(b);
			maze3dDB.put(name, theMaze);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public long getMazeSize(String name) {
		Maze3d theMaze = maze3dDB.get(name);
		return instrumentation.getObjectSize(theMaze);
	}

	@Override
	public long getFileSize(String fileName) {
	
		return 0;
	}

	@Override
	public String getSolution(String name) {
		// TODO Auto-generated method stub
		return null;
	}


	
	
	
	

}
