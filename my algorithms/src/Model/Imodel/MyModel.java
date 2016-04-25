package Model.Imodel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.concurrent.ConcurrentHashMap;
import Model.IO.MyCompressorOutputStream;
import Model.IO.MyDecompressorInputStream;
import Model.algorithms.Search.BestFS;
import Model.algorithms.Search.BreadthFS;
import Model.algorithms.Search.DFS;
import Model.algorithms.Search.Searcher;
import Model.algorithms.Search.Solution;
import Model.algorithms.demo.MazeAdapter;
import Model.algorithms.mazeGenerators.Maze3d;
import Model.algorithms.mazeGenerators.myMaze3dGenerator;

import controller.Controller;

import java.lang.instrument.Instrumentation;


public class MyModel implements Model {
	private static final int BYTEARRAYSIZE = 10000;
	private Controller thecontroller;
	private ConcurrentHashMap<String, Maze3d> maze3dDB = new ConcurrentHashMap<String, Maze3d>();
	private ConcurrentHashMap<String, Solution> mazeSol = new ConcurrentHashMap<String, Solution>(); 
    private static Instrumentation instrumentation;

	
	public MyModel(Controller c) {
		this.thecontroller=c;
	}
	
	@Override
	public void generateMaze(String name , int cols , int rows , int floors) throws Exception{
		myMaze3dGenerator mg = new myMaze3dGenerator();
		try{
		Maze3d theMaze = mg.generate(cols, rows, floors);
		maze3dDB.put(name, theMaze);
		}catch(Exception e){
			e.printStackTrace();
		}
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
	public void loadFromFile(String name, String fileName) throws IOException {
		try {
			InputStream in = new MyDecompressorInputStream(new FileInputStream(fileName));
			byte b[]=new byte[BYTEARRAYSIZE];//            How to know how big the array should be?
			Arrays.fill( b, (byte) -1 );
			in.read(b);
			in.close();
			int pointer = BYTEARRAYSIZE/2;
			for (int i=0; i<BYTEARRAYSIZE;i++){
				if (!(b[pointer] ==-1)){
					pointer++;
				}
				else{
					pointer--;
					if (!(b[pointer] ==-1)){
						break;
				}
			}
			}
				byte c[]=new byte[pointer];
				for(int i=0; i<pointer;i++){
					c[i]= b[i];
				}
			
			Maze3d theMaze=new Maze3d(c);
			maze3dDB.put(name, theMaze);
		}
		 catch (FileNotFoundException e) {
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
	public String getSolution(String name) {
		return mazeSol.get(name).toString();
	}

	@Override
	public double getMazeSizeinFile(String name) throws IOException {
		saveToFile(name, "test.maz");
		File file =new File("test.maz");
		double bytes = 0;
		if(file.exists()){
			bytes = file.length();
		}
		else{
				 System.out.println("File does not exists!");
		}
		return bytes;
	}

	@Override
	public void solveMaze(String name, String theSearcher) {
		Maze3d theMaze = maze3dDB.get(name);
		MazeAdapter myAdapter = new MazeAdapter(theMaze);
		Searcher ser;
		Solution sol;
		if (theSearcher=="bestfs"){
			ser = new BestFS();
		}
		else if(theSearcher=="breadthfs"){
			ser = new BreadthFS();
			}
		else{
			ser = new DFS();
		}
		sol = ser.search(myAdapter);
		mazeSol.put(name, sol);
	}


	
	
	
	

}
