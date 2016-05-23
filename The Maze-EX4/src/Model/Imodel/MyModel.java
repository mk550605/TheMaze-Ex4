package Model.Imodel;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.Observable;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

import Model.IO.MyCompressorOutputStream;
import Model.IO.MyDecompressorInputStream;
import Model.algorithms.Search.BestFS;
import Model.algorithms.Search.BreadthFS;
import Model.algorithms.Search.DFS;
import Model.algorithms.Search.Searcher;
import Model.algorithms.Search.Solution;
import Model.algorithms.demo.MazeAdapter;
import Model.algorithms.mazeGenerators.Maze3d;


/**
 * Class Define all the Project Functionality available on the maze3d system logic 
 * @author Michael Kratik & Tzipi Cabiri 
 * @version 1.4
 * 
 *
 */
public class MyModel extends Observable implements Model {
	private static int THREADNUM =20;
//	protected ConcurrentHashMap<String, Maze3d> maze3dDB = new ConcurrentHashMap<String, Maze3d>();
//	private ConcurrentHashMap<String, Solution> mazeSol = new ConcurrentHashMap<String, Solution>(); 
	private ConcurrentHashMap<String,Pair<Maze3d, Solution>> DB = new  ConcurrentHashMap<String,Pair<Maze3d, Solution>>() ;
	protected String mazeGeneretedMsg;
	private String solutionMSG;
	protected String Error;
	private String exitMSG;
	ExecutorService executor = Executors.newFixedThreadPool(THREADNUM);
	

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
	public void generateMaze(String name , int cols , int rows , int floors) {
		if(!DB.containsKey(name)){
			try{
				Callable<Maze3d> GenTask = new Gen3DMazeCallable( cols, rows, floors);
				Future<Maze3d> theMaze = executor.submit(GenTask);
				putToMazeDB(theMaze.get(), name);
				
			}catch(Exception e){
					Error= "problem to Generate 3Dmaze \n" +e;
					setChanged();
					notifyObservers("Error");
			}
		}else{
			Error= "problem to Generate 3Dmaze - Maze with this name already exists \n" ;
			setChanged();
			notifyObservers("Error");
		}
	}
	
	/**
	 * Solving the 3DMaze by the given Algorithm
	 * @param name - name of 3DMaze
	 * @param theSearcher - Searching Algorithm
	 */
		@Override
		public void solveMaze(String name, String theSearcher) {
			
			if(DB.containsKey(name)){
				if(DB.get(name).sol==null){
					try{
						Maze3d theMaze = DB.get(name).maze;
						MazeAdapter myAdapter = new MazeAdapter(theMaze);
						Searcher ser;
						if (theSearcher=="bestfs"){
							ser = new BestFS();
						}
						else if(theSearcher=="breadthfs"){
							ser = new BreadthFS();
							}
						else{
							ser = new DFS();
						}
					
						Callable<Solution> genSol =new Solve3DMazeCallable(myAdapter,ser);
						Future<Solution> solution = executor.submit(genSol);
						DB.get(name).sol=solution.get();
						solutionMSG = "the Solution of " + name + " is ready \n";
						setChanged();
						notifyObservers("SolutionisReady");
					}catch(Exception e){
						Error= "problem to Solve 3Dmaze \n" +e;
						setChanged();
						notifyObservers("Error");
					}
				}else{
					solutionMSG = "the Solution of " + name + " exists and ready \n";
					setChanged();
					notifyObservers("SolutionisReady");
				}
			}
			else{
				Error= "Maze does not exist \n" ;
				setChanged();
				notifyObservers("Error");
			}
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
		if(!DB.containsKey(name)){
			Error= "Maze does not exist  ";
			setChanged();
			notifyObservers("Error");
		}
		Maze3d theMaze = DB.get(name).maze;
		return theMaze.toString();
	}
	
	public Maze3d getMaze(String name){
		if(!DB.containsKey(name)){
			Error= "Maze does not exist  ";
			setChanged();
			notifyObservers("Error");
		}
		Maze3d theMaze = DB.get(name).maze;
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
		if(!DB.containsKey(name)){
			Error= "Maze does not exist  ";
			setChanged();
			notifyObservers("Error");
			return null;
		}
		Maze3d theMaze = DB.get(name).maze;
		try {
			return theMaze.getCrossSectionByX(x);
		} catch (Exception e) {
			Error= "Error Getting CrossSectionByX " +e.toString();
			setChanged();
			notifyObservers("Error");
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
		if(!DB.containsKey(name)){
			Error= "Maze does not exist  ";
			setChanged();
			notifyObservers("Error");
			return null;
		}
		Maze3d theMaze = DB.get(name).maze;
		try {
			return theMaze.getCrossSectionByY(x);
		} catch (Exception e) {
			Error= "Error Getting CrossSectionByY " +e.toString();
			setChanged();
			notifyObservers("Error");
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
		if(!DB.containsKey(name)){
			Error= "Maze does not exist  ";
			setChanged();
			notifyObservers("Error");
			return null;
		}
		Maze3d theMaze = DB.get(name).maze;
		try {
			return theMaze.getCrossSectionByZ(x);
		} catch (Exception e) {
			Error= "Error Getting CrossSectionByZ " +e.toString();
			setChanged();
			notifyObservers("Error");
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
		if(!DB.containsKey(name)){
			Error= "Maze does not exist  ";
			setChanged();
			notifyObservers("Error");
		}
		else{
			Maze3d theMaze = DB.get(name).maze;
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
		InputStream in = null;
		try {
			 in = new MyDecompressorInputStream(new FileInputStream(fileName));
		}
			 catch (FileNotFoundException e) {
				 	Error= "File does not Exist";
					setChanged();
					notifyObservers("Error");
			 }
		try{
			int size = in.read();
			size *= 255;
			size += in.read();
			byte[] b =new byte[size];
			in.read(b);
			in.close();
			Maze3d theMaze=new Maze3d(b);
			DB.put(name, new Pair<Maze3d, Solution>(theMaze, null));
		}
		 catch (FileNotFoundException e) {
			 	Error= "Error Loading File";
				setChanged();
				notifyObservers("Error");
		}
		
		
	}
/**
 * 	getting the 3DMaze Object Size in the memory
 * @param name - Name Of the 3Dmaze
 * @return Long in bytes
 */
	@Override
	public long getMazeSize(String name) {
		if(!DB.containsKey(name)){
			Error= "Maze does not exist  ";
			setChanged();
			notifyObservers("Error");
			return -1;
		}
		Maze3d theMaze = DB.get(name).maze;
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
	public Solution getSolution(String name) {
		if(!DB.containsKey(name)){
			Error= "Maze does not exist  ";
			setChanged();
			notifyObservers("Error");
			return null;
		}
		if(DB.get(name).sol==null){
			Error= "Solution does not exist  ";
			setChanged();
			notifyObservers("Error");
			return null;
		}
		return DB.get(name).sol;
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

	
	public String getSolutionMSG(){
		return solutionMSG;
	}
	@SuppressWarnings("deprecation")
	@Override
	public void Exit() {
		executor.shutdown();
		exitMSG = "all Thread are stoped";
		setChanged();
		notifyObservers("canExit");
		//thecontroller.getNotifyDone("all Thread are stoped");
		
	}
	public String getExitMSG(){
		return exitMSG;
	}
	
	public String getError(){
		return Error;
	}
	
	protected void putToMazeDB(Maze3d themaze, String name){
		DB.put(name, new Pair<Maze3d, Solution>(themaze, null));
		mazeGeneretedMsg= "the maze " + name + " is ready \n";
		setChanged();
		notifyObservers("MazeDone");
	}
	public void saveHashMap(){
		 try
	      {
			 // Convert DB to byte array
			 ByteArrayOutputStream dbByteOut = new ByteArrayOutputStream();
	         ObjectOutputStream dbOut = new ObjectOutputStream(dbByteOut);
	         dbOut.writeObject(DB);
	         
	         // Compress DB with GZip
			 byte[] dbCompressed = compressWithGZip(dbByteOut.toByteArray());
			 
			 // Save compressed DB to file
	         FileOutputStream fileOut = new FileOutputStream("Mazes.DB");
	         ObjectOutputStream out = new ObjectOutputStream(fileOut);
	         out.write(dbCompressed);
	         out.close();
	         fileOut.close();
	      }catch(Exception e)
	      {
	          e.printStackTrace();
	      }
	}
	
	public static byte[] compressWithGZip(byte[] array) throws Exception {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        GZIPOutputStream gzipOutputStream = new GZIPOutputStream(out);
        gzipOutputStream.write(array);
        gzipOutputStream.close();
        return out.toByteArray();
    }
 
	
	public static byte[] decompressWithGZip(byte[] array) throws Exception{
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
	    GZIPInputStream inputStream = new GZIPInputStream(new ByteArrayInputStream(array));
	    byte[] buffer = new byte[1024];
	    while (inputStream.read(buffer) != -1)
	    {
	        outputStream.write(buffer);
	    }
	    outputStream.close();
	    return outputStream.toByteArray();
	}
		
	public void loadHashMap(){
		  try
		  {
			  ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
			  FileInputStream fileIn = new FileInputStream("Mazes.DB");
			  
			byte[] buffer = new byte[1024];
			while (fileIn.read(buffer) != -1)
			{
			    outputStream.write(buffer);
			}
//			outputStream.close();
			fileIn.close();
			Error = Integer.toString(outputStream.toByteArray().length) ;
			setChanged();
			notifyObservers("Error");
			
			 byte[] dbDecompressed = decompressWithGZip(outputStream.toByteArray());
			
			 ByteArrayInputStream in = new ByteArrayInputStream(dbDecompressed);
			 ObjectInputStream is = new ObjectInputStream(in);
	         DB = (ConcurrentHashMap<String, Pair<Maze3d,Solution>>) is.readObject();
		  }catch(Exception i)
		  {
		     i.printStackTrace();
		  }
	}
	      
	
}
