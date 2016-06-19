package Presenter.CommandsView;

import java.io.IOException;

import Model.Imodel.Model;
import Presenter.Command;
import View.View;
/**
 * 
 * @author Michael Kratik & Tzipi Cabiri
 *display the Maze Ready MSG on GUI
 */
	
public class DisplayMazeReadyMessageCommand implements Command {

	/**
	 * display the maze Ready MSG on GUI
	 */
	@Override
	public void doCommand(String[] args, Model model, View view) throws IOException {
	view.displayMessage(model.getMazeGeneretedMsg());
	view.setlistOfMazes(model.getMazesList());
	}

}
  