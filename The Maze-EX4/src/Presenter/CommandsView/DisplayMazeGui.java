package Presenter.CommandsView;

import java.io.IOException;

import Model.Imodel.Model;
import Model.algorithms.mazeGenerators.Maze3d;
import Presenter.Command;
import View.View;
/**
 * 
 * @author Michael Kratik & Tzipi Cabiri
 *command to display maze on GUI
 */
public class DisplayMazeGui implements Command {
	/**
	 * getting the maze from model and display it on GUI
	 */
	@Override
	public void doCommand(String[] args, Model model, View view) throws IOException {
		Maze3d theMaze = model.getMaze(args[0]);
		view.displayMaze(theMaze);
		
	}

}
