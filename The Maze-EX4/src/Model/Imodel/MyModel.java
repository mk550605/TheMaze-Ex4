package Model.Imodel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Observable;
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



/**
 * Class Define all the Project Functionality available on the maze3d system logic 
 * @author Michael Kratik & Tzipi Cabiri 
 * @version 1.4
 * 
 *
 */
public class MyModel extends Observable implements Model {
	private ConcurrentHashMap<String, Maze3d> maze3dDB = new ConcurrentHashMap<String, Maze3d>();
	private ConcurrentHashMap<String, Solution> mazeSol = new ConcurrentHashMap<String, Solution>(); 
	private ArrayList<Thread> listOfThreads = new ArrayList<Thread>();
	private String mazeGeneretedMsg;
	private String solutionMSG;
	private String exitMSG;
	/**
	 * initialize the model
	 * @param c - thecontroller
	 */
	public MyModel() {
	}
	/**
	 * Generate a 3D maze with myMaze3dGenerator algoritem
	 * @param name - name of the maze
	 * @param cols - num of cols 
	 * @param rows - num of rows
	 * @param floors -num of floors
	 * @throws Exception
	 */
	@Override
	public void generateMaze(String name , int cols , int rows , int floors) throws Exception{
		Thread generateMaze = new Thread(new Runnable() {
			public void run() {
				myMaze3dGenerator mg = new myMaze3dGenerator();
				try{
				Maze3d theMaze = mg.generate(cols, rows, floors);
				maze3dDB.put(name, theMaze);
				mazeGeneretedMsg= "the maze " + name + " is ready \n";
				setChanged();
				notifyObservers("MazeDone");
				}catch(Exception e){
					e.printStackTrace();
				}
				
			}
		});
		generateMaze.start();
		listOfThreads.add(generateMaze);
	}
	
	public String getMazeGeneretedMsg(){
		return mazeGeneretedMsg;
	}
/**
 * Printing the maze
 * @param name - name of the maze
 * @return - String of the maze
 */
	@Override
	public String displayMaze3D(String name) {
		if(!maze3dDB.containsKey(name)){
			return "The Maze does not Exist";
		}
		Maze3d theMaze = maze3dDB.get(name);
		return theMaze.toString();
	}
	
	public Maze3d getMaze(String name){
		if(!maze3dDB.containsKey(name)){
			 //;
		}
		Maze3d theMaze = maze3dDB.get(name);
		return theMaze;
	}
	
	
/**
 * display the cross section by X definition on the selected col with maze name
 * @param x - definition of maze
 * @param name - maze name
 * @return - two definition array
 */
	@Override
	public int[][] displayCrossSectionByX(int x , String name) {
		if(!maze3dDB.containsKey(name)){
		//	thecontroller.getNotifyDone("The Maze does not Exist");
			return null;
		}
		Maze3d theMaze = maze3dDB.get(name);
		try {
			return theMaze.getCrossSectionByX(x);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * display the cross section by Y definition on the selected col with maze name
	 * @param x - definition of maze
	 * @param name - maze name
	 * @return - two definition array
	 */
	@Override
	public int[][] displayCrossSectionByY(int x, String name) {
		if(!maze3dDB.containsKey(name)){
		//	thecontroller.getNotifyDone("The Maze does not Exist");
			return null;
		}
		Maze3d theMaze = maze3dDB.get(name);
		try {
			return theMaze.getCrossSectionByY(x);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * display the cross section by Z definition on the selected col with maze name
	 * @param x - definition of maze
	 * @param name - maze name
	 * @return - two definition array
	 */
	@Override
	public int[][] displayCrossSectionByZ(int x, String name) {
		if(!maze3dDB.containsKey(name)){
		//	thecontroller.getNotifyDone("The Maze does not Exist");
			return null;
		}
		Maze3d theMaze = maze3dDB.get(name);
		try {
			return theMaze.getCrossSectionByZ(x);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;	
	}
/**
 * save the maze with the name to file with filename 
 * @param name - name of the maze
 * @param fileName - name of the file
 * @throws IOException
 */
	@Override
	public void saveToFile(String name, String fileName) throws IOException {
		if(!maze3dDB.containsKey(name)){
		//	thecontroller.getNotifyDone("The Maze does not Exist");
			
		}
		else{
			Maze3d theMaze = maze3dDB.get(name);
			FileOutputStream fOut = new FileOutputStream(fileName);
			OutputStream out=new MyCompressorOutputStream(fOut);
			byte[] date = theMaze.toByteArray();
			int size = date.length;
			out.write(size/255);
			out.write(size%255);
			out.write(date);
			out.flush();
			out.close();
			fOut.flush();
			fOut.close();
			}
		
	}
/**
 * the function load a 3D Maze from a File
 * @param name - Name of the 3Daze
 * @param fileName - Name of the Loaded File
 * @throws IOException
 */
	@Override
	public void loadFromFile(String name, String fileName) throws IOException {
		try {
			InputStream in = new MyDecompressorInputStream(new FileInputStream(fileName));
			int size = in.read();
			size *= 255;
			size += in.read();
			byte[] b =new byte[size];
			in.read(b);
			in.close();
			Maze3d theMaze=new Maze3d(b);
			maze3dDB.put(name, theMaze);
		}
		 catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		
	}
/**
 * 	getting the 3DMaze Object Size in the memory
 * @param name - Name Of the 3Dmaze
 * @return Long in bytes
 */
	@Override
	public long getMazeSize(String name) {
		Maze3d theMaze = maze3dDB.get(name);
		int size = theMaze.getCols() * theMaze.getRows();
		size = size * theMaze.getFloor();
		size = size + 9;
		size = size * 4;
		return size;
	}

	/**
	 * getting a solution of the 3DMaze 
	 * @param name - Name Of the 3Dmaze
	 * @return String of Solution
	 */
	@Override
	public String getSolution(String name) {
		return mazeSol.get(name).toString();
	}
	/**
	 * 
	 * getting the 3DMaze File Size
	 * @param name - Name Of the 3Dmaze
	 * @return double in bytes
	 * @throws IOException
	 */
	@Override
	public double getMazeSizeinFile(String name) throws IOException {
		saveToFile(name, "test.maz");
		File file =new File("test.maz");
		double bytes = 0;
		if(file.exists()){
			bytes = file.length();
		}
		try{
		file.delete();
		}catch(Exception e){
			System.out.println(e);
		}
		return bytes;
	}
/**
 * Solving the 3DMaze by the given Algorithm
 * @param name - name of 3DMaze
 * @param theSearcher - Searching Algorithm
 */
	@Override
	public void solveMaze(String name, String theSearcher) {
		Thread SolveThread = new Thread(new Runnable() {
			public void run() {
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
				solutionMSG = "the Solution of" + name + "is ready \n";
				setChanged();
				notifyObservers("SolutionisReady");
				//thecontroller.getNotifyDone("the Solution of" + name + "is ready \n");
			}
		});
			SolveThread.start();
			listOfThreads.add(SolveThread);
	}
	
	public String getSolutionMSG(){
		return solutionMSG;
	}
	@SuppressWarnings("deprecation")
	@Override
	public void Exit() {
		for (int i = 0; i < listOfThreads.size(); i++) {
			listOfThreads.get(i).stop();
		}
		exitMSG = "all Thread are stoped";
		setChanged();
		notifyObservers("canExit");
		//thecontroller.getNotifyDone("all Thread are stoped");
		
	}
	public String getExitMSG(){
		return exitMSG;
	}



}
