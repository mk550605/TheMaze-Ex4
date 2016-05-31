package View;

import java.io.IOException;
import java.util.HashMap;

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
	void displayMessage(String message);
	void start();	
	void setProp(Properties p);
	void displayMaze(Maze3d theMaze);
}
