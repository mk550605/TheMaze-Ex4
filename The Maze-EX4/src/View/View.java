package View;

import java.io.IOException;
import java.util.HashMap;

import Model.algorithms.Search.Solution;
import Model.algorithms.mazeGenerators.Maze3d;
import Presenter.Command;
import Presenter.Properties;
/**
 * Interface for View
 * @author Michael Kratik & Tzipi Cabiri 
 * @version 1.0
 *
 */
public interface View {
	public void displayMessage(String message);
	public void start();	
	public void setProp(Properties p);
	public void displayMaze(Maze3d theMaze);
	public void setlistOfMazes(String listOfMazes);
	public void setSolution(Solution sol);
	public void startHint();
}
