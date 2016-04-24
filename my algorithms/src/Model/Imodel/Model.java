package Model.Imodel;

import java.io.IOException;

import Model.algorithms.Search.Searcher;
import Model.algorithms.Search.Solution;

public interface Model {
	public void generateMaze(String name , int cols , int rows , int floors);
	public String displayMaze3D(String name);
	public int[][] displayCrossSectionByX(int x,String name);
	public int[][] displayCrossSectionByY(int x,String name);
	public int[][] displayCrossSectionByZ(int x, String name);
	public void saveToFile(String name, String fileName) throws IOException;
	public void loadFromFile(String name, String fileName)throws IOException;
	public long getMazeSize(String name);
	public double getMazeSizeinFile(String name)throws IOException;
	public void solveMaze(String name, String theSearcher);
	public String getSolution(String name);
	
}
