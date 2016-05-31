package Model.Imodel;

import java.io.IOException;

import Model.algorithms.Search.Searcher;
import Model.algorithms.Search.Solution;
import Model.algorithms.mazeGenerators.Maze3d;
import Presenter.Properties;

public interface Model {
	public void generateMaze(String name , int cols , int rows , int floors) throws Exception;
	public Maze3d displayMaze3D(String name);
	public int[][] displayCrossSectionByX(int x,String name);
	public int[][] displayCrossSectionByY(int x,String name);
	public int[][] displayCrossSectionByZ(int x, String name);
	public void saveToFile(String name, String fileName) throws IOException;
	public void loadFromFile(String name, String fileName)throws IOException;
	public long getMazeSize(String name);
	public double getMazeSizeinFile(String name)throws IOException;
	public void solveMaze(String name, String theSearcher);
	public Solution getSolution(String name);
	public void Exit();
	public String getMazeGeneretedMsg();
	public Maze3d getMaze(String name);
	public String getExitMSG();
	public String getSolutionMSG();
	public String getError();
	public void saveHashMap();
	public void loadHashMap();
	public Properties getProp();
}
